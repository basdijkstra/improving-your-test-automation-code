package exercises.users;

import java.util.UUID;

public class User {

    private final String name;
    private final Account account;

    public User(String name) {
        this.name = name;
        this.account = new Account(name, generatePassword(), AccountType.DEFAULT);
    }

    private String generatePassword() {
        return UUID.randomUUID().toString();
    }

    public void printInfo() {

        System.out.printf(
                "Username: %s, account type: %s%n", this.name, this.account.getType()
        );
    }

    public boolean canAccessLogFiles() {

        return this.account.getType().equals(AccountType.ADMIN);
    }
}
