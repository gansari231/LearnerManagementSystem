package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.dto.CohortDTO;
import org.airtribe.LearnerManagementSystemBelC14.dto.LearnerDTO;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exceptions.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LearnerController {

    @Autowired
    private LearnerManagementService learnerService;

    @PostMapping("/learners")
    public Learner createLearner(@RequestBody Learner learner) {
        return learnerService.createLearner(learner);
    }

    //Combined endpoints for fetching all learners, learner by Id and learner by name
    @GetMapping("/learners")
    public List<LearnerDTO> findLearnerByComplexParams(@RequestParam(value = "learnerId", required = false) Long learnerId, @RequestParam(value = "learnerName", required = false) String learnerName) throws LearnerNotFoundException {
        List<Learner> learners = new ArrayList<>();

        if (learnerId == null && learnerName == null)
        {
            List<Learner> learnerList = learnerService.fetchAllLearners();
            return parseLearnerListToLearnerDTO(learnerList);
        }

        if (learnerId != null)
            learners.add(learnerService.fetchLearnerById(learnerId));

        if(learnerName != null)
            learners.addAll(learnerService.findLearnerByName(learnerName));

        return parseLearnerListToLearnerDTO(learners);
    }

    private List<LearnerDTO> parseLearnerListToLearnerDTO(List<Learner> learnerList) {
        List<LearnerDTO> learnerDTOList = new ArrayList<>();
        for (Learner learner : learnerList) {
            LearnerDTO learnerDTO = new LearnerDTO();
            learnerDTO.setLearnerId(learner.getLearnerId());
            learnerDTO.setLearnerEmail(learner.getLearnerEmail());
            learnerDTO.setLearnerName(learner.getLearnerName());
            learnerDTO.setCohortDTO(new ArrayList<>());
            for (Cohort cohorts : learner.getCohorts()) {
                CohortDTO cohortDTO = new CohortDTO();
                cohortDTO.setCohortId(cohorts.getCohortId());
                cohortDTO.setCohortName(cohorts.getCohortName());
                cohortDTO.setCohortDescription(cohorts.getCohortDescription());
                learnerDTO.getCohortDTO().add(cohortDTO);
            }
            learnerDTOList.add(learnerDTO);
        }

        return learnerDTOList;
    }

    @ExceptionHandler(LearnerNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
