package com.gbm.clvt.service.impl;

import java.util.List;

import com.gbm.clvt.model.InitialConfiguration;
import com.gbm.clvt.repository.ConfigurationRepository;
import com.gbm.clvt.service.ConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("configurationService")
public class ConfigurationMainService implements ConfigurationService {

  @Autowired
  private ConfigurationRepository repository;

  @Override
  public void update(InitialConfiguration configuration) {
    deleteAll();
    repository.insert(configuration);
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
    ;
  }

  @Override
  public InitialConfiguration find() {
    InitialConfiguration output = null;
    List<InitialConfiguration> found = repository.findAll();
    boolean foundSomething = found != null && !found.isEmpty();
    if (foundSomething)
      output = found.get(0);
    return output;
  }
}