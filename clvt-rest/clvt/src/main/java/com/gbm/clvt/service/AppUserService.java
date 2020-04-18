package com.gbm.clvt.service;

import com.gbm.clvt.model.AppUser;

public interface AppUserService {

  public AppUser register(AppUser user);

  public Boolean login(AppUser user);

}