package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserInfo;
import com.example.service.UserInfoServiceImpl;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
	private UserInfoServiceImpl userInfoService;
     
    @PostMapping("/createuser")
    public String saveUserInfo(@RequestBody UserInfo userInfo)
    {
    	userInfoService.saveUserInfo(userInfo);
    	return "Success Inserted...";
    }
}
