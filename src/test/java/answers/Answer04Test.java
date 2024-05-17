package answers;

import answers.users.AdminAccount;
import answers.users.User;
import answers.users.UserAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Answer04Test {

    @Test
    public void checkIfDefaultUserCanAccessLogFiles_shouldBeFalse() {

        User user = new User("John Doe", new UserAccount("John Doe"));

        user.printInfo();

        assertFalse(user.canAccessLogFiles());
    }

    @Test
    public void checkIfAdminUserCanAccessLogFiles_shouldBeTrue() {

        User admin = new User("Susan Jones", new AdminAccount("Susan Jones"));

        admin.printInfo();

        assertTrue(admin.canAccessLogFiles());
    }
}
