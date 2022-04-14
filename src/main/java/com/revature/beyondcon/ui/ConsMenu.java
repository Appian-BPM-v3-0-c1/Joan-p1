package com.revature.beyondcon.ui;

import com.revature.beyondcon.models.Attendee;
import com.revature.beyondcon.models.Cons;
import com.revature.beyondcon.models.Events;
import com.revature.beyondcon.services.ConsService;

import java.util.List;
import java.util.Scanner;

public class ConsMenu implements IMenu {

    private final ConsService consService;
    private final Attendee attendee;

    public ConsMenu(ConsService consService, Attendee attendee) {
        this.consService = consService;
        this.attendee = attendee;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {
            System.out.println("\nWelcome to the list of all BeyondCon 2023 conventions across the United States and Canada.");
            System.out.println("\n[1] View all active conventions");
            System.out.println("[2] Search all active conventions");
            System.out.println("[3] Create new BeyondCon 2023 convention");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllCons();
                    break;
                case '2':
                    break;
                case '3':
                    createCon();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }

    private void createCon() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        Cons con = new Cons();

        while(!exit) {
            boolean confirm = false;
            System.out.print("\nEnter new convention city: ");
            con.setCity(scan.nextLine().toLowerCase());
            System.out.print("Enter new convention state: ");
            con.setState(scan.nextLine().toLowerCase());
            System.out.print("Enter new convention start date (MM/DD): ");
            con.setDate(scan.nextLine() + "/2023");

            while(!confirm) {
                System.out.println("\nIs the following information correct? (y/n)");
                System.out.println(con);
                System.out.print("\nEnter: ");

                input = scan.nextLine().charAt(0);
                switch (input) {
                    case 'y':
                        consService.getConsDAO().save(con);
                        System.out.println("\nA new BeyondCon 2023 convention in " + con.getCity() + " has been created successfully!");
                        exit = true;
                        confirm = true;
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

    private void viewAllCons() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Cons> consList = consService.getConsDAO().findAll();

        System.out.println();
        for (int i = 0; i < consList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + consList.get(i).getCity() + ", " + consList.get(i).getState());
        }

        while (true) {
            System.out.print("\nSelect a city to view all events for that convention: ");

            input = scan.nextInt() - 1;

            if (input > consList.size()) {
                System.out.println("\nInvalid input!");
            } else {
                List<Events> eventsList = consService.getEventsDAO().findByConId(consList.get(input).getId());
                System.out.println("\n" + consList.get(input));
                for (Events event : eventsList) {
                    System.out.println(event);
                }
                break;
            }
        }

        /* Working on this:
        input = scan.next().charAt(0);

        if (Integer.parseInt(input) - 1 == consList.get(0)) {

        }

        */

        /* List all conventions.
        for(Cons cons : consList) {
            System.out.println("\n" + cons);
        }
        */
    }

    /* List 5 conventions per input.
    private void listFiveCons() {
        int count  = 5;
        List<Cons> consList = crudDAO.findAll();
        for (int i = 0; i < consList.size(); i++) {
            if (i < count) {
                System.out.println(consList.get(i));
                count += 5;
            }
        }
    }
    */

}
