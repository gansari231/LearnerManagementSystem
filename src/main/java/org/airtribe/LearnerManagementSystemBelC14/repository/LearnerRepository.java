package org.airtribe.LearnerManagementSystemBelC14.repository;

import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {

    /*@Query("Select l from Learner l where l.learnerName = ?1")*/
    List<Learner> findByLearnerName(String learnerName);
}
