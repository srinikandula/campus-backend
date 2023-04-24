package com.anyaudit.util;

import com.anyaudit.models.*;
import com.anyaudit.repository.*;
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

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;


    public User CreateUser(){
        User u = new User();
        u.setUsername("user");
        u.setPassword("12345");
        u.setEmail("m@m.com");
        return userRepository.save(u);
    }

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

    public Plan createPlan(){
        Client c = createClient();
        User u = CreateUser();
        Assignment a = createAssigment();
        Milestone m = createMilestone();
        Plan p = new Plan();
        p.setPlanDesc("mmm");
        p.setPlanHour(5);
        p.setUser(u);
        p.setDate(new Date());
        p.setClient(c);
        p.setAssignment(a);
        p.setMilestone(m);
        return planRepository.save(p);
    }
}
