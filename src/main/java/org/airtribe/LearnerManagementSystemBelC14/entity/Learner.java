package org.airtribe.LearnerManagementSystemBelC14.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long learnerId;

    @NotBlank
    @NotNull
    private String learnerName;

    @Email
    private String learnerEmail;

    @ManyToMany(mappedBy = "learners")
    @JsonIgnore
    private List<Cohort> cohorts;

    public Learner() {
    }

    public Learner(Long learnerId, String learnerName, String learnerEmail, List<Cohort> cohorts) {
        this.learnerId = learnerId;
        this.learnerName = learnerName;
        this.learnerEmail = learnerEmail;
        this.cohorts = cohorts;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
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

    public List<Cohort> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<Cohort> cohorts) {
        this.cohorts = cohorts;
    }
}
