package com.epita.fr.quiz.resources;

import java.util.Map;


public class QuestionForJs {

	
	int id;
	String choice;
	String difficulty;
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	Map<String,String> choicesMap;
	
	public Map<String,String> getChoicesMap() {
		return choicesMap;
	}

	public void setChoicesMap(Map<String,String> choicesMap) {
		this.choicesMap = choicesMap;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}

	String questionLabel;
	
	
	
	

}

