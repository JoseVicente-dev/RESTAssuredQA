package co.com.sofka.stepdefinitions.register;

import co.com.sofka.stepdefinitions.setup.services.ServiceSetUp;
import co.com.sofka.util.enums.RegisterUnsuccessfulKeys;
import co.com.sofka.util.enums.RegisterUnsuccessfulResponseKeys;
import co.com.sofka.util.functions.FileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RegisterTestStepDefinitions extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(RegisterTestStepDefinitions.class);

    private Response response;
    private RequestSpecification request;
    private FileReader fileReader;

    private final String REGISTER_UNSUCCESSFUL_FILE_PATH_FROM_CONTENT_ROOT = "resources\\files\\registerUnsuccessful.json";

    @Given("que diligencio solamente mi correo {string} en la pagina de registro")
    public void queDiligencioSolamenteMiCorreoEnLaPaginaDeRegistro(String email) {
        try {
            generalSetUp();

            fileReader = new FileReader(REGISTER_UNSUCCESSFUL_FILE_PATH_FROM_CONTENT_ROOT);

            request = given()
                    .contentType(ContentType.JSON)
                    .body(
                            fileReader
                                    .readContent()
                                    .replace(RegisterUnsuccessfulKeys.EMAIL.getValue(),email)
                    );

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("intente registrarme")
    public void intenteRegistrarme() {
        try {

            response = request.when()
                    .post(RESOURCE_REGISTER);

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("recibire como mensaje {string}")
    public void recibireComoMensaje(String errorMessage) {
        try {

            response.then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(RegisterUnsuccessfulResponseKeys.ERROR.getValue(), Matchers.containsString(errorMessage));

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
