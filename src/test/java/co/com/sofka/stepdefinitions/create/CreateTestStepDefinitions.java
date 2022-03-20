package co.com.sofka.stepdefinitions.create;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CreateTestStepDefinitions {

    public static final Logger LOGGER = Logger.getLogger(CreateTestStepDefinitions.class);

    @Given("que como administrador ingreso al modulo de crear usuarios")
    public void queComoAdministradorIngresoAlModuloDeCrearUsuarios() {
        try {

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("cree el usuario con nombre {string} y cargo {string}")
    public void creeElUsuarioConNombreYCargo(String name, String job) {
        try {

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @Then("se creara un nuevo usuario en la base de datos con sus datos y un id")
    public void seCrearaUnNuevoUsuarioEnLaBaseDeDatosConSusDatosYUnId() {
        try {

        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
