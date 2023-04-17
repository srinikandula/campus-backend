package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentManager {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        List<com.anyaudit.models.Assignment> assignments = assignmentRepository.findAll();
        return assignments;
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment saveAssignment(Assignment assignment) {
        // Save the entity and map it back to the DTO
        Assignment savedEntity = assignmentRepository.save(assignment);
        return savedEntity;
    }

    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        // Retrieve the existing assignment entity from the repository
        com.anyaudit.models.Assignment existingEntity = assignmentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Update the fields of the existing entity with the fields of the updated DTO
        existingEntity.setAssignmentName(updatedAssignment.getAssignmentName());
        existingEntity.setTypeofAssignment(updatedAssignment.getTypeofAssignment());
        existingEntity.setFinancialYear(updatedAssignment.getFinancialYear());
        existingEntity.setEngagementPartner(updatedAssignment.getEngagementPartner());
        existingEntity.setReviewPartner(updatedAssignment.getReviewPartner());
        existingEntity.setUsers(updatedAssignment.getUsers());
        existingEntity.setValue(updatedAssignment.getValue());
        existingEntity.setStartDate(updatedAssignment.getStartDate());
        existingEntity.setEndDate(updatedAssignment.getEndDate());
        // Save the updated entity back to the repository
        com.anyaudit.models.Assignment savedEntity = assignmentRepository.save(existingEntity);
        return savedEntity;
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
    public List<Assignment> findAssignmentsByClientId(Long clientId) {
        return assignmentRepository.findAssignmentsByClientId(clientId);
    }
}
