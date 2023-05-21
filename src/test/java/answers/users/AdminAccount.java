package answers.users;

public class AdminAccount extends Account {

    private final String username;
    private final String password;

    public AdminAccount(String username) {
        this.username = username;
        this.password = generatePassword();
    }

    public boolean canAccessLogFiles() {
        return true;
    }

    public String getLogFiles() {

        return "Here are your log files";
    }
}
