package co.com.sofka.stepdefinitions.setup.services;

import co.com.sofka.util.enums.Log4jValues;
import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

public class ServiceSetUp {

    private static final String BASE_URI = "https://reqres.in";
    private static final String BASE_PATH = "/api";
    protected static final String RESOURCE_UPDATE = "/users/2";
    protected static final String RESOURCE_CREATE = "/users";
    protected static final String RESOURCE_REGISTER = "/register";

    protected void generalSetUp() {
        setUpLog4j2();
        setUpBases();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + Log4jValues.LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setUpBases() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
    }


}
