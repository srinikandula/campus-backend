package com.anyaudit.util;

import com.anyaudit.models.Assignment;
import com.anyaudit.models.Client;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.repository.ClientRepository;
import com.anyaudit.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateTestData {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private MilestoneRepository milestoneRepository;

    public Client createClient(){
        Client c = new Client();
        c.setEmail("e@e.com");
        c.setName("client");
        c.setFileNo("34343");
        c.setFinancialFramework("FF");
        c.setPhoneNo("3454334534");
        return clientRepository.save(c);
    }

    public Assignment createAssigment(){
        Client c = createClient();
        Assignment a = new Assignment();
        a.setAssignmentName("aname");
        a.setClient(c);
        a.setEndDate(new Date());
        a.setValue("a");
        a.setReviewPartner("rp");
        a.setEngagementPartner("ep");
        a.setUsers("us");
        a.setFinancialYear("2013");
        a.setTypeofAssignment("loans");
        return assignmentRepository.save(a);
    }

    public Milestone createMilestone(){
        Client c = createClient();
        Assignment a = createAssigment();
        Milestone m = new Milestone();
        m.setMilestoneName("mmm");
        m.setCheckerUser("user");
        m.setTeam("team");
        m.setStartDate(new Date());
        m.setEndDate(new Date());
        m.setClient(c);
        m.setAssignment(a);
        return milestoneRepository.save(m);
    }
}
