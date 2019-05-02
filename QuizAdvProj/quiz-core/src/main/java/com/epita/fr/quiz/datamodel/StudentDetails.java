package com.epita.fr.quiz.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTDETAILS")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "S_NAME")
	String studentName;

	@Column(name = "S_ID")
	String studentMailId;

	@Column(name = "S_SCORE")
	String studentScore;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMailId() {
		return studentMailId;
	}

	public void setStudentMailId(String studentMailId) {
		this.studentMailId = studentMailId;
	}

	public String getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(String studentScore) {
		this.studentScore = studentScore;
	}

}
