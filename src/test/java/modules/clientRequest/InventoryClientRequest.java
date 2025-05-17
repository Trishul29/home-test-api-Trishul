package modules.clientRequest;

import org.example.Constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.PojoClasses.create.CreateItemRequestBody;



import static io.restassured.RestAssured.given;

public class InventoryClientRequest extends InventoryClientHelper {


    public Response getAllMenu() {
        System.out.println(EndPoints.get);

        Response response = 
              given().spec(InventoryClientHelper.requestSpec)
                      .log().all(true)
                .when()
                .get(EndPoints.get);
        return getResponse(response);
    }


    public Response getMenuById() {

        Response response =
             given().spec(InventoryClientHelper.requestSpec)
                .contentType(ContentType.JSON)
                .queryParam("id",3)
                .log().uri()
                .when()
                .get(EndPoints.getFilteredItemById);


        return getResponse(response);

    }

    public Response addItem(CreateItemRequestBody createItemRequestBody)
    {
        Response response =
                given().spec(InventoryClientHelper.requestSpec)
                .contentType(ContentType.ANY)
                .body(createItemRequestBody)
                .log().uri()
                .when()
                .post(EndPoints.create);

        return getResponse(response);

    }



}
