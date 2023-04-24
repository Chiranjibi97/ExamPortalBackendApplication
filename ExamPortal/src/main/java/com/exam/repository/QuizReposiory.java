package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Quiz;

public interface QuizReposiory extends JpaRepository<Quiz, Integer> {

}
