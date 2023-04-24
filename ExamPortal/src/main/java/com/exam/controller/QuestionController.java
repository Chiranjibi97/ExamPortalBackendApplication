package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> save(@RequestBody Question question){
		return ResponseEntity.ok(service.addQuestion(question));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable Integer id){
		return ResponseEntity.ok(service.getQuestion(id));
	} 

	@GetMapping("/")
	public ResponseEntity<Set<Question>> getQuiz(){
		return ResponseEntity.ok(service.getQuestions());
	}
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(service.updateQuestion(question));
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
	    service.deleteQuestion(id);
	}
	
	@GetMapping("/quiz/{id}")
	public ResponseEntity<List<Question>> getQuestionOfQuiz(@PathVariable("qid") Integer qid){
		/*Quiz quiz = new Quiz();
		quiz.setQid(qid);
		return ResponseEntity.ok(service.getQuistionOfQuiz(quiz));*/
		
		Quiz quiz = quizService.getQuiz(qid);
		Set<Question> set = quiz.getQuestions();
		List<Question> list = new ArrayList<>(set);
		
		if(list.size()>quiz.getNoOfQuestions()) {
			list = list.subList(0,quiz.getNoOfQuestions()-1);
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
}
