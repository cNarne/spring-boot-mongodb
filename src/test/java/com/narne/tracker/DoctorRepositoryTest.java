package com.narne.tracker;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.narne.tracker.domain.DoctorVisit;
import com.narne.tracker.repositories.DoctorVisitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DoctorRepositoryTest {
	
	@Autowired DoctorVisitRepository doctorVisitRepository;
	
	@Test
	public void getByPetId() {
		Iterable<DoctorVisit> docVisits = doctorVisitRepository.findByPetId("5a78f0c19302042af0705df2");
		assertNotNull(docVisits);
	}

}
