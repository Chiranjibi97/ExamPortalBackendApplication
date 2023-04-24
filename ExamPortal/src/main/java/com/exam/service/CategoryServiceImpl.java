package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Category;
import com.exam.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cRepo;
	
	@Override
	public Category addCategory(Category category) {
		return cRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return cRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(cRepo.findAll());
	}

	@Override
	public Category getCategory(Integer id) {
		return cRepo.findById(id).get();
	}

	@Override
	public void deleteCategory(Integer id) {
		cRepo.deleteById(id);

	}

}
