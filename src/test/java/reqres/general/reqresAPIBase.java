package reqres.general;

import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.IConfigBase;

public class reqresAPIBase implements IConfigBase {

    public RequestSpecification requestSpecification;

    @BeforeEach
    public void configure() {
        // Configuracion Inicial
        RestAssured.baseURI = "https://reqres.in";
        requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json");
        requestSpecification.accept("application/json");


    }

}
