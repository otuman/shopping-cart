package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.Product;
import com.jerotoma.model.Attribute;

public interface AttributeDao {
	public Attribute getProductAttribute(int id);
    public List<Attribute> getProductAttributes();
    public Attribute update(Attribute productAttribute);
    public int save(Attribute productAttribute);
    public boolean delete(Attribute productAttribute);
}
