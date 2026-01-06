package org.airtribe.LearnerManagementSystemBelC14.service;

import org.airtribe.LearnerManagementSystemBelC14.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC14.exceptions.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC14.repository.LearnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LearnerManagementServiceTest {

    @InjectMocks
    private LearnerManagementService _learnerManagementService;

    @Mock
    private LearnerRepository _learnerRepository;

    private static Learner learner;

    @BeforeAll
    public static void BeforeAll() {
        learner = new Learner(1L, "guf", "guf", null);
        System.out.println("This is before All statement!!!");
    }

    @BeforeEach
    public void BeforeEach() {
        System.out.println("This is before each statement!!!");
    }

    //Arrange Act Assert pattern
    @Test
    public void testLearnerCreatedSuccessfully() {
        when(_learnerRepository.save(learner)).thenReturn(learner);
        Learner outputLearner = _learnerManagementService.createLearner(learner);
        assertEquals(learner, outputLearner);
        assertEquals("guf", outputLearner.getLearnerName());
        assertEquals("guf", outputLearner.getLearnerEmail());

        //verifying call interactions
        verify(_learnerRepository, times(1)).save(learner);
    }

    @Test
    public void testFetchLearnerById() throws LearnerNotFoundException {
        when(_learnerRepository.findById(1L)).thenReturn(Optional.of(learner));
        Learner outputLearner = _learnerManagementService.fetchLearnerById(1L);
        assertEquals(learner, outputLearner);
        assertEquals("guf", outputLearner.getLearnerName());
        assertEquals("guf", outputLearner.getLearnerEmail());

        //verifying call interactions
        verify(_learnerRepository, times(2)).findById(1L);
    }

    @Test
    public void testFetchLearnerById_learnerNotFoundException() {
        when(_learnerRepository.findById(1L)).thenReturn(Optional.empty());
        LearnerNotFoundException exception = Assertions.assertThrows(LearnerNotFoundException.class, () -> _learnerManagementService.fetchLearnerById(1L));
        assertEquals("Learner with Id 1 not found!!", exception.getMessage());
    }
}
