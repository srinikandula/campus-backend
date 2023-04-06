package com.anyaudit.repository;

import com.anyaudit.models.Assignment;

import com.anyaudit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
//    Optional<Assignment> findByAssignmentname(String assignmentname);
//    Boolean existsByAssignmentname(String assignmentname);
}
