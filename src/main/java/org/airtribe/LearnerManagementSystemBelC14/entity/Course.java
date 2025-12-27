package org.airtribe.LearnerManagementSystemBelC14.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<Cohort> cohorts;

    public Course() {
    }

    public Course(Long courseId, String courseName, List<Cohort> cohorts) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.cohorts = cohorts;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Cohort> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<Cohort> cohorts) {
        this.cohorts = cohorts;
    }
}
