package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
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


    public Assignment updateAssignment(Long id, Assignment updatedMilestone) {
        // Retrieve the existing assignment entity from the repository
        com.anyaudit.models.Assignment existingEntity = assignmentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        // Update the fields of the existing entity with the fields of the updated DTO
        existingEntity.setAssignmentName(updatedMilestone.getAssignmentName());
        existingEntity.setTypeofAssignment(updatedMilestone.getTypeofAssignment());
        existingEntity.setFinancialYear(updatedMilestone.getFinancialYear());
        existingEntity.setEngagementPartner(updatedMilestone.getEngagementPartner());
        existingEntity.setUsers(updatedMilestone.getUsers());
        existingEntity.setValue(updatedMilestone.getValue());
        existingEntity.setReviewPartner(updatedMilestone.getReviewPartner());
        existingEntity.setStartDate(updatedMilestone.getStartDate());
        existingEntity.setEndDate(updatedMilestone.getEndDate());

        // Save the updated entity back to the repository
        com.anyaudit.models.Assignment savedEntity = assignmentRepository.save(existingEntity);
        return savedEntity;
    }


    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
    public List<Object[]> findAssignmentsByClientId(Long clientId) {
        return assignmentRepository.findAssignmentsByClientId(clientId);
    }
}
