package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	//add category
	@Autowired
	private CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return ResponseEntity.ok(service.addCategory(category));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
		return ResponseEntity.ok(service.getCategory(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<Set<Category>> getAllCategory(){
		return ResponseEntity.ok(service.getCategories());
	}
	
	@PutMapping("/")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		return ResponseEntity.ok(service.updateCategory(category));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		service.deleteCategory(id);
	}
}
