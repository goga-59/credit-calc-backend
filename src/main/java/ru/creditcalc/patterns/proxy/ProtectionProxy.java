package ru.creditcalc.patterns.proxy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProtectionProxy implements Resource {

    private Database database;
    private String role;

    @Override
    public void dropDatabase() {
        if ("ADMIN".equals(role)) {
            if (database == null) {
                database = new Database();
            }
            database.dropDatabase();
        } else {
            System.out.println("You don't have the role " + role);
        }
    }

}
