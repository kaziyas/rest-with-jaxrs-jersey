package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.invoker.ApiException;
import de.kaziyas.petshop.client.model.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.*;
import java.util.Map;

/**
 * API tests for StoreApi
 */
@FixMethodOrder(MethodSorters.JVM)
public class StoreApiTest {

    private final StoreApi api = new StoreApi();

    private Order order;

    @Before
    public void setup () {
        this.order = createOrder();
    }

    private Order createOrder() {
        Order order = new Order();
        order.setId(-48547741L);
        order.setPetId(19810821L);
        order.setQuantity(-9107068);
        order.setStatus(Order.StatusEnum.APPROVED);
        order.complete(Boolean.FALSE);
        order.setShipDate(OffsetDateTime.now());

        return order;
    }

    /**
     * Delete purchase order by ID
     * <p>
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
     *
     * @throws Exception if the Api call fails
     */
    @Test(expected = ApiException.class)
    public void deleteOrderTest() throws Exception {
        Order body = this.order;
        Order response = api.placeOrder(body);
        Long orderId = response.getId();

        api.deleteOrder(orderId);
        api.getOrderById(orderId);
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
        Assert.assertNotNull(response);
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
        Order body = this.order;
        Order response = api.placeOrder(body);
        Long orderId = response.getId();

        response = api.getOrderById(orderId);
        Assert.assertEquals(orderId, response.getId());
    }

    /**
     * Place an order for a pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void placeOrderTest() throws Exception {
        Order body = this.order;
        Order response = api.placeOrder(body);
        Assert.assertNotNull(response);
        Assert.assertEquals(body.getId(), body.getId());
    }
}
