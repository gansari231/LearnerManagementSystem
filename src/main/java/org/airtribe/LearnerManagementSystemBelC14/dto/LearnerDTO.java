package org.airtribe.LearnerManagementSystemBelC14.dto;

import java.util.List;

public class LearnerDTO {

    private Long learnerId;

    private String learnerName;

    private String learnerEmail;

    private List<CohortDTO> cohortDTO;

    public LearnerDTO() {
    }

    public LearnerDTO(Long learnerId, String learnerName, String learnerEmail, List<CohortDTO> cohortDTO) {
        this.learnerId = learnerId;
        this.learnerName = learnerName;
        this.learnerEmail = learnerEmail;
        this.cohortDTO = cohortDTO;
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

    public List<CohortDTO> getCohortDTO() {
        return cohortDTO;
    }

    public void setCohortDTO(List<CohortDTO> cohortDTO) {
        this.cohortDTO = cohortDTO;
    }
}
