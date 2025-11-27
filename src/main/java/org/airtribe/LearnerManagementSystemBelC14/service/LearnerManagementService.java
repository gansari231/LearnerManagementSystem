package org.airtribe.LearnerManagementSystemBelC14.service;

import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerManagementService {
    @Autowired
    private LearnerRepository _learnerRepository;

    public Learner createLearner(Learner learner) {
        return _learnerRepository.save(learner);
    }
}
