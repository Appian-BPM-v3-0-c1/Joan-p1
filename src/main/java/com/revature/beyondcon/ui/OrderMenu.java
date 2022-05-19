package com.revature.beyondcon.ui;

import com.revature.beyondcon.daos.TicketsDAO;
import com.revature.beyondcon.models.*;
import com.revature.beyondcon.services.CartService;
import com.revature.beyondcon.services.ContactInfoService;
import com.revature.beyondcon.services.OrderService;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class OrderMenu implements IMenu {

    private final OrderService orderService;
    private final CartService cartService;
    private final TicketsDAO ticketsDAO;
    private final Tickets tickets;
    private final ContactInfoService contactInfoService;
    private final Attendee attendee;

    public OrderMenu(OrderService orderService, CartService cartService, TicketsDAO ticketsDAO, Tickets tickets, ContactInfoService contactInfoService, Attendee attendee) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.ticketsDAO = ticketsDAO;
        this.tickets = tickets;
        this.contactInfoService = contactInfoService;
        this.attendee = attendee;
    }

    @Override
    public void start() {
        boolean exit = false;

        while (!exit) {
            Scanner scan = new Scanner(System.in);

            System.out.println("\nWelcome to the final ordering page!");

            System.out.println("\n[1] View your last saved cart");
            System.out.println("[2] Finalize your current purchase");
            System.out.println("[3] View prior purchases");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            char input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    findByAttendeeId(attendee.getId());
                    break;
                case '2':
                    purchaseTicket(attendee.getId());
                    break;
                case '3':
                    viewHistory(attendee.getId());
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    start();
                    break;
            }
        }
    }

    public void findByAttendeeId(int attendeeId) {
        Cart cart = cartService.getCartDAO().findByAttendeeId(attendeeId);

        System.out.println("\nYour last saved ticket cart is below:");
        System.out.println("\nYou have elected a " + ticketsDAO.findById(cart.getTicketId()).getTicketType() + " ticket.");
        System.out.println("The price of this ticket is $" + ticketsDAO.findById(cart.getTicketId()).getPrice() + "0.");

        System.out.println("\nThere are only " + ticketsDAO.findById(cart.getTicketId()).getTotalTickets() + " tickets of this type left!");
        System.out.println("Don't let this opportunity pass you by! Purchase your ticket now!");

        start();
    }

    public void purchaseTicket(int attendeeId) {
        Cart cart = cartService.getCartDAO().findByAttendeeId(attendeeId);

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\nYou will be sent an invoice for $" + df.format(ticketsDAO.findById(cart.getTicketId()).getPrice()) + ".");

        System.out.println("\nYour invoice will be sent to the following mailing information:");

        ContactInfo contact = contactInfoService.getContactInfoDAO().getByAttendeeId(attendee.getId());

        String spNamePrefix = "";
        String spMiddleName = "";
        String spLastName = " " + contact.getLastName();
        String spNameSuffix = "";
        Scanner scan = new Scanner(System.in);

        if (contact.getNamePrefix().trim().isEmpty()) {
            spNamePrefix = "";
        } else {
            spNamePrefix = contact.getNamePrefix().trim() + " ";
        }

        if (contact.getMiddleName().trim().isEmpty()) {
            spMiddleName = "";
        } else {
            spMiddleName = " " + contact.getMiddleName().trim();
        }

        if (contact.getNameSuffix().trim().isEmpty()) {
            spNameSuffix = "";
        } else {
            spNameSuffix = " " + contact.getNameSuffix().trim();
        }

        String fullName = spNamePrefix + contact.getFirstName().trim() + spMiddleName + spLastName;
        String mailingAddress = contact.getSmAddress();
        String mailingAddress2 = contact.getCity() + ", " + contact.getState();

        String[] nFullName = fullName.split(" ");
        for (int i = 0; i < nFullName.length; i++) {
            nFullName[i] = nFullName[i].substring(0, 1).toUpperCase() + nFullName[i].substring(1);
        }
        String jFullName = String.join(" ", nFullName);

        String[] nMailingAddress = mailingAddress.split(" ");
        for (int j = 0; j < nMailingAddress.length; j++) {
            nMailingAddress[j] = nMailingAddress[j].substring(0, 1).toUpperCase() + nMailingAddress[j].substring(1);
        }
        String jMailingAddress = String.join(" ", nMailingAddress);

        String[] nMailingAddress2 = mailingAddress2.split(" ");
        for (int k = 0; k < nMailingAddress2.length; k++) {
            nMailingAddress2[k] = nMailingAddress2[k].substring(0, 1).toUpperCase() + nMailingAddress2[k].substring(1);
        }
        String jMailingAddress2 = String.join(" ", nMailingAddress2);

        System.out.println("\n" + jFullName + spNameSuffix.toUpperCase());
        System.out.println(jMailingAddress);
        System.out.println(jMailingAddress2 + " " + contact.getZip());

        System.out.println("\nA copy of your invoice will be sent to the following email address:");
        System.out.println("\n" + contact.getEmail());

        System.out.println("\nWould you like to save your ticket cart (y/n)?");
        System.out.print("\nEnter: ");
        char input = scan.nextLine().charAt(0);

        switch (input) {
            case 'y':
                saveOrder(cart);
                ticketsDAO.subtractTicket(cart.getTicketId());
                break;
            case 'n':
                start();
                break;
            default:
                System.out.println("\nInvalid input!");
                break;
        }
    }

    public void saveOrder(Cart cart) {
        Order order = new Order();

        DateTimeFormatter dateDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        int attendeeId = attendee.getId();
        int ticketId = ticketsDAO.findById(cart.getTicketId()).getId();

        order.setTransDate(dateDtf.format(now));
        order.setTransTime(timeDtf.format(now));
        order.setAttendeeId(attendeeId);
        order.setTicketId(ticketId);

        orderService.getOrderDAO().save(order);
        System.out.println("\nYour purchase is complete! We look forward to seeing you soon!");

        cartService.getCartDAO().deleteCart(cart);
    }

    public void viewHistory(int attendeeId) {
        List<Order> orders = orderService.getOrderDAO().findByAttendeeId(attendeeId);
        System.out.println("\nYour order history is listed below:");

        for (Order order : orders) {
            System.out.println("\n" + order);
            System.out.println("Ticket: " + ticketsDAO.findById(order.getTicketId()).getTicketType());
            System.out.println("Total Price: " + ticketsDAO.findById(order.getTicketId()).getPrice() + "0");
        }

        start();
    }

}
