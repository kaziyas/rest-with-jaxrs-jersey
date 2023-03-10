package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.model.Order;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

/**
 * API tests for StoreApi
 */
@Ignore
public class StoreApiTest {

    private final StoreApi api = new StoreApi();


    /**
     * Delete purchase order by ID
     * <p>
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void deleteOrderTest() throws Exception {
        Long orderId = null;
        api.deleteOrder(orderId);

        // TODO: test validations
    }

    /**
     * Returns pet inventories by status
     * <p>
     * Returns a map of status codes to quantities
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void getInventoryTest() throws Exception {
        Map<String, Integer> response = api.getInventory();

        // TODO: test validations
    }

    /**
     * Find purchase order by ID
     * <p>
     * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void getOrderByIdTest() throws Exception {
        Long orderId = null;
        Order response = api.getOrderById(orderId);

        // TODO: test validations
    }

    /**
     * Place an order for a pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void placeOrderTest() throws Exception {
        Order body = null;
        Order response = api.placeOrder(body);

        // TODO: test validations
    }

}
