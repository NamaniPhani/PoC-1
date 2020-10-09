package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserInfo;
import com.example.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	 @Autowired
     private UserInfoRepository userInfoRepository;
	 
	 public String saveUserInfo(UserInfo userInfo) {
		userInfoRepository.save(userInfo);
		return "Success";
		
	}

}
