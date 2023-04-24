package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.entity.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Integer id);
	public void deleteCategory(Integer id);
}
