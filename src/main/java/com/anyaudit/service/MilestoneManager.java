package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneManager {
    @Autowired
    private MilestoneRepository milestoneRepository;



    public List<Milestone> getAllMilestone() {
        List<Milestone> milestones = milestoneRepository.findAll();
        return milestones;
    }

    public Optional<Milestone> getMilestoneById(Long id) {
        return milestoneRepository.findById(id);
    }

    public Milestone saveMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
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
        return savedEntity;
    }

    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);

    }
}
