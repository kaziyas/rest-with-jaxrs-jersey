package de.kaziyas.petshop.client.api;

import de.kaziyas.petshop.client.invoker.ApiException;
import de.kaziyas.petshop.client.model.Category;
import de.kaziyas.petshop.client.model.ModelApiResponse;
import de.kaziyas.petshop.client.model.Pet;
import de.kaziyas.petshop.client.model.Tag;
import org.junit.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * API tests for PetApi
 */
public class PetApiTest {

    private final PetApi api = new PetApi();

    private Pet pet;
    private List<String> photoUrls;
    private Category category;
    private List<Tag> tags;

    /**
     * Add a new pet to the store
     *
     * @throws Exception if the Api call fails
     */

    @Before
    public void setup() {
        pet = createPet();
        photoUrls = createPhotoUrls();
        category = createCategory();
        tags = createTags();
    }

    @Test
    public void addPetTest() throws Exception {
        Pet body = pet;
        api.addPet(body);

        Pet response = api.getPetById(pet.getId());
        Assert.assertEquals(pet.getId(), response.getId());
    }

    /**
     * Deletes a pet
     *
     * @throws Exception if the Api call fails
     */
    @Test(expected = ApiException.class)
    public void deletePetTest() throws Exception {
        Pet pet1 = createPet1();
        api.addPet(pet1);

        Long petId = pet1.getId();
        String apiKey = null;
        api.deletePet(petId, apiKey);

        api.getPetById(petId);
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
        List<String> status = new ArrayList<>();
        status.add(Pet.StatusEnum.AVAILABLE.getValue());
        status.add(Pet.StatusEnum.SOLD.getValue());

        List<Pet> response = api.findPetsByStatus(status);
        Assert.assertEquals(Pet.StatusEnum.AVAILABLE, response.get(0).getStatus());

        List<Pet> invalidPets = response.stream().filter(e -> e.getStatus().equals(Pet.StatusEnum.PENDING)).collect(Collectors.toList());
        Assert.assertEquals(0, invalidPets.size());
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
        Long petId = 22408871L;
        Pet response = api.getPetById(petId);

        Assert.assertEquals(pet.getId(), response.getId());
    }

    /**
     * Update an existing pet
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void updatePetTest() throws Exception {
        Pet body = pet;
        body.setName("Tiger");
        api.updatePet(body);

        Pet response = api.getPetById(body.getId());
        Assert.assertEquals("Tiger", response.getName());
    }

    /**
     * Updates a pet in the store with form data
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void updatePetWithFormTest() throws Exception {
        Long petId = pet.getId();
        String name = "Lion";
        String status = Pet.StatusEnum.SOLD.getValue();
        api.updatePetWithForm(petId, name, status);

        Pet response = api.getPetById(petId);

        Assert.assertEquals(name, response.getName());
        Assert.assertNotEquals(pet.getName(), response.getName());
        Assert.assertNotEquals(pet.getStatus(), response.getStatus());
    }

    /**
     * uploads an image
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void uploadFileTest() throws Exception {
        Long petId = pet.getId();
        String additionalMetadata = "this is a test for upload file service";

        File file = new File("sample.txt");
     //   ModelApiResponse response = api.uploadFile(petId, additionalMetadata, file);
    }

    private Pet createPet() {
        Pet pet = new Pet();
        pet.setId(22408871L);
        pet.setName("doggie");
        pet.setStatus(Pet.StatusEnum.AVAILABLE);

        pet.setPhotoUrls(photoUrls);
        pet.setCategory(category);
        pet.setTags(tags);
        return pet;
    }

    private Pet createPet1() {
        Pet pet = new Pet();
        pet.setId(19810821L);
        pet.setName("ant");
        pet.setStatus(Pet.StatusEnum.SOLD);

        pet.setPhotoUrls(photoUrls);
        pet.setCategory(category);
        pet.setTags(tags);
        return pet;
    }

    private List<String> createPhotoUrls() {
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("ea nostrud occaecat reprehenderit");
        photoUrls.add("consequat eu dolore");
        return photoUrls;
    }

    private Category createCategory() {
        Category category = new Category();
        category.setId(27710153L);
        category.setName("in ipsum enim");
        return category;
    }

    private List<Tag> createTags() {
        Tag tag = new Tag();
        tag.setId(-68369270L);
        tag.setName("veniam reprehenderit");

        Tag tag1 = new Tag();
        tag1.setId(-76889784L);
        tag.setName("anim adipisicing veniam minim");

        List<Tag> tags = new ArrayList();
        tags.add(tag);
        tags.add(tag1);

        return tags;
    }

}
