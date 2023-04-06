package com.anyaudit.controllers;


import com.anyaudit.payload.request.Assignment;
import com.anyaudit.payload.request.Milestone;
import com.anyaudit.service.MilestoneManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/milestone")
public class MilestoneController {
    @Autowired
    private MilestoneManager milestoneManager;

    @PostMapping("/add")
    public ResponseEntity<?> addMilestone(@Valid @RequestBody Milestone milestone) {
        milestoneManager.saveMilestone(milestone);
        return ResponseEntity.ok(milestone);
    }

    @GetMapping("/milestones")
    public ResponseEntity<List<Milestone>> getAllMilestone() {
        List<Milestone> milestones = milestoneManager.getAllMilestone();
        if (milestones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(milestones);
        }
    }

    @GetMapping("/milestone/{MilestoneId}")
    public ResponseEntity<Milestone> getClientById(@PathVariable Long MilestoneId) {
        Milestone milestone = milestoneManager.getMilestoneById(MilestoneId);
        if (milestone == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(milestone);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMilestone(@PathVariable Long id, @Valid @RequestBody Milestone milestone) {
        Milestone updateMilestone = milestoneManager.updateMilestone(id, milestone);
        return ResponseEntity.ok(updateMilestone);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMilestone(@PathVariable Long id) {
        milestoneManager.deleteMilestone(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }
}
