package com.exam.service;

import java.util.Set;

import com.exam.entity.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzs();
	public Quiz getQuiz(Integer id);
	public void deleteQuiz(Integer id);
}
