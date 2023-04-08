package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;

import com.anyaudit.payload.request.Milestone;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MilestoneManagerTest {

    @Autowired
    private MilestoneManager milestoneManager;

    @Before
    @After
    public void setup() {

    }

    @Test
    void saveMilestone() {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName("M1");
        milestone.setTeam("team");
        milestone.setStartdate("startDate");
        milestone.setAssignmentname("aname");
        milestone.setCheckeruser("aname");
        milestone.setEnddate("enddate");
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
