package com.epita.fr.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.inject.Inject;
import javax.persistence.*;

@Entity
@Table(name="QUESTIONS")
public class QuestionsPosed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Quest_Id")
	int QnId;
	
	@Column(name="Questions")
	String questions;
	
	@Column(name="Difficulty")
	String difficulty;
	
	@Transient
	String choice;
	
	public int getQnId() {
		return QnId;
	}

	public void setQnId(int qnId) {
		QnId = qnId;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
	
	

}
