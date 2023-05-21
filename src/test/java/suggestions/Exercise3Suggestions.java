package suggestions;

public class Exercise3Suggestions {

    // Suggestion 1: So, the first problem is that we cannot create a new User with an admin account
    // with the way our code is currently written. Do you have a solution for that?

    // Suggestion 2: There's another problem here... The User class contains some logic that is probably
    // better placed in the Account class. Password generation, for example, or determining whether
    // someone can access the log files. What's the SOLID principle being violated here and how
    // would you redesign the class?

    // Suggestion 3: We still cannot create a user with an admin account this way. Probably because the
    // account is created in the constructor of the User class. That's a violation of another SOLID
    // principle. Do you know which one, and can you implement an improvement?
    // Please note that there is no one right or wrong answer here, there are many ways to
    // address this issue, and a lot of it depends on personal preference :)

    // After you have implemented the changes above, is it easier now to:
    // - create a user with an admin account
    // - write a test that checks that a user with an admin account can access the log files?
}
