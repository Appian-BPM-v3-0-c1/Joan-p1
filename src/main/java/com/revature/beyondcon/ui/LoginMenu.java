package com.revature.beyondcon.ui;

import com.revature.beyondcon.daos.AttendeeDAO;
import com.revature.beyondcon.daos.ContactInfoDAO;
import com.revature.beyondcon.models.Attendee;
import com.revature.beyondcon.services.AttendeeService;
import com.revature.beyondcon.services.ContactInfoService;

import java.util.Scanner;

public class LoginMenu implements IMenu {
    private AttendeeService attendeeService;

    public LoginMenu(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    Scanner scan = new Scanner(System.in);
    Attendee attendee = new Attendee();

    @Override
    public void start() {
        char input = ' ';

        exit: {
            while (true) {
                System.out.println("\nWelcome to the BeyondCon 2023 Login and Registration");
                System.out.println("\n[1] Log in");
                System.out.println("[2] Create new account");
                System.out.println("[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }

    }

    private void createAccount() {
        String username = "";
        String password1 = "";
        String password2 = "";
        boolean uType = false;

        System.out.println("\nCreating your new account...");

        while (true) {

            while (true) {
                System.out.print("\nEnter your new username: ");
                username = scan.next().toLowerCase();

                if (!attendeeService.isDupUsername(username)) {
                    if (attendeeService.isValidUsername(username)) {
                        attendee.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nInvalid username! Your username must be between 6 and 20 characters long.");
                    }
                } else {
                    System.out.println("\nDuplicate username! You must select an original username.");
                }
            }

            while (true) {
                System.out.print("\nEnter your new password: ");
                password1 = scan.next();

                System.out.print("\nEnter your password a second time to confirm: ");
                password2 = scan.next();

                if (password1.equals(password2)) {
                    if (attendeeService.isValidPassword(password1)) {
                        attendee.setPassword(password1);
                        break;
                    } else {
                        System.out.println("\nInvalid password! Your password must be at least 8 characters long, and it must include at least one uppercase letter, one lowercase letter, one number, and one special character.");
                    }
                } else {
                    System.out.println("\nYour password did not match! Please try again.");
                }
            }

            attendee.setuType(uType);

            boolean confirm = false;
            while(!confirm) {
                System.out.println("\nPlease confirm your new account credentials (y/n).");
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password1);
                System.out.print("\nEnter: ");
                char input = scan.next().charAt(0);

                switch (input) {
                    case 'y':
                        attendeeService.getAttendeeDAO().save(attendee);
                        System.out.println("\nYour new account was created successfully!");
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            break;

        }
    }

    private void login() {
        while (true) {
            System.out.print("\nUsername: ");
            attendee.setUsername(scan.next().toLowerCase());

            System.out.print("\nPassword: ");
            attendee.setPassword(scan.next());

            if (attendeeService.isValidLogin(attendee)) {
                attendee = attendeeService.getAttendeeDAO().getByUserName(attendee.getUsername());
                new MainMenu(attendee, new ContactInfoService(new ContactInfoDAO(), new AttendeeDAO())).start();
                break;
            } else {
                System.out.println("\nInvalid login information!");
                break;
            }
        }
    }

}