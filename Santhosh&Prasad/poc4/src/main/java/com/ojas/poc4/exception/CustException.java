package com.ojas.poc4.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ojas.poc4.service.JobServiceImpl;

public class CustException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(JobServiceImpl.class);
	public CustException(String message) {		
		super(message);
		log.info(message);
	}

}
