package org.airtribe.LearnerManagementSystemBelC14.controller;

import org.airtribe.LearnerManagementSystemBelC14.LearnerManagementSystemBelC14Application;
import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnerController {

    @Autowired
    private LearnerManagementService learnerService;

    @PostMapping("/learners")
    public Learner createLearner(@RequestBody Learner learner) {
    return learnerService.createLearner(learner);
    }
}
