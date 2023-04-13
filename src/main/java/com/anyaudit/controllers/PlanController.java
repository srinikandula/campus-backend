package com.anyaudit.controllers;

import com.anyaudit.models.Milestone;
import com.anyaudit.models.Plan;
import com.anyaudit.service.MilestoneManager;
import com.anyaudit.service.PlanManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/plan")
public class PlanController {
    @Autowired
    private PlanManager planManager;
    @GetMapping("/list")
    public List<Plan> getAllPlan() {
        return planManager.getAllPlan();
    }

    @GetMapping("/{id}")
    public Optional<Plan> getMilestoneById(@PathVariable Long id) {
        return planManager.getPlanById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePlan(@RequestBody Plan plan) {
        try {
            Plan save = planManager.savePlan(plan);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the assignment: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMilestone(@PathVariable Long id, @RequestBody Plan updated) {
        try {
            Plan saved = planManager.updatePlan(id, updated);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the assignment: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMilestone(@PathVariable Long id) {
        planManager.deleteMilestone(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }
}
