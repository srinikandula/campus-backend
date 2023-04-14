package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
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

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MilestoneManagerTest {

    @Autowired
    private MilestoneManager milestoneManager;

    @Autowired
    private CreateTestData createTestData;

    @Before
    @After
    public void setup() {

    }

    @Test
    void saveMilestone() {
        Assignment a = createTestData.createAssigment();
        Milestone milestone = new Milestone();
        milestone.setMilestoneName("M1");
        milestone.setTeam("team");
        milestone.setStartDate(new Date());
        milestone.setEndDate(new Date());
        milestone.setCheckerUser("cuser");
        milestone.setTeam("Team");
        milestone.setAssignment(a);
        milestone.setClient(a.getClient());


        Milestone m = milestoneManager.saveMilestone(milestone);
        assertNotNull(m);
     }

    @Test
    void getAllMilestone() {
    }

    @Test
    void getMilestoneById() {
    }

    @Test
    void updateMilestone() {
    }

    @Test
    void deleteMilestone() {
    }
}
