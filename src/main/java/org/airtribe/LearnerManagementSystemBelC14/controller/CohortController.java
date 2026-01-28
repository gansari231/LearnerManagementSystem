package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exceptions.CohortNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.exceptions.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("cohortControllerLegacy")
public class CohortController {

    @Autowired
    private LearnerManagementService _learnerManagementService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cohorts")
    private Cohort createCohorts(@RequestBody Cohort cohort) {
       return _learnerManagementService.createCohort(cohort);
    }

    @GetMapping("/cohorts")
    private List<Cohort> getAllCohorts() {
        return _learnerManagementService.fetchAllCohorts();
    }

    @PostMapping("/assignLearnersToCohorts")
    private Cohort assignLearnersToCohorts(@RequestParam("cohortId") Long cohortId, @RequestParam("learnerId") Long learnerId) throws CohortNotFoundException, LearnerNotFoundException {
        return  _learnerManagementService.assignLearnerToCohorts(cohortId, learnerId);
    }

    @PostMapping("/cohorts/{cohortId}/learners")
    private Cohort assignAndCreateLearnersToCohorts(@PathVariable("cohortId") Long cohortId, @RequestBody List<Learner> learners) throws CohortNotFoundException {
        return _learnerManagementService.assignAndCreateLearnersToCohorts(cohortId, learners);
    }

    @ExceptionHandler(CohortNotFoundException.class)
    public ResponseEntity handleCohortNotFoundException(CohortNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(LearnerNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
