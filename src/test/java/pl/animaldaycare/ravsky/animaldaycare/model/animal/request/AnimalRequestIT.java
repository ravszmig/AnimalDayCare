package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AnimalRequestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDogRequestDeserialization() throws Exception {
        String json = "{\"age\":3,\"name\":\"Buddy\",\"size\":\"MEDIUM\",\"animalType\":\"DOG\",\"dogBreed\":\"GERMAN_SHEPHERD\",\"specialNeeds\":\"Needs regular medication for arthritis\"}";

        mockMvc.perform(put("/api/v1/animals/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(3))
                .andExpect(jsonPath("$.name").value("Buddy"))
                .andExpect(jsonPath("$.size").value("MEDIUM"))
                .andExpect(jsonPath("$.animalType").value("DOG"));
    }
}