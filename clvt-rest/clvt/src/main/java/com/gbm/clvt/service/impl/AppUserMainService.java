package com.gbm.clvt.service.impl;

import com.gbm.clvt.model.AppUser;
import com.gbm.clvt.repository.UserRepository;
import com.gbm.clvt.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("appUserService")
public class AppUserMainService implements AppUserService {

  @Autowired
  UserRepository repository;

  @Override
  public AppUser register(AppUser user) {
    return repository.save(user);

  }

  @Override
  public Boolean login(AppUser user) {
    return repository.existsByName(user.getName());
  }
}