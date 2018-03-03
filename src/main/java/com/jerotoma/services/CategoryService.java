package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.Category;

public interface CategoryService {
	public Category getProductCategory(int id);
    public Category update(Category productCategory);
    public int save(Category productCategory);
    public boolean delete(Category productCategory);
	public List<Category> getProductCategories();
}
