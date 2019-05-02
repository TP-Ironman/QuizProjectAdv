package com.epita.fr.quiz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epita.fr.quiz.datamodel.ChoicesProvided;
import com.epita.fr.quiz.datamodel.QuestionsPosed;
import com.epita.fr.quiz.datamodel.StudentDetails;

@Repository
public class StudentRefDAO {
		
	@PersistenceContext
	EntityManager em;
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void createStudent(StudentDetails stdls)
	{
		List<StudentDetails> searchResult = searchStudent(stdls);
		if(!(searchResult.size()>1))
			em.persist(stdls);
		else
			updateStudent(stdls);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteStudent(StudentDetails stdls)
	{
		em.remove(stdls);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void updateStudent(StudentDetails stdls)
	{
		em.merge(stdls);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public List<StudentDetails> searchStudent(StudentDetails stdls)
	{
		TypedQuery<StudentDetails> queryString = em.createQuery("from STUDENTDETAILS WHERE S_ID=: emailId", StudentDetails.class);
		queryString.setParameter("emailId", stdls.getStudentMailId());
		List<StudentDetails> resultList = queryString.getResultList();
		if(resultList==null || resultList.isEmpty())
		{
			resultList = new ArrayList<StudentDetails>();
		}
		return resultList;
	}

	public boolean VerifyAnswer(int qnId, String choiceVal) {
		// TODO Auto-generated method stub
		boolean isValidAnswer=false;
		TypedQuery<ChoicesProvided> queryString = em.createQuery("from CHOICES WHERE Quest_Id=:qId AND Choice_Val=:optionValue and Correct_Opt=:val",ChoicesProvided.class);
		queryString.setParameter("qId", qnId);
		queryString.setParameter("optionValue", choiceVal);
		queryString.setParameter("val", "Y");
		if(queryString.getResultList().size()>0)
		{
			isValidAnswer=true;
		}
		
		return 	isValidAnswer;
	}

	public void updateScore(String sid,int score) {
		// TODO Auto-generated method stub
		Query createQuery = em.createQuery("UPDATE STUDENTDETAILS SET S_SCORE=:score WHERE S_ID=:sid" );
		createQuery.setParameter("score", score);
		createQuery.setParameter("sid", sid);
		createQuery.executeUpdate();
	}

}
