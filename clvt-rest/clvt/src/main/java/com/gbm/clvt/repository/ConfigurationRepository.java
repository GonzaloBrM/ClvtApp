package com.gbm.clvt.repository;

import com.gbm.clvt.model.InitialConfiguration;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigurationRepository extends MongoRepository<InitialConfiguration, String> {

}