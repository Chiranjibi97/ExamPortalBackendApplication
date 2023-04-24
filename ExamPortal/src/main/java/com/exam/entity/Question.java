package com.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	@GeneratedValue
	private Integer quesId;
	@Column(length=5000)
	private String content;
	
	private String image;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	private String answar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Quiz quiz;
}
