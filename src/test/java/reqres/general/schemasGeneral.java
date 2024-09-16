package reqres.general;

import static org.junit.Assert.assertTrue;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class schemasGeneral {

    
    public static void validateJsonSchemaError(Response response){
        // El codigo que me va a permitir realizar la validacion del 
        // Response Vs JsonSchema

        JsonSchemaValidator jsv = JsonSchemaValidator.matchesJsonSchemaInClasspath("general/ErrorJsonSchema.json");

        assertTrue(
            "Validacion del Json Schema  para los errores de la Aplicacion", 
            jsv.matches(response.asString())
        );
    }
}
