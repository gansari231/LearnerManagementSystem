package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.LearnerManagementSystemBelC14Application;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@GetMapping("/learners")
    public List<Learner> getAllLearners() {
        return learnerService.getAllLearners();
    }*/

    /*@GetMapping("/learners/{learnerId}")
    public Learner getLearnerById(@PathVariable Long learnerId) {
        return learnerService.fetchLearnerById(learnerId);
    }*/

    /*@GetMapping("/learners/{learnerName}")
    public Learner getLearnerByName(@PathVariable String learnerName) {
        return learnerService.findLearnerByName(learnerName);
    }*/

    @GetMapping("/learners")
    public List<Learner> findLearnerByComplexParams(@RequestParam(value = "learnerId", required = false) Long learnerId, @RequestParam(value = "learnerName", required = false) String learnerName) {
        List<Learner> learners = new ArrayList<>();

        if (learnerId == null && learnerName == null)
            return learnerService.getAllLearners();

        if (learnerId != null)
            learners.add(learnerService.fetchLearnerById(learnerId));

        if(learnerName != null)
            learners.addAll(learnerService.findLearnerByName(learnerName));

        return learners;
    }
}
