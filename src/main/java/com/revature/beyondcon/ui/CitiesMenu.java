package com.revature.beyondcon.ui;

import com.revature.beyondcon.models.Cities;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class CitiesMenu implements IMenu {

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {
            System.out.println("\nWelcome to the list of all 2022 BeyondCon cities!");
            System.out.println("\n[1] List all cities");
            System.out.println("[2] Search all cities");
            System.out.println("[3] Create new convention");
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
                    System.out.println("\nThank you for using BeyondCon Registration. Have a great day!");
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
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        Cities city = new Cities();

        while(!exit) {
            System.out.println("\nCreating new BeyondCon convention in a new city...");
            System.out.print("\nEnter new convention ID: ");
            city.setId(scan.nextInt());
            System.out.print("\nEnter new convention city: ");
            city.setCity(scan.next().toLowerCase());
            System.out.print("\nEnter new convention state: ");
            city.setState(scan.next().toLowerCase());
            System.out.print("\nEnter new convention start date (MM/DD/YY): ");
            city.setDate(scan.next().toLowerCase());
            confirm = false;

            while(!confirm) {
                System.out.println("\nIs the following information correct? (y/n)");
                System.out.println(city);
                System.out.print("\nEnter: ");

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        System.out.println("\nBeyondCon convention in " + city.getCity() + " created successfully!");
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
