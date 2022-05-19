package com.revature.beyondcon.ui;

import com.revature.beyondcon.daos.*;
import com.revature.beyondcon.models.*;
import com.revature.beyondcon.services.*;

import java.util.Scanner;

public class MainMenu implements IMenu {

    private final Attendee attendee;
    private final ContactInfoService contactInfoService;

    public MainMenu(Attendee attendee, ContactInfoService contactInfoService) {
        this.attendee = attendee;
        this.contactInfoService = contactInfoService;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        int attendeeId = attendee.getId();
        int fContactId = contactInfoService.getContactInfoDAO().getByAttendeeId(attendeeId).getAttendeeId();

        String attendeeName;

        if (fContactId != 0) {
            String nFirstName = contactInfoService.getContactInfoDAO().getByAttendeeId(attendeeId).getFirstName().substring(0, 1).toUpperCase() + contactInfoService.getContactInfoDAO().getByAttendeeId(attendeeId).getFirstName().substring(1);
            attendeeName = nFirstName;
        } else {
            attendeeName = attendee.getUsername();
        }

        while(!exit) {
            System.out.println("\nWelcome to BeyondCon 2023, " + attendeeName + "!");
            System.out.println("\n[1] Go to Conventions menu");
            System.out.println("[2] Save your contact information");
            System.out.println("[3] Save a con ticket to your cart");
            System.out.println("[4] Finalize your ticket cart and view your prior purchases");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new ConsMenu(new ConsService(new ConsDAO(), new EventsDAO()), attendee).start();
                    break;
                case '2':
                    if (fContactId != 0) {
                        System.out.println("\nWe already have your contact information!");
                    } else {
                        saveContactInfo();
                    }
                    break;
                case '3':
                    new CartMenu(new CartService(new CartDAO(), new ConsDAO(), new ContactInfoDAO(), new AttendeeDAO()), new ConsService(new ConsDAO(), new EventsDAO()), new TicketsService(new TicketsDAO()), new ContactInfoService(new ContactInfoDAO(), new AttendeeDAO()), attendee).start();
                    break;
                case '4':
                    new OrderMenu(new OrderService(new CartDAO(), new ContactInfoDAO(), new OrderDAO()), new CartService(new CartDAO(), new ConsDAO(), new ContactInfoDAO(), new AttendeeDAO()), new TicketsDAO(), new Tickets(), new ContactInfoService(new ContactInfoDAO(), new AttendeeDAO()), attendee).start();
                    break;
                case 'x':
                    exit = true;
                    System.out.println("\nThank you for visiting us. Follow us on Twitter at @beyondcon23 for more updates! Have a great day!");
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }

    public void saveContactInfo() {
        Scanner scan = new Scanner(System.in);
        ContactInfo contact = new ContactInfo();
        String namePrefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String nameSuffix = "";
        String email = "";
        String smAddress = "";
        String city = "";
        String state = "";
        String zip = "";
        String telephone = "";

        System.out.println("\nPreparing to save your contact information...");

        boolean exit = false;
        while (!exit) {

            System.out.print("\nEnter your first name: ");
            firstName = scan.nextLine().toLowerCase();
            contact.setFirstName(firstName);

            System.out.print("\nEnter your middle name (if any) or hit the ENTER key to continue: ");
            middleName = scan.nextLine().toLowerCase();
            contact.setMiddleName(middleName);

            System.out.print("\nEnter your last name: ");
            lastName = scan.nextLine().toLowerCase();
            contact.setLastName(lastName);

            System.out.print("\nDoes your name have a prefix (e.g., Mr. Ms., Dr.)? If so, enter it now or hit the ENTER key to continue: ");
            namePrefix = scan.nextLine().toLowerCase();
            contact.setNamePrefix(namePrefix);

            System.out.print("\nDoes your name have a suffix (e.g., Jr., Sr., III, PhD)? If so, enter it now or hit the ENTER key to continue: ");
            nameSuffix = scan.nextLine().toLowerCase();
            contact.setNameSuffix(nameSuffix);

            System.out.print("\nEnter your email address: ");
            email = scan.nextLine().toLowerCase();
            contact.setEmail(email);

            System.out.print("\nEnter your mailing address (not including city, state, and ZIP): ");
            smAddress = scan.nextLine().toLowerCase();
            contact.setSmAddress(smAddress);

            System.out.print("\nEnter your home city: ");
            city = scan.nextLine().toLowerCase();
            contact.setCity(city);

            System.out.print("\nEnter your home state: ");
            state = scan.nextLine().toLowerCase();
            contact.setState(state);

            System.out.print("\nEnter your ZIP code: ");
            zip = scan.nextLine().toLowerCase();
            contact.setZip(zip);

            System.out.print("\nEnter your telephone number: ");
            telephone = scan.nextLine().toLowerCase();
            contact.setTelephone(telephone);

            contact.setAttendeeId(attendee.getId());

            String spNamePrefix = "";
            String spMiddleName = "";
            String spLastName = " " + lastName;
            String spNameSuffix = "";

            if (namePrefix.isEmpty()) {
                spNamePrefix = "";
            } else {
                spNamePrefix = namePrefix + " ";
            }

            if (middleName.isEmpty()) {
                spMiddleName = "";
            } else {
                spMiddleName = " " + middleName;
            }

            if (nameSuffix.isEmpty()) {
                spNameSuffix = "";
            } else {
                spNameSuffix = " " + nameSuffix;
            }

            String fullName = spNamePrefix + firstName + spMiddleName + spLastName;
            String mailingAddress = smAddress + ", " + city + ", " + state;

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

            boolean confirm = false;
            while(!confirm) {
                System.out.println("\nPlease confirm your contact information below (y/n).");
                System.out.println("\nFull Name: " + jFullName + spNameSuffix.toUpperCase());
                System.out.println("Email Address: " + email);
                System.out.println("Mailing Address: " + jMailingAddress + " " + zip);
                System.out.println("Telephone Number: " + telephone);
                System.out.print("\nEnter: ");
                char input = scan.nextLine().charAt(0);

                switch (input) {
                    case 'y':
                        contactInfoService.getContactInfoDAO().save(contact);
                        System.out.println("\nYour contact information was saved successfully!");
                        confirm = true;
                        exit = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }

    }

}
