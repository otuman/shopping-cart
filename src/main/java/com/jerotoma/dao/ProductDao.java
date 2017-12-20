package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.products.Product;

public interface ProductDao {
	public Product getProduct(int id);
    public List<Product> getProducts();
    public Product update(Product product);
    public boolean save(Product product);
    public boolean delete(Product product);
}
