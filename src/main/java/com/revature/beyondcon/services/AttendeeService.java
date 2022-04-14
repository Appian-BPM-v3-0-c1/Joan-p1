package com.revature.beyondcon.services;
import com.revature.beyondcon.daos.AttendeeDAO;
import com.revature.beyondcon.models.Attendee;

import java.util.List;

public class AttendeeService {
        private final AttendeeDAO attendeeDAO;

        public AttendeeService(AttendeeDAO attendeeDAO) {
                this.attendeeDAO = attendeeDAO;
        }

        public AttendeeDAO getAttendeeDAO() {
                return attendeeDAO;
        }

        public boolean isDupUsername(String username) {
                List<String> usernameList = attendeeDAO.findAllUsernames();

                for (String u : usernameList) {
                        if (u.equals(username)) {
                                return true;
                        }
                }
                return false;

        }

        public boolean isValidUsername(String username) {
                return username.matches("^(?=[a-zA-Z0-9._]{6,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
        }

        public boolean isValidPassword(String password) {
                return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
        }

        public boolean isValidLogin(Attendee attendee) {
                List<Attendee> attendeeList = attendeeDAO.findAll();

                for (Attendee u : attendeeList) {
                        if (u.getUsername().equals(attendee.getUsername()) && u.getPassword().equals(attendee.getPassword())) {
                                return true;
                        }
                }

                return false;
        }

}
