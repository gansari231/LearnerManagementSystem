package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LearnerControllerTest {

    @Autowired
    private LearnerController learnerController;

    @MockBean
    private LearnerManagementService _learnerManagementService;

    @Autowired
    private MockMvc _mockMvc;

    private List<Learner> _learnerList;

    @BeforeEach
    public void setup() {
        _learnerList = new ArrayList<>();
        Cohort cohort = new Cohort(1L, "Java", "Backend course", _learnerList);
        List<Cohort> cohorts = new ArrayList<>();
        cohorts.add(cohort);
        _learnerList.add(new Learner(1L, "guf", "guf@gmail..com", cohorts));

    }

    @Test
    public void fetchAllLearners() throws Exception {
        when(_learnerManagementService.fetchAllLearners()).thenReturn(_learnerList);
        _mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$[0].learnerName").value("guf"))
                .andExpect(jsonPath("$[0].learnerEmail").value("guf@gmail.com"));
    }
}
