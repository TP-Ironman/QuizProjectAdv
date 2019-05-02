package com.epita.fr.quiz.datamodel;

import javax.persistence.*;


@Entity
@Table(name="CHOICES")
public class ChoicesProvided {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Q_Id")
	int id;
	
	@ManyToOne
	QuestionsPosed qns;
	
	@Column(name="Choice")
	String choice_opt;
	
	@Column(name="Choice_Val")
	String choice_Val;
	
	public String getChoice_Val() {
		return choice_Val;
	}

	public void setChoice_Val(String choice_Val) {
		this.choice_Val = choice_Val;
	}

	@Column(name="Correct_Opt")
	boolean isCorrect;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChoice_opt() {
		return choice_opt;
	}

	public void setChoice_opt(String choice_opt) {
		this.choice_opt = choice_opt;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	
	
	
	

}
