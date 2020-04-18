package com.gbm.clvt.repository;

import com.gbm.clvt.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<AppUser, String> {

  public AppUser findByName(String name);

  public boolean existsByName(String name);
}