package answers;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.http.ContentType;
import answers.models.LoanApplication;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@WireMockTest(httpPort = 9876)
public class Answer01Test {

    @ParameterizedTest(name = "A loan application for {0} should be {1}")
    @CsvSource({
            "1000, Approved",
            "2000, Approved",
            "5000, Denied"
    })
    public void applyFor5000DollarLoan_with100DownPayment_shouldBeDenied(int loanAmount, String expectedResult) {

        LoanApplication loanApplication =
                new LoanApplication(loanAmount, 100, "John", "Doe");

        given()
                .contentType(ContentType.JSON)
                .body(loanApplication)
                .when()
                .post("http://localhost:9876/loanApplication")
                .then()
                .statusCode(200)
                .body("result", equalTo(expectedResult));
    }
}
