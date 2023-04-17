package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;
import com.anyaudit.models.Assignment;
import com.anyaudit.repository.AssignmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolationException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AssignmentManagerTest {

    @Autowired
    private AssignmentRepository assignmentRepository;

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
}
