package reqres.cases;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class questions {

    public static void validateStatusCode(Response respuesta, Integer codigoEstadoEsperado) {
        assertEquals(
                codigoEstadoEsperado,
                respuesta.statusCode(),
                "Validación del Status Code"
        );
    }

    public static void validateJsonSchemaPage(Response respuesta, Integer paginaEsperada) {
        JsonSchemaValidator validadorJson = JsonSchemaValidator.matchesJsonSchemaInClasspath("reqres/ReqResJsonSchemaPage.json");
        respuesta.then().assertThat().body(validadorJson);
        int pagina = respuesta.jsonPath().getInt("page");
        assertEquals(paginaEsperada, pagina);
    }

    public static void validateJsonSchemaUser(Response respuesta, Integer idEsperado, String emailEsperado, String nombreEsperado, String apellidoEsperado, String avatarEsperado) {
        JsonSchemaValidator validadorJson = JsonSchemaValidator.matchesJsonSchemaInClasspath("reqres/ReqResJsonSchemaUser.json");
        respuesta.then().assertThat().body(validadorJson);
        int id = respuesta.jsonPath().getInt("data.id");
        String email = respuesta.jsonPath().getString("data.email");
        String nombre = respuesta.jsonPath().getString("data.first_name");
        String apellido = respuesta.jsonPath().getString("data.last_name");
        String avatar = respuesta.jsonPath().getString("data.avatar");
        assertEquals(idEsperado, id);
        assertEquals(emailEsperado, email);
        assertEquals(nombreEsperado, nombre);
        assertEquals(apellidoEsperado, apellido);
        assertEquals(avatarEsperado, avatar);
    }

    public static void validateJsonSchemaUserNotFound(Response respuesta) {
        assertNull(respuesta.jsonPath().getString("data"));
    }

    public static void validateJsonSchemaCreateUser(Response respuesta, String nombreEsperado, String trabajoEsperado) {
        JsonSchemaValidator validadorJson = JsonSchemaValidator.matchesJsonSchemaInClasspath("reqres/ReqResJsonSchemaCreateUser.json");
        respuesta.then().assertThat().body(validadorJson);
        String nombre = respuesta.jsonPath().getString("name");
        String trabajo = respuesta.jsonPath().getString("job");
        assertEquals(nombreEsperado, nombre);
        assertEquals(trabajoEsperado, trabajo);
    }

}
