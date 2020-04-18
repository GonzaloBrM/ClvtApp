package com.gbm.clvt.controller;

import java.util.List;

import com.gbm.clvt.controller.request.AddSizesRequest;
import com.gbm.clvt.controller.request.AddStockRequest;
import com.gbm.clvt.controller.request.UpdateRequest;
import com.gbm.clvt.model.Product;
import com.gbm.clvt.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("product")
public class ProductController {

  @Autowired
  private ProductService service;

  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/getByName/{name}")
  public List<Product> getByName(@PathVariable String name) {
    return service.findByName(name);
  }

  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/getAll")
  public List<Product> getAll() {
    return service.findAll();
  }

  @PostMapping("/remove")
  public void remove(@RequestBody Product request) {
    String name = request.getName();
    service.delete(name);
  }

  @PostMapping("/removeSizes")
  public Product removeSizes(@RequestBody AddSizesRequest request) {

    String productName = request.getProductName();
    String color = request.getColor();
    List<String> sizes = request.getSizes();

    return service.removeSizes(productName, color, sizes);
  }

  @PostMapping("/add")
  Product add(@RequestBody Product request) {
    return service.create(request);
  }

  @PostMapping("/addSizes")
  public Product addSizes(@RequestBody AddSizesRequest request) {

    String productName = request.getProductName();
    String color = request.getColor();
    List<String> sizes = request.getSizes();

    return service.addSizes(productName, color, sizes);
  }

  @PostMapping("/addStock")
  public Product addStock(@RequestBody AddStockRequest request) {
    String productName = request.getProductName();
    String color = request.getColor();
    String size = request.getSize();
    Integer stock = request.getStock();
    return service.addStock(productName, color, size, stock);
  }

  @PostMapping("/changeName")
  public void changeName(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setName(request.getName());
    });
    service.update(products);

  }

  @PostMapping("/changeSubname")
  public void changeSubname(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setSubName(request.getSubName());
    });
    service.update(products);
  }

  @PostMapping("/changeDescription")
  public void changeDescription(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setDescription(request.getDescription());
    });
    service.update(products);

  }

  @PostMapping("/changeImages")
  public void changeImages(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setImages(request.getImages());
      p.setMainImage(request.getMainImage());
    });
    service.update(products);

  }

  @PostMapping("/changePrice")
  public void changePrice(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setPrice(request.getPrice());
    });
    service.update(products);

  }

  @PostMapping("/changeDiscount")
  public void changeDiscount(@RequestBody UpdateRequest request) {

    List<Product> products = service.findByName(request.getName());
    products.forEach((p) -> {
      p.setDiscount(request.getDiscount());
    });
    service.update(products);

  }

}