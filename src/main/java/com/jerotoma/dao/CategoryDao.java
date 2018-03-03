package com.jerotoma.dao;

import java.util.List;

import com.jerotoma.model.Category;

public interface CategoryDao {
	public Category getProductCategory(int id);
    public Category update(Category productCategory);
    public int save(Category productCategory);
    public boolean delete(Category productCategory);
	public List<Category> getProductCategories();
}
