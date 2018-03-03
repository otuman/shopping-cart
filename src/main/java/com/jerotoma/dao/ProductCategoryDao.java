package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.ProductCategory;

public interface ProductCategoryDao {
	
	public ProductCategory getProductCategory(int id);
    public List<ProductCategory> getProductCategories();
    public List<ProductCategory> getProductCategories(int product_id);
    public ProductCategory update(ProductCategory productCategory);
    public int save(ProductCategory productCategory);
    public boolean delete(ProductCategory productCategory);

}
