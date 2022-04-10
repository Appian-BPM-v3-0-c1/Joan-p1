package com.revature.beyondcon.ui;

import java.util.Scanner;

public class MainMenu implements IMenu {

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while(!exit) {
            System.out.println("\nWelcome to BeyondCon 2023!");
            System.out.println("\n[1] Go to Conventions Menu");
            System.out.println("[2] Go to Events Menu");
            System.out.println("[3] Go to Speakers Menu");
            System.out.println("[4] Go to Vendors Menu");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new ConsMenu().start();
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
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

}
