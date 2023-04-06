package com.anyaudit.controllers;


import com.anyaudit.payload.request.Assignment;

import com.anyaudit.payload.request.Client;
import com.anyaudit.service.AssignmentManager;
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
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentManager assignmentManager;

    @PostMapping("/add")
    public ResponseEntity<?> addAssignment(@Valid @RequestBody Assignment assignment) {
        assignmentManager.saveAssignment(assignment);
        return ResponseEntity.ok(assignment);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAllAssignment() {
        List<Assignment> assignments = assignmentManager.getAllAssignment();
        if (assignments.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(assignments);
        }
    }
    @GetMapping("/assignment/{AssignmentId}")
    public ResponseEntity<Assignment> getClientById(@PathVariable Long AssignmentId) {
        Assignment assignment = assignmentManager.getAssignmentById(AssignmentId);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(assignment);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long id, @Valid @RequestBody Assignment assignment) {
        Assignment updateAssignment = assignmentManager.updateAssignment(id, assignment);
        return ResponseEntity.ok(updateAssignment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        assignmentManager.deleteAssignment(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }
}

