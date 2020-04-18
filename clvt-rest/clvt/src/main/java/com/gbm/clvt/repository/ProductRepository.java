package com.gbm.clvt.repository;

import java.util.List;

import com.gbm.clvt.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

  public List<Product> findByName(String name);

  public void deleteByName(String name);
}