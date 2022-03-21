package co.com.sofka.stepdefinitions.update;

import co.com.sofka.model.UpdateModel;
import co.com.sofka.stepdefinitions.setup.services.ServiceSetUp;
import co.com.sofka.util.enums.UpdateKeys;
import co.com.sofka.util.enums.UpdateResponseKeys;
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

public class UpdateTestStepDefinitions extends ServiceSetUp {

    public static final Logger LOGGER = Logger.getLogger(UpdateTestStepDefinitions.class);

    private Response response;
    private RequestSpecification request;
    private FileReader fileReader;

    private UpdateModel updateModel;

    private  final String UPDATE_FILE_PATH_FROM_CONTENT_ROOT = "resources\\files\\update.json";

    @Given("que como administrador actualice el usuario con nombre {string} y cargo {string}.")
    public void queComoAdministradorActualiceElUsuarioConNombreYCargo(String name, String job) {
        try {

            generalSetUp();

            updateModel = new UpdateModel();
            updateModel.setName(name);
            updateModel.setJob(job);

            fileReader = new FileReader(UPDATE_FILE_PATH_FROM_CONTENT_ROOT);
            request = given()
                    .contentType(ContentType.JSON)
                    .body(
                            fileReader.readContent()
                                    .replace(UpdateKeys.NAME.getValue(),name)
                                    .replace(UpdateKeys.JOB.getValue(),job)
                    );

        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When("envie la orden hasta la base de datos")
    public void envieLaOrdenHastaLaBaseDeDatos() {
        try {

            response = request.when()
                    .put(RESOURCE_UPDATE);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then("se actualizara el usuario con sus nuevos datos")
    public void seActualizaraElUsuarioConSusNuevosDatos() {
        try {
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body(UpdateResponseKeys.NAME.getValue(), Matchers.containsString(updateModel.getName()),
                            UpdateResponseKeys.JOB.getValue(),Matchers.containsString(updateModel.getJob()),
                            UpdateResponseKeys.UPDATED_AT.getValue(),Matchers.notNullValue());
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
