package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;

import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.MilestoneRepository;
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

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MilestoneManagerTest {

    @Autowired
    private MilestoneRepository milestoneRepository;

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
        Milestone m1 = createTestData.createMilestone();
        Milestone m2 = createTestData.createMilestone();
        Milestone m3 = createTestData.createMilestone();

        // Save them to the repository
        milestoneRepository.saveAll(Arrays.asList(m1, m2, m3));

        // Call the getAllMilestone method
        List<Milestone> milestones = milestoneManager.getAllMilestone();

        // Check that the list contains all of the milestones
        assertEquals(3, milestones.size());
        assertTrue(milestones.contains(m1));
        assertTrue(milestones.contains(m2));
        assertTrue(milestones.contains(m3));
    }

    @Test
    void getMilestoneById() {

        // Create a sample milestone
        Milestone m1 = createTestData.createMilestone();

        // Save it to the repository
        Milestone savedMilestone = milestoneRepository.save(m1);

        // Call the getMilestoneById method
        Optional<Milestone> optionalMilestone = milestoneManager.getMilestoneById(savedMilestone.getId());

        // Check that the milestone was found
        assertTrue(optionalMilestone.isPresent());

        // Get the milestone from the Optional
        Milestone retrievedMilestone = optionalMilestone.get();

        // Check that the retrieved milestone is the same as the saved one
        assertEquals(savedMilestone, retrievedMilestone);
    }

    @Test
    void updateMilestone() {
        // Create a sample milestone
        Milestone m1 = createTestData.createMilestone();

        // Save it to the repository
        Milestone savedMilestone = milestoneRepository.save(m1);

        // Update the milestone's name and team
        savedMilestone.setMilestoneName("Updated name");
        savedMilestone.setTeam("Updated team");

        // Call the updateMilestone method with the ID and updated milestone
        Milestone updatedMilestone = milestoneManager.updateMilestone(savedMilestone.getId(), savedMilestone);

        // Check that the updated milestone has the correct values
        assertEquals("Updated name", updatedMilestone.getMilestoneName());
        assertEquals("Updated team", updatedMilestone.getTeam());
    }

    @Test
    void deleteMilestone() {
        // Create a sample milestone
        Milestone m1 = createTestData.createMilestone();

        // Save it to the repository
        Milestone savedMilestone = milestoneRepository.save(m1);

        // Call the deleteMilestone method
        milestoneManager.deleteMilestone(savedMilestone.getId());

        // Check that the milestone was deleted
        assertFalse(milestoneRepository.existsById(savedMilestone.getId()));
}}
