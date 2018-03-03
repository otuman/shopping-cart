package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.Attribute;

public interface AttributeService {
	public Attribute getProductAttribute(int id);
    public List<Attribute> getProductAttributes();
    public Attribute update(Attribute productAttribute);
    public int save(Attribute productAttribute);
    public boolean delete(Attribute productAttribute);
}
