package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qid;
	
	private String title;
	
	private String description;
	
	private Double maxMarks;
	
	private String noOfQuestions;
	
	private boolean active;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Category category;
	
	@OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
}
