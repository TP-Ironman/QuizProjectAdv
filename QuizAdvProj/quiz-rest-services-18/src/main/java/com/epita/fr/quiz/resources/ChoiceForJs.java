package com.epita.fr.quiz.resources;

public class ChoiceForJs {
	
	String choice;
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getChOpid() {
		return chOpid;
	}
	public void setChOpid(String chOpid) {
		this.chOpid = chOpid;
	}
	public String getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(String isCorrect) {
		this.isCorrect = isCorrect;
	}
	int qid;
	String chOpid;
	String isCorrect;

}
