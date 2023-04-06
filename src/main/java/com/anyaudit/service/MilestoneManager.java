package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.payload.request.Assignment;
import com.anyaudit.payload.request.Milestone;
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

    public Milestone saveMilestone(Milestone milestone) {
        com.anyaudit.models.Milestone c = new com.anyaudit.models.Milestone();
        c.setId(milestone.getId());
        c.setAssignmentname(milestone.getAssignmentname());
        c.setMilestonename(milestone.getMilestonename());
        c.setCheckeruser(milestone.getCheckeruser());
        c.setTeam(milestone.getTeam());
        c.setStartdate(milestone.getStartdate());
        c.setEnddate(milestone.getEnddate());
        milestoneRepository.save(c);
        return milestone;
    }

    public List<Milestone> getAllMilestone() {
        List<com.anyaudit.models.Milestone> milestones = milestoneRepository.findAll();
        List<Milestone> result = new ArrayList<>();
        for (com.anyaudit.models.Milestone c : milestones) {
            Milestone milestone = new Milestone();
            milestone.setId(c.getId());
            milestone.setAssignmentname(c.getAssignmentname());
            milestone.setMilestonename(c.getMilestonename());
            milestone.setCheckeruser(c.getCheckeruser());
            milestone.setTeam(c.getTeam());
            milestone.setStartdate(c.getStartdate());
            milestone.setEnddate(c.getEnddate());
            result.add(milestone);
        }
        return result;
    }

    public Milestone getMilestoneById(Long MilestoneId) {
        Optional<com.anyaudit.models.Milestone> optionalMilestone = milestoneRepository.findById(MilestoneId);
        if (optionalMilestone.isPresent()) {
            com.anyaudit.models.Milestone c = optionalMilestone.get();
            Milestone milestone = new Milestone();
            milestone.setId(c.getId());
            milestone.setAssignmentname(c.getAssignmentname());
            milestone.setMilestonename(c.getMilestonename());
            milestone.setCheckeruser(c.getCheckeruser());
            milestone.setTeam(c.getTeam());
            milestone.setStartdate(c.getStartdate());
            milestone.setEnddate(c.getEnddate());
            return milestone;
        } else {
            return null;
        }
    }

    public Milestone updateMilestone(Long id, Milestone milestone) {
        Optional<com.anyaudit.models.Milestone> optionalMilestone = milestoneRepository.findById(id);
        if (optionalMilestone.isPresent()) {
            com.anyaudit.models.Milestone c = optionalMilestone.get();
            c.setAssignmentname(milestone.getAssignmentname());
            c.setMilestonename(milestone.getMilestonename());
            c.setCheckeruser(milestone.getCheckeruser());
            c.setTeam(milestone.getTeam());
            c.setStartdate(milestone.getStartdate());
            c.setEnddate(milestone.getEnddate());
            milestoneRepository.save(c);
            return milestone;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);

    }
}
