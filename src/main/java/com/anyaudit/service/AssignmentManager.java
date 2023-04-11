package com.anyaudit.service;

import com.anyaudit.exception.ClientNotFoundException;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Client;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentManager {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        List<com.anyaudit.models.Assignment> assignments = assignmentRepository.findAll();
        List<Assignment> result = new ArrayList<>();
        for (com.anyaudit.models.Assignment c : assignments) {
            Assignment assignment = new Assignment();
            assignment.setId(c.getId());
            assignment.setAssignmentName(c.getAssignmentName());
            assignment.setTypeofAssignment(c.getTypeofAssignment());
            assignment.setFinancialYear(c.getFinancialYear());
            assignment.setEngagementPartner(c.getEngagementPartner());
            assignment.setReviewPartner(c.getReviewPartner());
            assignment.setUsers(c.getUsers());
            assignment.setValue(c.getValue());
            assignment.setStartDate(c.getStartDate());
            assignment.setEndDate(c.getEndDate());
            assignment.setClient(c.getClient());
            result.add(assignment);
        }
        return result;
    }



    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment saveAssignment(Assignment assignment) {
        // Retrieve the client object by id
        Client client = clientRepository.findById(assignment.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException(assignment.getClient().getId()));

        // Map the Assignment DTO to the Assignment entity
        com.anyaudit.models.Assignment entity = new com.anyaudit.models.Assignment();
        entity.setAssignmentName(assignment.getAssignmentName());
        entity.setTypeofAssignment(assignment.getTypeofAssignment());
        entity.setFinancialYear(assignment.getFinancialYear());
        entity.setEngagementPartner(assignment.getEngagementPartner());
        entity.setReviewPartner(assignment.getReviewPartner());
        entity.setUsers(assignment.getUsers());
        entity.setValue(assignment.getValue());
        entity.setStartDate(assignment.getStartDate());
        entity.setEndDate(assignment.getEndDate());
        entity.setClient(client);

        // Save the entity and map it back to the DTO
        com.anyaudit.models.Assignment savedEntity = assignmentRepository.save(entity);
        Assignment savedAssignment = new Assignment();
        savedAssignment.setId(savedEntity.getId());
        savedAssignment.setAssignmentName(savedEntity.getAssignmentName());
        savedAssignment.setTypeofAssignment(savedEntity.getTypeofAssignment());
        savedAssignment.setFinancialYear(savedEntity.getFinancialYear());
        savedAssignment.setEngagementPartner(savedEntity.getEngagementPartner());
        savedAssignment.setReviewPartner(savedEntity.getReviewPartner());
        savedAssignment.setValue(savedEntity.getValue());
        savedAssignment.setStartDate(savedEntity.getStartDate());
        savedAssignment.setEndDate(savedEntity.getEndDate());
        savedAssignment.setClient(savedEntity.getClient());

        return savedAssignment;
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

        // Map the updated entity back to a DTO and return it
        Assignment savedAssignment = new Assignment();
        savedAssignment.setId(savedEntity.getId());
        savedAssignment.setAssignmentName(savedEntity.getAssignmentName());
        savedAssignment.setTypeofAssignment(savedEntity.getTypeofAssignment());
        savedAssignment.setFinancialYear(savedEntity.getFinancialYear());
        savedAssignment.setEngagementPartner(savedEntity.getEngagementPartner());
        savedAssignment.setReviewPartner(savedEntity.getReviewPartner());
        savedAssignment.setUsers(savedEntity.getUsers());
        savedAssignment.setValue(savedEntity.getValue());
        savedAssignment.setStartDate(savedEntity.getStartDate());
        savedAssignment.setEndDate(savedEntity.getEndDate());
        savedAssignment.setClient(savedEntity.getClient());
        return savedAssignment;
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);

    }
}
