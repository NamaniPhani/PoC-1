package com.example.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.component.ExcelWriter;
import com.example.model.JobPortal;
import com.example.repository.JobPortalRepository;

@Service
public class ExcelService {
  @Autowired
  JobPortalRepository repository;

  public ByteArrayInputStream load() {
    List<JobPortal> tutorials = repository.findAll();

    ByteArrayInputStream in = ExcelWriter.tutorialsToExcel(tutorials);
    return in;
  }

}