package reqres.cases;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reqres.models.createUserPayload;

public class requestPage {

    public static Response getRequestPage(RequestSpecification requestSpecification, int page){ 
        requestSpecification.param("page", page);
        return requestSpecification.get("/api/users/");
    }

    public static Response getRequestUser(RequestSpecification requestSpecification, int user){ 
        return requestSpecification.get("/api/users/" + user);
    }

    public static Response postCreateUser(RequestSpecification requestSpecification, String name, String job){ 
        String json = createUserPayload.userPayload(name, job);
        return requestSpecification.body(json).post("/api/users");
    }

    public static Response delayRequestPage(RequestSpecification requestSpecification, int delay){ 
        requestSpecification.param("delay", 3);
        return requestSpecification.get("/api/users");
    }
}
