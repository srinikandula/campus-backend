package com.anyaudit.controllers;


import com.anyaudit.models.Assignment;
import com.anyaudit.service.AssignmentManager;
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
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentManager assignmentManager;

    @GetMapping("/list")
    public List<Assignment> getAllAssignments() {
        return assignmentManager.getAllAssignments();
    }

    @GetMapping("/{id}")
    public Optional<Assignment> getAssignmentById(@PathVariable Long id) {
        return assignmentManager.getAssignmentById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAssignment(@RequestBody Assignment assignment) {
        try {
            Assignment savedAssignment = assignmentManager.saveAssignment(assignment);
            return ResponseEntity.ok(savedAssignment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the assignment: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignment) {
        try {
            Assignment savedAssignment = assignmentManager.updateAssignment(id, updatedAssignment);
            return ResponseEntity.ok(savedAssignment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the assignment: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        assignmentManager.deleteAssignment(id);
        return ResponseEntity.ok().body("Client with ID " + id + " successfully deleted.");
    }

}

