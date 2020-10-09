package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Skills;
import com.emp.repository.SkillsRepository;
import com.emp.response.SkillsResponse;

@Service
public class SkillsService implements SkillsServiceInterface {
	@Autowired
	private SkillsRepository skillsRepository;
	SkillsResponse sresponse = new SkillsResponse();

	@Override
	public SkillsResponse saveSkills(Skills skills) {
		Skills save = skillsRepository.save(skills);
		System.out.println(save);
		if (skills == null || save == null|| skills.getSkillsId()!=null) {
			sresponse.setMessage("please provide the required data");
			sresponse.setStatusCode("404");
			sresponse.setSkillsList(null);
		} else {

			sresponse.setMessage("data saved successfully");
			sresponse.setStatusCode("200");
			sresponse.setSkillsList(save);
			return sresponse;
		}
		return sresponse;
	}

}
