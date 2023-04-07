package com.anyaudit.controllers;

import com.anyaudit.service.DashboardManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api")
public class Dashboard {

    @Autowired
    private DashboardManager dashboardManager;

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Long>> getDashboardCounts() {
        Map<String, Long> counts = dashboardManager.getDashboardCounts();
        if (counts.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(counts);
        }
    }
}
