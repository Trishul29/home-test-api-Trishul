package modules.clientRequest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Utilities.FileUtility;

import java.util.Properties;

public class InventoryClientHelper {

    public static String propertyPath = System.getProperty("user.dir") + "//src//main// [//spec.properties";
    public static Properties properties = FileUtility.loadProperties(propertyPath);
    public String baseUri = properties.getProperty("base_uri");


    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(properties.getProperty("base_uri"))
            .setContentType(ContentType.JSON)
            .build();


    protected static Response getResponse(Response response) {

        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
