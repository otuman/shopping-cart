package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.ProductAttribute;

public interface ProductAttributeService {
	public ProductAttribute getProductAttribute(int id);
    public List<ProductAttribute> getProductAttributes();
    public ProductAttribute update(ProductAttribute productAttribute);
    public int save(ProductAttribute productAttribute);
    public boolean delete(ProductAttribute productAttribute);
}
