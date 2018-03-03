package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.ProductAttribute;

public interface ProductAttributeService {
	public ProductAttribute getProductCategory(int id);
    public List<ProductAttribute> getProductCategories();
    public List<ProductAttribute> getProductCategories(int product_id);
    public ProductAttribute update(ProductAttribute productAttribute);
    public int save(ProductAttribute productAttribute);
    public boolean delete(ProductAttribute productAttribute);
}
