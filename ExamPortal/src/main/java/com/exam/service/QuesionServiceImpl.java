package com.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.repository.QuestionRepository;

@Service
public class QuesionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository repo;
	
	@Override
	public Question addQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(repo.findAll());
	}

	@Override
	public Question getQuestion(Integer questionId) {
		return repo.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuistionOfQuiz(Quiz quiz) {
		return repo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Integer id) {
		repo.deleteById(id);		
	}

}
