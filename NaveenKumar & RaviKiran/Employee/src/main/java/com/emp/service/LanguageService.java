package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Language;
import com.emp.repository.LanguageRepository;
import com.emp.response.LanguageResponse;

@Service
public class LanguageService implements LanguageInterface {
	@Autowired
	private LanguageRepository languageRepository;
	LanguageResponse lresponse = new LanguageResponse();

	@Override
	public LanguageResponse saveLanguage(Language language) {
		Language save = languageRepository.save(language);
		if (language == null || save == null) {
			lresponse.setMessage("please provide the data");
			lresponse.setStatusCode("404");
			lresponse.setLanguageList(null);
			return lresponse;
		} else
			lresponse.setMessage("data saved successfully");
		lresponse.setStatusCode("200");
		lresponse.setLanguageList(save);
		return lresponse;
	}

}
