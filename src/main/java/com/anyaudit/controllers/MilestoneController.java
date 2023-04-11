package com.anyaudit.controllers;


import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import com.anyaudit.service.MilestoneManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/milestone")
public class MilestoneController {
    @Autowired
    private MilestoneManager milestoneManager;

    @GetMapping("/list")
    public List<Milestone> getAllMilestone() {
        return milestoneManager.getAllMilestone();
    }

    @GetMapping("/{id}")
    public Optional<Milestone> getMilestoneById(@PathVariable Long id) {
        return milestoneManager.getMilestoneById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMilestone(@RequestBody Milestone milestone) {
        try {
            Milestone save = milestoneManager.saveMilestone(milestone);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the assignment: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMilestone(@PathVariable Long id, @RequestBody Milestone updated) {
        try {
            Milestone savedMilestone = milestoneManager.updateMilestone(id, updated);
            return ResponseEntity.ok(savedMilestone);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the assignment: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMilestone(@PathVariable Long id) {
        milestoneManager.deleteMilestone(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }
}
