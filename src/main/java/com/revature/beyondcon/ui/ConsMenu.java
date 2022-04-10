package com.revature.beyondcon.ui;

import com.revature.beyondcon.daos.ConsDAO;
import com.revature.beyondcon.daos.CrudDAO;
import com.revature.beyondcon.daos.EventsDAO;
import com.revature.beyondcon.models.Cons;
import com.revature.beyondcon.models.Events;

import java.util.List;
import java.util.Scanner;

public class ConsMenu implements IMenu {

    CrudDAO<Cons> consDAO = new ConsDAO();
    CrudDAO<Events> eventsCrudDAO = new EventsDAO();

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
                        consDAO.save(con);
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
        Events events = new Events();
        List<Cons> consList = consDAO.findAll();

        System.out.println();
        for (int i = 0; i < consList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + consList.get(i).getCity() + ", " + consList.get(i).getState());
        }

        while (true) {
            System.out.print("\nSelect a city to view all events for that convention: ");

            input = scan.nextInt();
            if (input > consList.size()) {
                System.out.println("\nInvalid input!");
            } else {
                events = eventsCrudDAO.findById(consList.get(input - 1).getId());
                System.out.println("\n" + consList.get(input - 1));
                System.out.println(events);
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
