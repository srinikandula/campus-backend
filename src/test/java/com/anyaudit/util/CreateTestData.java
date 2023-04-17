package com.anyaudit.util;

import com.anyaudit.models.Assignment;
import com.anyaudit.models.Client;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateTestData {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

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
}
