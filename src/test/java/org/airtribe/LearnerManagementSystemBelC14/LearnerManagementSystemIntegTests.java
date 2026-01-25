package org.airtribe.LearnerManagementSystemBelC14;

import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LearnerManagementSystemIntegTests {

    @Autowired
    private MockMvc _mockMvc;

    @Autowired
    private LearnerRepository _learnerRepository;

    @BeforeEach
    public void cleanUpStale() {
        _learnerRepository.deleteAll();
    }

    @AfterEach
    public void cleanUp() {
        _learnerRepository.deleteAll();
    }

    @Test
    public void createLearner() throws Exception {
        _mockMvc.perform(MockMvcRequestBuilders.post("/learners").content("{\n" +
                "    \"learnerName\" : \"gufraan\",\n" +
                "    \"learnerEmail\" : \"gufraan@gmail.com\"\n" +
                "}").contentType("application/JSON"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void fetchLearners() throws Exception {
        _mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
                .andExpect((status().is2xxSuccessful()))
                .andDo(print());
    }
}
