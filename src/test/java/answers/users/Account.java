package answers.users;

import java.util.UUID;

public abstract class Account {

    abstract boolean canAccessLogFiles();

    protected String generatePassword() {
        return UUID.randomUUID().toString();
    }
}
