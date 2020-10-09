package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Response.Response;
import com.example.exception.CustomException;
import com.example.model.JobPortal;
import com.example.model.UserInfo;
import com.example.repository.JobPortalRepository;

public class TestService {
	@InjectMocks
	private JobPortalServiceImpl jobPortalImple;

	@Mock
	private JobPortalRepository jobRepo;

	@Mock
	Response response;
	@Mock
	private JobPortal job;

	@Autowired
	private MockMvc mockMvc;
	
	   @Spy
	    Pageable pageable;
	   @Spy
		ResponseEntity<Object> success = new ResponseEntity<>(HttpStatus.CONFLICT);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testSave_Ok() throws Exception {
		JobPortal jobPortal = new JobPortal();
		UserInfo userInfo = new UserInfo();
		jobPortal.setId(1);
		jobPortal.setJobTitle("java developer");
		jobPortal.setJobDescription("need to develop the application");
		jobPortal.setCountry("INDIA");
		jobPortal.setState("ts");
		jobPortal.setAvailability("part-time");
		jobPortal.setReplyRate(25);
		jobPortal.setPayRate(20);
		jobPortal.setExperience(7);
		jobPortal.setSkills("java,python");
		jobPortal.setLanguage("english");
		jobPortal.setJobType("testing");
		userInfo.setUsername("ajay");
		jobPortal.setUserInfo(userInfo);
		when(jobRepo.save(jobPortal)).thenReturn(jobPortal);
		ResponseEntity<Object> res = jobPortalImple.saveJob(jobPortal);
		assertEquals(res.getStatusCode(), HttpStatus.OK);

	}

	@Test(expected = CustomException.class)
	public void testSave_Conflict() throws Exception {
		JobPortal jobPortal = new JobPortal();
		UserInfo userInfo = new UserInfo();
		jobPortal.setId(0);
		jobPortal.setJobTitle(null);
		jobPortal.setJobDescription(null);
		jobPortal.setCountry(null);
		jobPortal.setState(null);
		jobPortal.setAvailability(null);
		jobPortal.setReplyRate(0);
		jobPortal.setPayRate(0);
		jobPortal.setExperience(0);
		jobPortal.setSkills(null);
		jobPortal.setLanguage(null);
		jobPortal.setJobType(null);
		userInfo.setUsername(null);
		jobPortal.setUserInfo(userInfo);
		when(jobPortalImple.saveJob(jobPortal)).thenThrow(CustomException.class);

	}
	
	@Test(expected = CustomException.class)
	public void testSave_Conflict1() throws Exception {
		when(jobPortalImple.saveJob(null)).thenThrow(CustomException.class);
	
	}

	@Test(expected = CustomException.class)
	public void testGetById_Conflict() throws Exception {

		when(jobPortalImple.getByJobId(0)).thenThrow(CustomException.class);

	}
	@Test(expected = CustomException.class)
	public void testGetById_Conflic2() throws Exception {

		when(jobPortalImple.getByJobId(null)).thenThrow(CustomException.class);

	}

	@Test(expected = CustomException.class)
	public void testGetById_Conflict1() throws Exception {
		when(jobRepo.findById(1111)).thenReturn(Optional.of(job));
		ResponseEntity<Object> byJobId = jobPortalImple.getByJobId(null);
		when(jobRepo.getById(1)).thenThrow(CustomException.class);

	}

	@Test
	public void testGetById_Ok() throws Exception {
		when(jobRepo.getById(1)).thenReturn(Optional.of(job));
		ResponseEntity<Object> byJobId = jobPortalImple.getByJobId(1);
		assertEquals(byJobId.getStatusCode(), HttpStatus.OK);

	}

	@Test(expected = CustomException.class)
	public void testGetById_Conflict2() throws Exception {

		when(jobPortalImple.getByJobId(null)).thenThrow(CustomException.class);

	}

	@Test(expected = CustomException.class)
	public void testGetByJobType_Conflict() throws Exception {

		when(jobPortalImple.getByJobType(null)).thenThrow(CustomException.class);

	}

	@Test(expected = CustomException.class)
	public void testGetByJobType_Conflict1() throws Exception {

		when(jobRepo.findByJobType("fsfsyyy")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByJobType("null");
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);

	}

	@Test
	public void testGetByJobType_Ok() throws Exception {

		when(jobRepo.findByJobType("Development")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByJobType("Development");
		assertEquals(res.getStatusCode(), HttpStatus.OK);

	}

	@Test(expected = CustomException.class)
	public void testGetByExpereince_Conflict() throws Exception {

		when(jobPortalImple.getByExperience(0)).thenThrow(CustomException.class);

	}

	@Test(expected = CustomException.class)
	public void testGetByExpereince_Conflict1() throws Exception {

		when(jobRepo.getById(101)).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByExperience(101);
		// assertFalse(false);
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);

	}

	@Test
	public void testGetByExpereinc_Ok() throws Exception {

		when(jobRepo.findByExperience(5)).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByExperience(5);
		assertEquals(res.getStatusCode(), HttpStatus.OK);

	}

	@Test(expected = CustomException.class)
	public void testGetByCoutntry_Conflict() throws Exception {

		when(jobPortalImple.getByCountry(null)).thenThrow(CustomException.class);
	}

	@Test(expected = CustomException.class)
	public void testGetByCoutntry_Conflict1() throws Exception {

		when(jobRepo.findByCountry("usa")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByCountry("null");
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);
	}

	@Test
	public void testGetByCoutntry_Ok() throws Exception {

		when(jobRepo.findByCountry("IND")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByCountry("IND");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	@Test(expected = CustomException.class)
	public void testGetByAvalaibility_Conflict() throws Exception {

		when(jobPortalImple.getByAvailability(null)).thenThrow(CustomException.class);
	}

	@Test(expected = CustomException.class)
	public void testGetByAvalaibility_Conflict1() throws Exception {
		when(jobRepo.findByAvailbility("yyyyy")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByAvailability("part-time");
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);

	}

	@Test
	public void testGetByAvalaibility_Ok() throws Exception {
		when(jobRepo.findByAvailbility("part-time")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByAvailability("part-time");
		assertEquals(res.getStatusCode(), HttpStatus.OK);

	}

	@Test(expected = CustomException.class)
	public void testGetByLang_Conflict() throws Exception {

		when(jobPortalImple.getByLanguage(null)).thenThrow(CustomException.class);
	}

	@Test(expected = CustomException.class)
	public void testGetByLang_Conflict1() throws Exception {

		when(jobRepo.findByLanguage("yyyyy")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByLanguage("English");
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);
	}

	@Test
	public void testGetByLang_Ok() throws Exception {

		when(jobRepo.findByLanguage("English")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByLanguage("English");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	@Test(expected = CustomException.class)
	public void testGetBySkill_Conflict() throws Exception {

		when(jobPortalImple.getBySkills(null)).thenThrow(CustomException.class);
	}

	@Test(expected = CustomException.class)
	public void testGetBySkill_Conflict1() throws Exception {

		when(jobRepo.findBySkillsContaining("yyyyy")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getBySkills("java,python");
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);
	}

	@Test
	public void testGetBySkill_Ok() throws Exception {

		when(jobRepo.findBySkillsContaining("java,python")).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getBySkills("java,python");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	@Test(expected = CustomException.class)
	public void testGetByPayrate_Conflict() throws Exception {

		when(jobPortalImple.getByPayRate(0, 0)).thenThrow(CustomException.class);
	}

	@Test(expected = CustomException.class)
	public void testGetByPayrate_Conflict1() throws Exception {

		when(jobRepo.findByPayRate(400, 20)).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByPayRate(10, 20);
		assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);
	}

	@Test
	public void testGetByPayrate_ok() throws Exception {

		when(jobRepo.findByPayRate(10, 20)).thenReturn(Optional.of(job));
		ResponseEntity<Object> res = jobPortalImple.getByPayRate(10, 20);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	@Ignore
	@Test
	public void getAllJobs_Conflict() throws Exception
	{
		//Page<JobPortal> pageEmp = new PageImpl<>(job);
		 when(jobRepo.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn((Page<JobPortal>) pageable);
	        ResponseEntity<Object> allEmployees = jobPortalImple.getAllJobs(0, 1);
	        assertEquals(allEmployees.getStatusCode(), HttpStatus.OK);
	}

}
