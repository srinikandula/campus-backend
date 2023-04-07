package com.anyaudit.service;

import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.repository.ClientRepository;
import com.anyaudit.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DashboardManager {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private MilestoneRepository milestoneRepository;

    public Map<String, Long> getDashboardCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("clientCount", clientRepository.count());
        counts.put("assignmentCount", assignmentRepository.count());
        counts.put("milestoneCount", milestoneRepository.count());
        return counts;
    }
}
