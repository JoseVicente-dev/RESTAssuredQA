package co.com.sofka.stepdefinitions.create;

import co.com.sofka.stepdefinitions.setup.services.ServiceSetUp;
import co.com.sofka.util.enums.RegisterKeys;
import co.com.sofka.util.functions.FileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class CreateTestStepDefinitions extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(CreateTestStepDefinitions.class);

    private Response response;
    private RequestSpecification request;
    private FileReader fileReader;

    private final String REGISTER_FILE_FROM_CONTENT_ROOT = "resources/files/register.json";

    @Given("que como administrador cree el usuario con nombre {string} y cargo {string}")
    public void queComoAdministradorCreeElUsuarioConNombreYCargo(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("envie la orden a la base de datos")
    public void envieLaOrdenALaBaseDeDatos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("se creara un nuevo usuario con sus datos y un id")
    public void seCrearaUnNuevoUsuarioConSusDatosYUnId() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


/**
    @Given("que como administrador ingreso al modulo de crear usuarios")
    public void queComoAdministradorIngresoAlModuloDeCrearUsuarios() {
        try {
            generalSetUp();
            request = given()
                    .contentType(ContentType.JSON);


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @When("cree el usuario con nombre {string} y cargo {string}")
    public void creeElUsuarioConNombreYCargo(String name, String job) {
        try {

            fileReader = new FileReader(REGISTER_FILE_FROM_CONTENT_ROOT);

            request.body(
                    fileReader
                            .readContent()
                            .replace(RegisterKeys.NAME.getValue(), name)
                            .replace(RegisterKeys.JOB.getValue(), job)
            );

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Then("se creara un nuevo usuario en la base de datos con sus datos y un id")
    public void seCrearaUnNuevoUsuarioEnLaBaseDeDatosConSusDatosYUnId() {
        try {

            response = request.

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }*/
}
