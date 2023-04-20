package com.anyaudit.repository;

import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    @Query(value = "SELECT id, milestone_name FROM campus.milestone WHERE assignment_id = :id", nativeQuery = true)
    List<Object[]> findbyMilstoneId(@Param("id") Long id);
}
