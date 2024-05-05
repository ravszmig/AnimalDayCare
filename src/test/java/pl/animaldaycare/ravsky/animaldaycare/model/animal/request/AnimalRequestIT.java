package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.DogResponse;
import pl.animaldaycare.ravsky.animaldaycare.service.AnimalService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AnimalRequestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalService animalService;

    @Test
    void testGetAnimal() throws Exception {
        DogResponse response = new DogResponse();
        response.setName("Buddy");
        response.setAge(3);
        response.setSize(AnimalSizeEnum.MEDIUM);
        response.setDogBreed(DogBreedEnum.GERMAN_SHEPHERD);

        // Mock the behavior of the animalService.getAnimal() method
        when(animalService.getAnimal(123L)).thenReturn(response);

        // Perform the GET request to the endpoint
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/animals/get/123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Buddy"))
                .andExpect(jsonPath("$.age").value(3))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.dogBreed").value("GERMAN_SHEPHERD"))
                .andReturn();

    }

    @Test
    void testNewAnimal() throws Exception {
        DogRequest request = new DogRequest();
        request.setName("Buddy");
        request.setAge(3);
        request.setSize(AnimalSizeEnum.MEDIUM);
        request.setAnimalType(AnimalTypeEnum.DOG);
        request.setDogBreed(DogBreedEnum.GERMAN_SHEPHERD);
        request.setSpecialNeeds("Needs regular medication for arthritis");

        // Mock the behavior of the animalService.saveAnimal() method
        when(animalService.saveAnimal(request)).thenReturn(123L);

        // Perform the PUT request to the endpoint
        MvcResult mvcResult = mockMvc.perform(put("/api/v1/animals/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andReturn();

        // Validate the response
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("0", content); // Assuming the returned value is the ID of the newly created animal
    }

    // Utility method to convert an object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}