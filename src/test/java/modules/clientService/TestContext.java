package modules.clientService;

public class TestContext {
    public final InventoryService inventoryService;

    public TestContext() {
        inventoryService = new InventoryService();
    }
}
