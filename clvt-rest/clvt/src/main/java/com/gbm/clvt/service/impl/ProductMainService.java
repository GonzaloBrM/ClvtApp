package com.gbm.clvt.service.impl;

import java.util.List;
import java.util.Optional;

import com.gbm.clvt.model.Product;
import com.gbm.clvt.repository.ProductRepository;
import com.gbm.clvt.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductMainService implements ProductService {

  @Autowired
  ProductRepository repository;

  @Override
  public Product create(Product product) {
    return repository.insert(product);
  }

  @Override
  public void update(Product product) {
    repository.save(product);
  }

  @Override
  public void update(List<Product> products) {
    products.forEach((p) -> {
      update(p);
    });
  }

  @Override
  public void delete(Product product) {
    repository.delete(product);
  }

  @Override
  public void delete(String name) {
    List<Product> found = findByName(name);
    found.forEach((p) -> {
      repository.delete(p);
    });
  }

  @Override
  public List<Product> findAll() {
    return repository.findAll();
  }

  @Override
  public Optional<Product> findById(String id) {
    return repository.findById(id);
  }

  @Override
  public List<Product> findByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
  }

  @Override
  public Product addSizes(String productName, String color, List<String> sizes) {
    List<Product> found = findByName(productName);
    if (found.isEmpty())
      return null;
    Product p = found.get(0);
    p.addSize(color, sizes.stream().toArray(String[]::new));
    update(p);
    return p;
  }

  @Override
  public Product removeSizes(String productName, String color, List<String> sizes) {
    List<Product> found = findByName(productName);
    if (found.isEmpty())
      return null;
    Product p = found.get(0);
    p.removeSize(color, sizes.stream().toArray(String[]::new));
    update(p);
    return p;
  }

  @Override
  public Product addStock(String productName, String color, String size, Integer stock) {

    List<Product> found = findByName(productName);
    if (found.isEmpty())
      return null;
    Product p = found.get(0);
    p.addStock(color, size, stock);

    update(p);
    return p;

  }

}