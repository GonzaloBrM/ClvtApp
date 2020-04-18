package com.gbm.clvt.service;

import java.util.List;
import java.util.Optional;

import com.gbm.clvt.model.Product;

public interface ProductService {

  public Product create(Product product);

  public void update(Product product);

  public void delete(Product product);

  public void deleteAll();

  public List<Product> findAll();

  public Optional<Product> findById(String id);

  public List<Product> findByName(String name);

  public Product addSizes(String productName, String color, List<String> sizes);

  public Product addStock(String productName, String color, String size, Integer stock);

  public void update(List<Product> products);

  public void delete(String name);

  public Product removeSizes(String productName, String color, List<String> sizes);
}