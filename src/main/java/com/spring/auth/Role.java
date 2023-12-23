package com.spring.auth;

import java.util.ArrayList;
import java.util.List;

public enum Role {

    OWNER("OWNER"), MANAGER("MANAGER"), CASHIER("CASHIER");
    private final String role;

    private static List<DisplayPair<String, String>> displayPairsList = new ArrayList<>();

    public static List<DisplayPair<String, String>> getDisplayPairs() {
        for (Role s : Role.values()) {
            displayPairsList.add(new DisplayPair<>(s.name(), s.role));
        }
        return displayPairsList;
    }

    private Role(String role) {
        this.role = role;
    }

    private Role() {
        this.role = "";
    }

    public String getRole() {
        return role;
    }

    public static Role fromString(String role) {
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No Enum constant for " + role);
        }
    }

    @Override
    public String toString() {
        return this.getRole();
    }
}
