package exercises.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Account {

    private String username;
    private String password;
    private AccountType type;
}
