package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.invoker.ApiClient;
import de.kaziyas.petshop.client.invoker.ApiException;
import de.kaziyas.petshop.client.invoker.Configuration;
import de.kaziyas.petshop.client.invoker.Pair;
import de.kaziyas.petshop.client.model.Order;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-03-10T17:52:57.846+01:00")
public class StoreApi {
  private ApiClient apiClient;

  public StoreApi() {
    this(Configuration.getDefaultApiClient());
  }

  public StoreApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Delete purchase order by ID
   * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
   *
   * @param orderId ID of the order that needs to be deleted (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteOrder(Long orderId) throws ApiException {
    Object postBody = null;

    // verify the required parameter 'orderId' is set
    if (orderId == null) {
      throw new ApiException(400, "Missing the required parameter 'orderId' when calling deleteOrder");
    }

    // create path and map variables
    String path = "/store/order/{orderId}"
            .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();


    final String[] accepts = {
            "application/json", "application/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {

    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[]{};

    apiClient.invokeAPI(path, "DELETE", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, null);
  }

  /**
   * Returns pet inventories by status
   * Returns a map of status codes to quantities
   *
   * @return Map&lt;String, Integer&gt;
   * @throws ApiException if fails to make API call
   */
  public Map<String, Integer> getInventory() throws ApiException {
    Object postBody = null;

    // create path and map variables
    String path = "/store/inventory";

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();


    final String[] accepts = {
            "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {

    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[]{"api_key"};

    GenericType<Map<String, Integer>> returnType = new GenericType<Map<String, Integer>>() {
    };
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
  }

  /**
   * Find purchase order by ID
   * For valid response try integer IDs with value &gt;&#x3D; 1 and &lt;&#x3D; 10. Other values will generated exceptions
   *
   * @param orderId ID of pet that needs to be fetched (required)
   * @return Order
   * @throws ApiException if fails to make API call
   */
  public Order getOrderById(Long orderId) throws ApiException {
    Object postBody = null;

    // verify the required parameter 'orderId' is set
    if (orderId == null) {
      throw new ApiException(400, "Missing the required parameter 'orderId' when calling getOrderById");
    }

    // create path and map variables
    String path = "/store/order/{orderId}"
            .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();


    final String[] accepts = {
            "application/json", "application/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {

    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[]{};

    GenericType<Order> returnType = new GenericType<Order>() {
    };
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
  }

  /**
   * Place an order for a pet
   *
   * @param body order placed for purchasing the pet (required)
   * @return Order
   * @throws ApiException if fails to make API call
   */
  public Order placeOrder(Order body) throws ApiException {
    Object postBody = body;

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling placeOrder");
    }

    // create path and map variables
    String path = "/store/order";

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();


    final String[] accepts = {
            "application/json", "application/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
            "application/json"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[]{};

    GenericType<Order> returnType = new GenericType<Order>() {
    };
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
  }
}
