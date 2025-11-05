package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final String ADMIN_USERNAME = "admin@bandham.com";
    private static final String ADMIN_PASSWORD = "admin123";

    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public boolean updatePassword(String username, String newPassword) {
        // Since credentials are hardcoded, password update is not supported
        // Return false to indicate update is not possible
        return false;
    }
}
