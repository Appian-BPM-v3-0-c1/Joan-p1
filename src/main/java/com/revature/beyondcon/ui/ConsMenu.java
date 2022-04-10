package com.revature.beyondcon.ui;

import com.revature.beyondcon.daos.ConsDAO;
import com.revature.beyondcon.daos.CrudDAO;
import com.revature.beyondcon.models.Cons;

import java.util.Scanner;

public class ConsMenu implements IMenu {

    CrudDAO<Cons> crudDAO = new ConsDAO();

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {
            System.out.println("\nWelcome to the list of all BeyondCon 2023 conventions across the United States and Canada.");
            System.out.println("\n[1] List all active conventions");
            System.out.println("[2] Search all active conventions");
            System.out.println("[3] Create new BeyondCon 2023 convention");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
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
                        crudDAO.save(con);
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

}
