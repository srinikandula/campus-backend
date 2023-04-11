package com.anyaudit.service;

import com.anyaudit.exception.ClientNotFoundException;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Client;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.repository.ClientRepository;
import com.anyaudit.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MilestoneManager {
    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;


    public List<Milestone> getAllMilestone() {
        List<com.anyaudit.models.Milestone> assignments = milestoneRepository.findAll();
        List<Milestone> result = new ArrayList<>();
        for (com.anyaudit.models.Milestone c : assignments) {
            Milestone milestone = new Milestone();
            milestone.setId(c.getId());
            milestone.setMilestoneName(c.getMilestoneName());
            milestone.setCheckerUser(c.getCheckerUser());
            milestone.setTeam(c.getTeam());
            milestone.setStartDate(c.getStartDate());
            milestone.setEndDate(c.getEndDate());
            milestone.setClient(c.getClient());
            milestone.setAssignment(c.getAssignment());
            result.add(milestone);
        }
        return result;
    }

    public Optional<Milestone> getMilestoneById(Long id) {
        return milestoneRepository.findById(id);
    }

    public Milestone saveMilestone(Milestone milestone) {
        // Retrieve the client object by id
        Client client = clientRepository.findById(milestone.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException(milestone.getClient().getId()));

        Assignment assignment = assignmentRepository.findById(milestone.getAssignment().getId())
                .orElseThrow(() -> new ClientNotFoundException(milestone.getAssignment().getId()));

        // Map the Assignment DTO to the Assignment entity
        com.anyaudit.models.Milestone entity = new com.anyaudit.models.Milestone();
        entity.setMilestoneName(milestone.getMilestoneName());
        entity.setCheckerUser(milestone.getCheckerUser());
        entity.setTeam(milestone.getTeam());
        entity.setStartDate(milestone.getStartDate());
        entity.setEndDate(milestone.getEndDate());
        entity.setClient(client);
        entity.setAssignment(assignment);

        // Save the entity and map it back to the DTO
        com.anyaudit.models.Milestone savedEntity = milestoneRepository.save(entity);
        Milestone saved = new Milestone();
        saved.setId(savedEntity.getId());
        saved.setMilestoneName(savedEntity.getMilestoneName());
        saved.setCheckerUser(savedEntity.getCheckerUser());
        saved.setTeam(savedEntity.getTeam());
        saved.setStartDate(savedEntity.getStartDate());
        saved.setEndDate(savedEntity.getEndDate());
        saved.setClient(savedEntity.getClient());
        saved.setAssignment(savedEntity.getAssignment());


        return saved;
    }

    public Milestone updateMilestone(Long id, Milestone updatedMilestone) {
        // Retrieve the existing assignment entity from the repository
        com.anyaudit.models.Milestone existingEntity = milestoneRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // Update the fields of the existing entity with the fields of the updated DTO
        existingEntity.setMilestoneName(updatedMilestone.getMilestoneName());
        existingEntity.setCheckerUser(updatedMilestone.getCheckerUser());
        existingEntity.setTeam(updatedMilestone.getTeam());
        existingEntity.setStartDate(updatedMilestone.getStartDate());
        existingEntity.setEndDate(updatedMilestone.getEndDate());

        // Save the updated entity back to the repository
        com.anyaudit.models.Milestone savedEntity = milestoneRepository.save(existingEntity);

        // Map the updated entity back to a DTO and return it
        Milestone savedAssignment = new Milestone();
        savedAssignment.setId(savedEntity.getId());
        savedAssignment.setMilestoneName(savedEntity.getMilestoneName());
        savedAssignment.setCheckerUser(savedEntity.getCheckerUser());
        savedAssignment.setTeam(savedEntity.getTeam());
        savedAssignment.setStartDate(savedEntity.getStartDate());
        savedAssignment.setEndDate(savedEntity.getEndDate());
        savedAssignment.setClient(savedEntity.getClient());
        savedAssignment.setAssignment(savedEntity.getAssignment());
        return savedAssignment;
    }

    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);

    }
}
