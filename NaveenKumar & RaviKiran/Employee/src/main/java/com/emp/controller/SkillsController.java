package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Skills;
import com.emp.response.SkillsResponse;
import com.emp.service.SkillsService;

@RestController
@RequestMapping("/skills")
public class SkillsController {
@Autowired
	private SkillsService skillsService;
	@PostMapping(value="/saveSkills", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public  SkillsResponse saveSkills(@RequestBody Skills skills){
		return skillsService.saveSkills(skills);
	}
	
}
