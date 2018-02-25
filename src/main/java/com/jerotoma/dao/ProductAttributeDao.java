package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.Product;
import com.jerotoma.model.ProductAttribute;

public interface ProductAttributeDao {
	public ProductAttribute getProductAttribute(int id);
    public List<ProductAttribute> getProductAttributes();
    public ProductAttribute update(ProductAttribute productAttribute);
    public int save(ProductAttribute productAttribute);
    public boolean delete(ProductAttribute productAttribute);
}
