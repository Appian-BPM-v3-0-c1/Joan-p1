package com.revature.beyondcon.services;
import com.revature.beyondcon.daos.AttendeeDAO;

import java.util.List;

public class AttendeeService {
        private AttendeeDAO attendeeDAO;

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

}
