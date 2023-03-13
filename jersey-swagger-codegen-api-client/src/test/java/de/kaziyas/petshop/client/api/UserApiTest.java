package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.invoker.ApiException;
import de.kaziyas.petshop.client.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private final UserApi api = new UserApi();

    private User user;
    private User user1;
    /**
     * Create user
     * <p>
     * This can only be done by the logged in user.
     *
     * @throws Exception if the Api call fails
     */

    @Before
    public void setup() {
        this.user = createUser();
        this.user1 = createUser1();
    }

    @Test
    public void createUserTest() throws Exception {
        api.createUser(user);

        User response = api.getUserByName(user.getUsername());
        Assert.assertEquals(user.getFirstName(), response.getFirstName());
        Assert.assertEquals(user.getLastName(), response.getLastName());
    }

    /**
     * Creates list of users with given input array
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void createUsersWithArrayInputTest() throws Exception {
        User[] body = {user, user1};
        api.createUsersWithArrayInput(Arrays.asList(body));

        User response = api.getUserByName(user.getUsername());
        Assert.assertEquals(user.getId(), response.getId());

        response = api.getUserByName(user1.getUsername());
        Assert.assertEquals(user1.getId(), response.getId());
    }

    /**
     * Creates list of users with given input array
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void createUsersWithListInputTest() throws Exception {
        List<User> body = new ArrayList<>();
        body.add(user);
        body.add(user1);
        api.createUsersWithListInput(body);

        User response = api.getUserByName(user.getUsername());
        Assert.assertEquals(user.getId(), response.getId());

        response = api.getUserByName(user1.getUsername());
        Assert.assertEquals(user1.getId(), response.getId());
    }

    /**
     * Delete user
     * <p>
     * This can only be done by the logged in user.
     *
     * @throws Exception if the Api call fails
     */
    @Test(expected = ApiException.class)
    public void deleteUserTest() throws Exception {
        String username = user1.getUsername();
        api.deleteUser(username);
        api.getUserByName(username);
    }

    /**
     * Get user by user name
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void getUserByNameTest() throws Exception {
        String username = user.getUsername();
        User response = api.getUserByName(username);
        Assert.assertEquals(user.getFirstName(), response.getFirstName());
        Assert.assertEquals(user.getLastName(), response.getLastName());
    }

    /**
     * Logs user into the system
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void loginUserTest() throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        String response = api.loginUser(username, password);
        Assert.assertNotNull(response);
        Assert.assertEquals("\"code\":200", response.substring(1, 11));
    }

    /**
     * Logs out current logged in user session
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void logoutUserTest() throws Exception {
        api.logoutUser();
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
        String newUsername = "yaser1541";
        api.updateUser(newUsername, user);
    }

    private User createUser() {
        user = new User();
        user.setId(19812015L);
        user.setUsername("yaser");
        user.setFirstName("yaser");
        user.setLastName("kazerooni");
        user.setEmail("yaser.kazerooni@gmail.com");
        user.setPassword("A123456");
        user.setPhone("1234567");
        user.setUserStatus(-19812015);

        return user;
    }

    private User createUser1() {
        user1 = new User();
        user1.setId(81164066L);
        user1.setUsername("mehrad");
        user1.setFirstName("mehrad");
        user1.setLastName("kazerooni");
        user1.setEmail("mehrad.kazerooni@gmail.com");
        user1.setPassword("l654321");
        user1.setPhone("654321");
        user1.setUserStatus(-98741215);

        return user1;
    }
}
