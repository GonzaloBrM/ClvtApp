package com.gbm.clvt.service;

import com.gbm.clvt.model.InitialConfiguration;

public interface ConfigurationService {

  public void update(InitialConfiguration configuration);

  public void deleteAll();

  public InitialConfiguration find();
}