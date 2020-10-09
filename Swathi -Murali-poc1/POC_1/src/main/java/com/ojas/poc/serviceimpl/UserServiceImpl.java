package com.ojas.poc.serviceimpl;

import static com.ojas.poc.constants.Constants.INVALID_FIELDS;
import static com.ojas.poc.constants.Constants.INVALID_REQUEST;
import static com.ojas.poc.constants.Constants.SUCCESS;
import static com.ojas.poc.constants.Constants.SUCCESS_STATUS;
import static com.ojas.poc.constants.Constants.USER_EXIT;
import static com.ojas.poc.constants.Constants.USER_SAVE;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojas.poc.exception.CustomException;
import com.ojas.poc.exception.Response;
import com.ojas.poc.model.User;
import com.ojas.poc.repositories.UserRepository;
import com.ojas.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveUser(User user) throws CustomException {
		log.debug("Incoming request user service : " + user);

		if (user == null) {
			log.error("Invalid request");
			return new ResponseEntity<>(new CustomException(INVALID_REQUEST), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			log.error("Fields should not be null"); 
			return new ResponseEntity<>(new CustomException(INVALID_FIELDS), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		User findByUserName = userRepo.findByUsername(user.getUsername());
		if (findByUserName != null) {
			return new ResponseEntity<>( new CustomException(USER_EXIT), HttpStatus.CONFLICT);
		}

		String encrpassword = pwdEncoder.encode(user.getPassword());
		user.setPassword(encrpassword);
		User save = userRepo.save(user);
		Response response = new Response();
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(USER_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
