package com.anyaudit.repository;

import com.anyaudit.models.Assignment;
import org.springframework.data.jpa.repository.Query;
import com.anyaudit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    @Query(value = "SELECT assignment_id, assignment_name FROM assignment WHERE client_id = :clientId", nativeQuery = true)
    List<Assignment> findAssignmentsByClientId(@Param("clientId") Long clientId);
}
