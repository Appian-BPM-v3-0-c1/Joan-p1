package com.revature.beyondcon.ui;

import com.revature.beyondcon.models.Attendee;
import com.revature.beyondcon.models.Cart;
import com.revature.beyondcon.models.ContactInfo;
import com.revature.beyondcon.models.Tickets;
import com.revature.beyondcon.services.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CartMenu implements IMenu {

    private final CartService cartService;
    private final ConsService consService;
    private final TicketsService ticketsService;
    private final ContactInfoService contactInfoService;
    private final Attendee attendee;

    public CartMenu(CartService cartService, ConsService consService, TicketsService ticketsService, ContactInfoService contactInfoService, Attendee attendee) {
        this.cartService = cartService;
        this.consService = consService;
        this.ticketsService = ticketsService;
        this.contactInfoService = contactInfoService;
        this.attendee = attendee;
    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nSelect your ticket from the following list:");

        System.out.println("\n[1] Pre-Con Ticket (half-day only) – $40 – " + ticketsService.getTicketsDAO().findById(1).getTotalTickets() + " tickets remaining");
        System.out.println("[2] Day 1 Full Convention (first day only) – $120 – " + ticketsService.getTicketsDAO().findById(2).getTotalTickets() + " tickets remaining");
        System.out.println("[3] Day 2 Full Convention (second day only) – $120 – " + ticketsService.getTicketsDAO().findById(3).getTotalTickets() + " tickets remaining");
        System.out.println("[4] Days 1 and 2 Full Convention (two days only) – $180 – " + ticketsService.getTicketsDAO().findById(4).getTotalTickets() + " tickets remaining");
        System.out.println("[5] Day 1 Full Convention plus Pre-Con – $140 – " + ticketsService.getTicketsDAO().findById(5).getTotalTickets() + " tickets remaining");
        System.out.println("[6] Day 2 Full Convention plus Pre-Con – $140 – " + ticketsService.getTicketsDAO().findById(6).getTotalTickets() + " tickets remaining");
        System.out.println("[7] Days 1 and 2 Full Convention plus Pre-Con – $200 – " + ticketsService.getTicketsDAO().findById(7).getTotalTickets() + " tickets remaining");
        System.out.println("[8] VIP Full Convention Experience – $460 – " + ticketsService.getTicketsDAO().findById(8).getTotalTickets() + " tickets remaining");
        System.out.println("[x] Go back to previous menu");

        System.out.print("\nEnter: ");
        char input = scan.next().charAt(0);

        switch (input) {
            case '1':
                cart(findById(1));
                break;
            case '2':
                cart(findById(2));
                break;
            case '3':
                cart(findById(3));
                break;
            case '4':
                cart(findById(4));
                break;
            case '5':
                cart(findById(5));
                break;
            case '6':
                cart(findById(6));
                break;
            case '7':
                cart(findById(7));
                break;
            case '8':
                cart(findById(8));
                break;
            case 'x':
                break;
            default:
                System.out.println("\nInvalid input!");
                start();
                break;
        }
    }

    public Tickets findById(int input) {
        Tickets ticket = ticketsService.getTicketsDAO().findById(input);
        return ticket;
    }

    public void cart(Tickets ticket) {
        System.out.println("\nYou have selected a " + ticket.getTicketType() + " ticket!");

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("You will be sent an invoice for $" + df.format(ticket.getPrice()) + ".");

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
        System.out.println(contact.getEmail());

        System.out.println("\nWould you like to save your ticket cart (y/n)?");
        System.out.print("\nEnter: ");
        char input = scan.nextLine().charAt(0);

        switch (input) {
            case 'y':
                saveCart(ticket);
                break;
            case 'n':
                start();
                break;
            default:
                System.out.println("\nInvalid input!");
                break;
        }
    }

    public void saveCart(Tickets ticket) {
        Cart cart = new Cart();
        int attendeeId = attendee.getId();
        int ticketId = ticket.getId();

        cart.setAttendeeId(attendeeId);
        cart.setTicketId(ticketId);

        cartService.getCartDAO().save(cart);
        System.out.println("\nYour ticket cart has been saved! Come back when you're ready to finalize your purchase!");
    }

}