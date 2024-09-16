package reqres.cases;

import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import reqres.general.reqresAPIBase;

public class caseTest extends reqresAPIBase {

    @Test
    public void getRequestPage() {
        Response respuestaPagina = requestPage.getRequestPage(requestSpecification, 2);
        questions.validateStatusCode(respuestaPagina, 200);
        questions.validateJsonSchemaPage(respuestaPagina, 2);
    }

    @Test
    public void getRequestUser() {
        Response respuestaUsuario = requestPage.getRequestUser(requestSpecification, 12);
        questions.validateStatusCode(respuestaUsuario, 200);
        questions.validateJsonSchemaUser(respuestaUsuario, 12, "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg");
    }

    @Test
    public void getRequestUserNotFound() {
        Response respuestaNoEncontrada = requestPage.getRequestUser(requestSpecification, 40);
        questions.validateStatusCode(respuestaNoEncontrada, 404);
        questions.validateJsonSchemaUserNotFound(respuestaNoEncontrada);
    }

    @Test
    public void postCreateUser() {
        Response respuestaCreacion = requestPage.postCreateUser(requestSpecification, "morpheus", "leader");
        questions.validateStatusCode(respuestaCreacion, 201);
        questions.validateJsonSchemaCreateUser(respuestaCreacion, "morpheus", "leader");
    }

    @Test
    public void delayRequestPage() {
        Response respuestaRetraso = requestPage.delayRequestPage(requestSpecification, 10);
        questions.validateStatusCode(respuestaRetraso, 200);
    }

}