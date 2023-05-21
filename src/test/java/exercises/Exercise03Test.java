package exercises;

import exercises.users.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise03Test {

    @Test
    public void checkIfDefaultUserCanAccessLogFiles_shouldBeFalse() {

        User user = new User("John Doe");

        user.printInfo();

        assertFalse(user.canAccessLogFiles());
    }

    @Test
    public void checkIfAdminUserCanAccessLogFiles_shouldBeTrue() {

        /// Eeerrmmm..
    }
}
