package com.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Quiz;
import com.exam.repository.QuizReposiory;

@Service
public class QuizServiceImpl implements QuizService {

	
	@Autowired
	private QuizReposiory qRepo;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return qRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return qRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzs() {
		return new HashSet<>(qRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Integer id) {
		return qRepo.findById(id).get();
	}

	@Override
	public void deleteQuiz(Integer id) {
		qRepo.deleteById(id);

	}

}
