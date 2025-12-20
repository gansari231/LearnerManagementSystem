package org.airtribe.LearnerManagementSystemBelC14.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long learnerId;

    private String learnerName;

    private String learnerEmail;

    public Learner() {
    }

    public Learner(long learnerId, String learnerName, String learnerEmail) {
        this.learnerId = learnerId;
        this.learnerName = learnerName;
        this. learnerEmail = learnerEmail;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public String getLearnerEmail() {
        return learnerEmail;
    }

    public void setLearnerEmail(String learnerEmail) {
        this.learnerEmail = learnerEmail;
    }
}
