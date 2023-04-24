package com.exam.service;

import java.util.Set;

import com.exam.entity.Question;
import com.exam.entity.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestions();
	public Question getQuestion(Integer questionId);
	public Set<Question> getQuistionOfQuiz(Quiz quiz);
	public void deleteQuestion(Integer id);
}
