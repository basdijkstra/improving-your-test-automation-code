package answers.users;

import lombok.Getter;

@Getter
public class User {

    private final String name;
    private final Account account;

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public void printInfo() {

        System.out.printf(
                "Username: %s, account type: %s%n", this.name, this.account.getClass().getSimpleName()
        );
    }

    public boolean canAccessLogFiles() {

        return this.account.canAccessLogFiles();
    }
}
