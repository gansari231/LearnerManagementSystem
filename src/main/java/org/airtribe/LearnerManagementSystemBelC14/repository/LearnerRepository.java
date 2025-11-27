package org.airtribe.LearnerManagementSystemBelC14.repository;

import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
