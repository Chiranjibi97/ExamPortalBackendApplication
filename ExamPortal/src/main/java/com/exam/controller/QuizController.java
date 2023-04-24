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

import com.exam.entity.Quiz;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService service;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(service.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(service.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<Set<Quiz>> getAllQuiz(){
		return ResponseEntity.ok(service.getQuizzs());
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable Integer id){
		return ResponseEntity.ok(service.getQuiz(id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable Integer id) {
		service.deleteQuiz(id);
	}
}
