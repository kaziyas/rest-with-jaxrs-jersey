package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.model.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

    private final UserApi api = new UserApi();

    /**
     * Create user
     * <p>
     * This can only be done by the logged in user.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void createUserTest() throws Exception {
        User body = null;
        api.createUser(body);

        // TODO: test validations
    }

    /**
     * Creates list of users with given input array
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void createUsersWithArrayInputTest() throws Exception {
        List<User> body = null;
        api.createUsersWithArrayInput(body);

        // TODO: test validations
    }

    /**
     * Creates list of users with given input array
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void createUsersWithListInputTest() throws Exception {
        List<User> body = null;
        api.createUsersWithListInput(body);

        // TODO: test validations
    }

    /**
     * Delete user
     * <p>
     * This can only be done by the logged in user.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void deleteUserTest() throws Exception {
        String username = null;
        api.deleteUser(username);

        // TODO: test validations
    }

    /**
     * Get user by user name
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void getUserByNameTest() throws Exception {
        String username = null;
        User response = api.getUserByName(username);

        // TODO: test validations
    }

    /**
     * Logs user into the system
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void loginUserTest() throws Exception {
        String username = null;
        String password = null;
        String response = api.loginUser(username, password);

        // TODO: test validations
    }

    /**
     * Logs out current logged in user session
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void logoutUserTest() throws Exception {
        api.logoutUser();

        // TODO: test validations
    }

    /**
     * Updated user
     * <p>
     * This can only be done by the logged in user.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void updateUserTest() throws Exception {
        String username = null;
        User body = null;
        api.updateUser(username, body);

        // TODO: test validations
    }

}
