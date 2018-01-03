package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.Product;

public interface ProductService {
     public Product getProduct(int id);
     public List<Product> getProducts();
     public Product update(Product product);
     public int save(Product product);
     public boolean delete(Product product);
     
}
