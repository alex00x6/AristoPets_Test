package api.utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {
    static String aristopets_auth = null;
    private final static ContentType CONTENT_TYPE = ContentType.URLENC;
    private final static ContentType CONTENT_TYPE_JSON = ContentType.JSON;
    private RequestSpecification requestSpecification = null;
    private Response response = null;


    public RequestSender(){
    }

    RequestSender createRequestNoAuth(String body){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString())
                    .addBody(body);
            return this;
    }
    public RequestSender createRequestAuth(String body){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE_JSON.toString())
                    .addHeader("Cookie", "aristopets_auth=" + aristopets_auth)
                    .addBody(body);
            return this;
    }


    public RequestSender createEmptyRequestAuth(){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE_JSON.toString())
                    .addHeader("Cookie", "aristopets_auth=" + aristopets_auth);
            return this;
    }

    RequestSender createEmptyRequestNoAuth(){
            this.createRequestSpecification()
                    .addHeader("Content-Type", CONTENT_TYPE.toString());
            return this;
    }

    public void authorize(String email, String password, boolean remember){
        String encodeLogin = "email="+email+"&password="+password+"&redirectUri=/&remember="+remember;
        aristopets_auth = createRequestNoAuth(encodeLogin)
                .post("/login").extractCookie("aristopets_auth");
        System.out.println(aristopets_auth);
    }


    private RequestSender createRequestSpecification() {
        requestSpecification = given().
                when();
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров
    private RequestSender addHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }

    private RequestSender addBody(String body) {
        requestSpecification.body(body);
        return this;
    }

    public RequestSender post(String uri) {
        setResponse(requestSpecification.post(uri));
        return this;
    }

    RequestSender delete(String uri){
        setResponse(requestSpecification.delete(uri));
        return this;
    }

    public RequestSender get(String uri){
        setResponse(requestSpecification.get(uri));
        return this;
    }

    public RequestSender put(String uri) {
        setResponse(requestSpecification.put(uri));
        return this;
    }

    public String extractResponseByPath(String path){
        return getResponse().then().extract().path(path);
    }

    public String extractCookie(String cookie){
        return getResponse().then().extract().cookie(cookie);
    }

    public String extractAllResponseAsString(){
        return getResponse().then().extract().asString();
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}