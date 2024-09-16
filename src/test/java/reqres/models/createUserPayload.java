package reqres.models;



public class createUserPayload {
    public static String userPayload(String name, String job){
        String json = "{"
        + "\"name\":\"" + name + "\","
        + "\"job\":\"" + job + "\""
        + "}";

        return json;
    }
}
