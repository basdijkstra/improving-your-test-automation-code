package answers.users;

public class UserAccount extends Account {

    private final String username;
    private final String password;

    public UserAccount(String username) {
        this.username = username;
        this.password = generatePassword();
    }

    public boolean canAccessLogFiles() {
        return false;
    }
}
