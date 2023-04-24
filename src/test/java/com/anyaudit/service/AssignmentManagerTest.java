package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Client;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.util.CreateTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.jupiter.api.Assertions;
import javax.validation.ConstraintViolationException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AssignmentManagerTest {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CreateTestData createTestData;
    @Before
    @After
    public void setup() {

    }

    @Test
    void saveAssignment() {
        //save assignment without data
        Assignment a = new Assignment();
        ConstraintViolationException thrown = assertThrows(
                ConstraintViolationException.class,
                () -> assignmentRepository.save(a),
                "Expected save assignement without data to throw ConstraintViolationException, but it didn't"
        );
        assertNotNull(thrown);
    }
    @Test
    void saveAssignmentWithoutName() {
        //save assignment without data
        Assignment a = new Assignment();
        a.setTypeofAssignment("type");
        a.setFinancialYear("2022");
        a.setUsers("users");
        a.setEngagementPartner("epartner");
        a.setReviewPartner("rpartner");
        a.setClient(createTestData.createClient());
        a.setValue("Assignment");
        a.setEndDate(new Date());
        a.setStartDate(new Date());

        ConstraintViolationException thrown = assertThrows(
                ConstraintViolationException.class,
                () -> assignmentRepository.save(a),
                "Expected save assignement without data to throw ConstraintViolationException, but it didn't"
        );
        assertNotNull(thrown);

        a.setAssignmentName("assignemnts");
        Assignment savedEntity = assignmentRepository.save(a);
        assertNotNull(savedEntity.getId());
    }

    @Test
    void testAssignment() {
        Assignment assignment = new Assignment();
        assignment.setAssignmentName("Test Assignment");
        assignment.setTypeofAssignment("Type A");
        assignment.setFinancialYear("2022");
        assignment.setEngagementPartner("John Smith");
        assignment.setReviewPartner("Jane Doe");
        assignment.setUsers("User1, User2");
        assignment.setValue("100,000");
        Date startDate = new Date();
        assignment.setStartDate(startDate);
        Date endDate = new Date();
        assignment.setEndDate(endDate);
        Client client = new Client();
        client.setId(1L);
        assignment.setClient(client);

        Assertions.assertEquals("Test Assignment", assignment.getAssignmentName());
        Assertions.assertEquals("Type A", assignment.getTypeofAssignment());
        Assertions.assertEquals("2022", assignment.getFinancialYear());
        Assertions.assertEquals("John Smith", assignment.getEngagementPartner());
        Assertions.assertEquals("Jane Doe", assignment.getReviewPartner());
        Assertions.assertEquals("User1, User2", assignment.getUsers());
        Assertions.assertEquals("100,000", assignment.getValue());
        Assertions.assertEquals(startDate, assignment.getStartDate());
        Assertions.assertEquals(endDate, assignment.getEndDate());
        Assertions.assertEquals(client, assignment.getClient());
    }
}
