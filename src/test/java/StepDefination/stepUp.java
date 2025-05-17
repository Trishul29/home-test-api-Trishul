package StepDefination;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import modules.clientService.InventoryService;
import modules.clientService.TestContext;
import org.example.PojoClasses.create.CreateItemRequestBody;
import org.example.PojoClasses.create.CreateItemResponse;
import org.example.PojoClasses.get.getItemResponse;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class stepUp {

    private final InventoryService inventoryService;
    private CreateItemRequestBody requestBody;
    private CreateItemResponse createItemResponse;
    private getItemResponse getItemResponse;
    private Response MissingFieldResponse;

    public stepUp(TestContext context) {
        this.inventoryService = context.inventoryService;
    }

    @When("I send a GET request")
    public void iSendAGetRequestTo() {
        getItemResponse = inventoryService.getAllMenuService();
    }

    @When("I send a GET request with filter id")
    public void iSendAGetRequestToWithFilterId() {
        getItemResponse = inventoryService.getMenuIdService();
    }

    @Then("the response should contain at least {int} items")
    public void theResponseShouldContainAtLeastItems(int expectedCount) throws Exception {
        assertTrue("Expected at least " + expectedCount + " items", getItemResponse.getData().size() >= expectedCount);
    }

    @And("each item should contain fields {string}, {string}, {string}, {string}")
    public void eachItemShouldContainFields(String id, String name, String price, String image) throws Exception {
        for (getItemResponse.MenuItem item : getItemResponse.getData()) {
            assertNotNull("Item id should not be null", item.getId());
            assertNotNull("Item name should not be null", item.getName());
            assertNotNull("Item price should not be null", item.getPrice());
            assertNotNull("Item image should not be null", item.getImage());
        }
    }

    @Then("the response should contain item with:")
    public void the_response_should_contain_item_with(DataTable dataTable) throws Exception {
        Map<String, String> expected = dataTable.asMap();
        List<getItemResponse.MenuItem> items = getItemResponse.getData();
        assertEquals(items.size(), 1, "Only one item expected in filter response.");
        getItemResponse.MenuItem actualItem = items.get(0);

        assertEquals(actualItem.getId(), expected.get("id"));
        assertEquals(actualItem.getName(), expected.get("name"));
        assertEquals(actualItem.getPrice(), expected.get("price"));
        assertEquals(actualItem.getImage(), expected.get("image"));
    }

    @Given("I have a new inventory item with id {string}, name {string}, image {string}, and price {string}")
    public void iHaveANewInventoryItemWith(String id, String name, String image, String price) {
        requestBody = CreateItemRequestBody.builder()
                .id(id)
                .name(name)
                .image(image)
                .price(price)
                .build();
    }

    @When("I send a POST request")
    public void iSendAPostRequestTo() {
        createItemResponse = inventoryService.addItemByExistentIdService(requestBody);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        assertEquals(expectedStatusCode, createItemResponse.getStatusCode());
    }

    @Then("the response status code should be {int} for missing Field")
    public void theResponseStatusCodeForMissingField(int expectedStatusCode) {
        assertEquals(expectedStatusCode, MissingFieldResponse.getStatusCode());
    }

    @Given("I create a request with missing field {string}")
    public void iCreateARequestWithMissingField(String missingField) {
        CreateItemRequestBody.CreateItemRequestBodyBuilder builder = CreateItemRequestBody.builder()
                .name("Hawaiian")
                .image("hawaiian.png")
                .price("$14");

        if (!missingField.equals("id")) {
            builder.id("10");
        }
        requestBody = builder.build();
        MissingFieldResponse = inventoryService.addItemByMissingService(requestBody);
    }

    @And("the response should contain message {string}")
    public void theResponseShouldContainMessage(String expectedMessage) {
        assertEquals(MissingFieldResponse.getBody().asString(), expectedMessage, "Expected message not found in response body");
    }
}
