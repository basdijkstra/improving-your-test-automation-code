package answers.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanApplication {

    private int loanAmount;
    private int downPayment;
    private String firstName;
    private String lastName;
}
