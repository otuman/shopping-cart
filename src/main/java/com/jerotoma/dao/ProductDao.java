package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.Product;

public interface ProductDao {
	public Product getProduct(int id);
    public List<Product> getProducts();
    public Product update(Product product);
    public int save(Product product);
    public boolean delete(Product product);
}
