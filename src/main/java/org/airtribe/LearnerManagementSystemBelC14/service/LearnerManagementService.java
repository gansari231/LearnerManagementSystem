package org.airtribe.LearnerManagementSystemBelC14.service;

import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerManagementService {
    @Autowired
    private LearnerRepository _learnerRepository;

    public Learner createLearner(Learner learner) {
        return _learnerRepository.save(learner);
    }

    public List<Learner> getAllLearners() {
        return _learnerRepository.findAll();
    }

    public Learner fetchLearnerById(Long learnerId) {
        return _learnerRepository.findById(learnerId).get();
    }

    /*public Learner findLearnerByName(String learnerName) {
        return _learnerRepository.findByName(learnerName);
    }*/

    public List<Learner> findLearnerByName(String learnerName) {
        return _learnerRepository.findByLearnerName(learnerName);
    }
}
