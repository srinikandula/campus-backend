package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.payload.request.Assignment;
import com.anyaudit.payload.request.Client;
import com.anyaudit.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentManager {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveAssignment(Assignment assignment) {
        com.anyaudit.models.Assignment c = new com.anyaudit.models.Assignment();
        c.setId(assignment.getId());
        c.setAssignmentname(assignment.getAssignmentname());
        c.setTypeofassignment(assignment.getTypeofassignment());
        c.setFinancialyear(assignment.getFinancialyear());
        c.setClientname(assignment.getClientname());
        c.setEngagementpartner(assignment.getEngagementpartner());
        c.setReviewpartner(assignment.getReviewpartner());
        c.setValue(assignment.getValue());
        c.setUsers(assignment.getUsers());
        c.setStartdate(assignment.getStartdate());
        c.setEnddate(assignment.getEnddate());
        assignmentRepository.save(c);
        return assignment;
    }

    public List<Assignment> getAllAssignment() {
        List<com.anyaudit.models.Assignment> assignments = assignmentRepository.findAll();
        List<Assignment> result = new ArrayList<>();
        for (com.anyaudit.models.Assignment c : assignments) {
            Assignment assignment = new Assignment();
            assignment.setId(c.getId());
            assignment.setAssignmentname(c.getAssignmentname());
            assignment.setTypeofassignment(c.getTypeofassignment());
            assignment.setFinancialyear(c.getFinancialyear());
            assignment.setClientname(c.getClientname());
            assignment.setEngagementpartner(c.getEngagementpartner());
            assignment.setReviewpartner(c.getReviewpartner());
            assignment.setValue(c.getValue());
            assignment.setUsers(c.getUsers());
            assignment.setStartdate(c.getStartdate());
            assignment.setEnddate(c.getEnddate());
            result.add(assignment);
        }
        return result;
    }

    public Assignment getAssignmentById(Long AssignmentId) {
        Optional<com.anyaudit.models.Assignment> optionalAssignment = assignmentRepository.findById(AssignmentId);
        if (optionalAssignment.isPresent()) {
            com.anyaudit.models.Assignment c = optionalAssignment.get();
            Assignment assignment = new Assignment();
            assignment.setId(c.getId());
            assignment.setAssignmentname(c.getAssignmentname());
            assignment.setTypeofassignment(c.getTypeofassignment());
            assignment.setFinancialyear(c.getFinancialyear());
            assignment.setClientname(c.getClientname());
            assignment.setEngagementpartner(c.getEngagementpartner());
            assignment.setReviewpartner(c.getReviewpartner());
            assignment.setValue(c.getValue());
            assignment.setUsers(c.getUsers());
            assignment.setStartdate(c.getStartdate());
            assignment.setEnddate(c.getEnddate());
            return assignment;
        } else {
            return null;
        }
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {
        Optional<com.anyaudit.models.Assignment> optionalAssignment = assignmentRepository.findById(id);
        if (optionalAssignment.isPresent()) {
            com.anyaudit.models.Assignment c = optionalAssignment.get();
            c.setAssignmentname(assignment.getAssignmentname());
            c.setTypeofassignment(assignment.getTypeofassignment());
            c.setFinancialyear(assignment.getFinancialyear());
            c.setClientname(assignment.getClientname());
            c.setEngagementpartner(assignment.getEngagementpartner());
            c.setReviewpartner(assignment.getReviewpartner());
            c.setValue(assignment.getValue());
            c.setUsers(assignment.getUsers());
            c.setStartdate(assignment.getStartdate());
            c.setEnddate(assignment.getEnddate());
            assignmentRepository.save(c);
            return assignment;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);

}
}
