package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.products.Product;

public interface ProductService {
     public Product getProduct(int id);
     public List<Product> getProducts();
     public Product update(Product product);
     public boolean save(Product product);
     public boolean delete(Product product);
     
}
