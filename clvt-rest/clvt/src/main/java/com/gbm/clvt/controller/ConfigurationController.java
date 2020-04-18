package com.gbm.clvt.controller;

import com.gbm.clvt.model.InitialConfiguration;
import com.gbm.clvt.service.ConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("configuration")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })

public class ConfigurationController {

  @Autowired
  private ConfigurationService service;

  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/get")
  public InitialConfiguration get() {
    return service.find();
  }

  @PostMapping("/update")
  public void remove(@RequestBody InitialConfiguration request) {
    service.deleteAll();
    service.update(request);
  }
}