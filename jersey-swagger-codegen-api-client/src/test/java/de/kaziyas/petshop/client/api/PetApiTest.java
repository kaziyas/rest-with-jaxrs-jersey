package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.model.ModelApiResponse;
import de.kaziyas.petshop.client.model.Pet;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * API tests for PetApi
 */
@Ignore
public class PetApiTest {

    private final PetApi api = new PetApi();

    /**
     * Add a new pet to the store
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void addPetTest() throws Exception {
        Pet body = null;
        api.addPet(body);

        // TODO: test validations
    }

    /**
     * Deletes a pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void deletePetTest() throws Exception {
        Long petId = null;
        String apiKey = null;
        api.deletePet(petId, apiKey);

        // TODO: test validations
    }

    /**
     * Finds Pets by status
     * <p>
     * Multiple status values can be provided with comma separated strings
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void findPetsByStatusTest() throws Exception {
        List<String> status = null;
        List<Pet> response = api.findPetsByStatus(status);

        // TODO: test validations
    }

    /**
     * Find pet by ID
     * <p>
     * Returns a single pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void getPetByIdTest() throws Exception {
        Long petId = null;
        Pet response = api.getPetById(petId);

        // TODO: test validations
    }

    /**
     * Update an existing pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void updatePetTest() throws Exception {
        Pet body = null;
        api.updatePet(body);

        // TODO: test validations
    }

    /**
     * Updates a pet in the store with form data
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void updatePetWithFormTest() throws Exception {
        Long petId = null;
        String name = null;
        String status = null;
        api.updatePetWithForm(petId, name, status);

        // TODO: test validations
    }

    /**
     * uploads an image
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void uploadFileTest() throws Exception {
        Long petId = null;
        String additionalMetadata = null;
        File file = null;
        ModelApiResponse response = api.uploadFile(petId, additionalMetadata, file);

        // TODO: test validations
    }

}
