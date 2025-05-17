package modules.clientService;

import io.restassured.response.Response;
import modules.clientRequest.InventoryClientRequest;
import org.example.PojoClasses.create.*;
import org.example.PojoClasses.get.*;


import java.util.concurrent.TimeUnit;

public class InventoryService {


    public CreateItemResponse addItemByExistentIdService(CreateItemRequestBody createItemRequestBody) {
        Response response = new InventoryClientRequest().addItem(createItemRequestBody);
        CreateItemResponse addBookResponse = response.as(CreateItemResponse.class);
        addBookResponse.setResponseTime(response.timeIn(TimeUnit.MILLISECONDS));
        addBookResponse.setStatusCode(response.statusCode());
        return addBookResponse;
    }


    public CreateItemResponse addItemByNonExistentIdService(CreateItemRequestBody createItemRequestBody) {
        Response response = new InventoryClientRequest().addItem(createItemRequestBody);
        CreateItemResponse addBookResponse = response.as(CreateItemResponse.class);
        addBookResponse.setResponseTime(response.timeIn(TimeUnit.MILLISECONDS));
        addBookResponse.setStatusCode(response.statusCode());
        return addBookResponse;
    }



    public Response addItemByMissingService(CreateItemRequestBody createItemRequestBody) {
        return new InventoryClientRequest().addItem(createItemRequestBody);
    }

    public getItemResponse getAllMenuService() {
        Response response = new InventoryClientRequest().getAllMenu();
        getItemResponse getItemResponse = response.as(getItemResponse.class);
        getItemResponse.setResponseTime(response.timeIn(TimeUnit.MILLISECONDS));
        getItemResponse.setStatusCode(response.statusCode());
        return getItemResponse;
    }
    public getItemResponse getMenuIdService() {
        Response response = new InventoryClientRequest().getMenuById();
        getItemResponse getItemResponse = response.as(getItemResponse.class);
        getItemResponse.setResponseTime(response.timeIn(TimeUnit.MILLISECONDS));
        getItemResponse.setStatusCode(response.statusCode());
        return getItemResponse;
    }




}
