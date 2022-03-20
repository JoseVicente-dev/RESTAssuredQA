package co.com.sofka.stepdefinitions.create;

import co.com.sofka.model.CreateModel;
import co.com.sofka.stepdefinitions.setup.services.ServiceSetUp;
import co.com.sofka.util.enums.CreateKeys;
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

public class CreateTestStepDefinitions extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(CreateTestStepDefinitions.class);

    private Response response;
    private RequestSpecification request;
    private FileReader fileReader;
    private CreateModel createModel;

    private final String REGISTER_FILE_FROM_CONTENT_ROOT = "resources\\files\\create.json";

    @Given("que como administrador cree el usuario con nombre {string} y cargo {string}")
    public void queComoAdministradorCreeElUsuarioConNombreYCargo(String name, String job) {
        try {
            generalSetUp();

            createModel = new CreateModel();
            createModel.setName(name);
            createModel.setJob(job);

            fileReader = new FileReader(REGISTER_FILE_FROM_CONTENT_ROOT);
            request = given()
                    .contentType(ContentType.JSON)
                    .body(
                            fileReader
                                    .readContent()
                                    .replace(CreateKeys.NAME.getValue(), name)
                                    .replace(CreateKeys.JOB.getValue(), job)
                    );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("envie la orden a la base de datos")
    public void envieLaOrdenALaBaseDeDatos() {

        try {
            response = request.when()
                    .post(RESOURCE_CREATE);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("se creara un nuevo usuario con sus datos y un id")
    public void seCrearaUnNuevoUsuarioConSusDatosYUnId() {
        try {

            response.then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("name",Matchers.containsString(createModel.getName()),"job",Matchers.containsString(createModel.getJob()),"id",Matchers.notNullValue());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
