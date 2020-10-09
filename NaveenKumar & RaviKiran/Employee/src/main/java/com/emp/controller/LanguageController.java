package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Language;
import com.emp.response.LanguageResponse;
import com.emp.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {
	@Autowired
	private LanguageService languageService;

	@PostMapping(value="/saveLanguage", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml"})
	public LanguageResponse saveLanguage(@RequestBody Language language){
		return languageService.saveLanguage(language);
	}
}
