package com.revature.beyondcon;
import com.revature.beyondcon.daos.AttendeeDAO;
import com.revature.beyondcon.services.AttendeeService;
import com.revature.beyondcon.ui.LoginMenu;

public class Main {

    public static void main(String[] args) {

        // Start application.
        new LoginMenu(new AttendeeService(new AttendeeDAO())).start();

    }
}