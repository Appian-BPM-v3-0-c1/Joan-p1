package com.revature.beyondcon.ui;

import java.util.Scanner;

public class MainMenu implements IMenu {

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {
            System.out.println("\nWelcome to BeyondCon Registration!");
            System.out.println("\n[1] View all cities");
            System.out.println("[2] View all events");
            System.out.println("[3] View all speakers");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new CitiesMenu().start();
                    break;
                case '2':
                    break;
                case '3':
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

}
