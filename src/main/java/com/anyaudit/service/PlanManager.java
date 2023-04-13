package com.anyaudit.service;

import com.anyaudit.exception.ClientNotFoundException;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.*;
import com.anyaudit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanManager {
    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> getAllPlan() {
        List<com.anyaudit.models.Plan> plans = planRepository.findAll();
        List<Plan> result = new ArrayList<>();
        for (com.anyaudit.models.Plan c : plans) {
            Plan plan = new Plan();
            plan.setId(c.getId());
            plan.setMilestone(c.getMilestone());
            plan.setDate(c.getDate());
            plan.setUser(c.getUser());
            plan.setPlanHour(c.getPlanHour());
            plan.setPlanDesc(c.getPlanDesc());
            plan.setClient(c.getClient());
            plan.setAssignment(c.getAssignment());
            result.add(plan);
        }
        return result;
    }
    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    public Plan savePlan(Plan plan) {
        // Retrieve the client object by id
        Client client = clientRepository.findById(plan.getClient().getId())
                .orElseThrow(() -> new ClientNotFoundException(plan.getClient().getId()));

        Assignment assignment = assignmentRepository.findById(plan.getAssignment().getId())
                .orElseThrow(() -> new ClientNotFoundException(plan.getAssignment().getId()));

        Milestone milestone = milestoneRepository.findById(plan.getMilestone().getId())
                .orElseThrow(() -> new ClientNotFoundException(plan.getMilestone().getId()));

        User user = userRepository.findById(plan.getUser().getId())
                .orElseThrow(() -> new ClientNotFoundException(plan.getUser().getId()));

        // Map the Assignment DTO to the Assignment entity
        com.anyaudit.models.Plan entity = new com.anyaudit.models.Plan();
        entity.setDate(plan.getDate());
        entity.setPlanHour(plan.getPlanHour());
        entity.setPlanDesc(plan.getPlanDesc());
        entity.setClient(client);
        entity.setUser(user);
        entity.setMilestone(milestone);
        entity.setAssignment(assignment);

        // Save the entity and map it back to the DTO
        com.anyaudit.models.Plan savedEntity = planRepository.save(entity);
        Plan saved = new Plan();
        saved.setId(savedEntity.getId());
        saved.setDate(savedEntity.getDate());
        saved.setPlanHour(savedEntity.getPlanHour());
        saved.setPlanDesc(savedEntity.getPlanDesc());
        saved.setUser(savedEntity.getUser());
        saved.setMilestone(savedEntity.getMilestone());
        saved.setClient(savedEntity.getClient());
        saved.setAssignment(savedEntity.getAssignment());
        return saved;
    }

    public Plan updatePlan(Long id, Plan updated) {

        com.anyaudit.models.Plan existingEntity = planRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));


        existingEntity.setDate(updated.getDate());
        existingEntity.setPlanDesc(updated.getPlanDesc());
        existingEntity.setPlanHour(updated.getPlanHour());

        // Save the updated entity back to the repository
        com.anyaudit.models.Plan savedEntity = planRepository.save(existingEntity);

        // Map the updated entity back and return it
        Plan savedAssignment = new Plan();
        savedAssignment.setId(savedEntity.getId());
        savedAssignment.setDate(savedEntity.getDate());
        savedAssignment.setUser(savedEntity.getUser());
        savedAssignment.setPlanHour(savedEntity.getPlanHour());
        savedAssignment.setPlanDesc(savedEntity.getPlanDesc());
        savedAssignment.setMilestone(savedEntity.getMilestone());
        savedAssignment.setClient(savedEntity.getClient());
        savedAssignment.setAssignment(savedEntity.getAssignment());
        return savedAssignment;
    }

    public void deleteMilestone(Long id) {
        planRepository.deleteById(id);

    }
}
