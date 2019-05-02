package com.epita.fr.quiz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epita.fr.quiz.datamodel.AdminDetails;
import com.epita.fr.quiz.datamodel.QuestionsPosed;

@Repository
public class AdminRefDAO {
	
	@Inject
	QuestionsPosed qnsPsd;
	
	@PersistenceContext
	EntityManager em;

	@Transactional(Transactional.TxType.REQUIRED)
	public boolean checkAdminAccess(AdminDetails admDets) {
		boolean retVal = false;
		TypedQuery<AdminDetails> createQuery = em.createQuery("from ADMIN where U_ID=:username and U_PWD=:password", AdminDetails.class);
		createQuery.setParameter("username", admDets.getUserId());
		createQuery.setParameter("password", admDets.getPassword());
		List<AdminDetails> resultList = createQuery.getResultList();
		if(resultList!=null && resultList.size()>0)
			retVal=true;
		return retVal;	
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public List<QuestionsPosed> displayQuestionsChoices() {
		Query createNativeQuery = em.createNativeQuery("SELECT Quest_Id, Questions, Choice FROM QUESTIONS, CHOICES WHERE Quest_Id=Q_Id AND Correct_Opt='Y'");
		List<QuestionsPosed> qnsChoiceList = new ArrayList<QuestionsPosed>();
		for(int i=0; i <createNativeQuery.getResultList().size();i++)
		{
			qnsPsd.setQnId((Integer) createNativeQuery.getParameterValue("Quest_Id"));
			qnsPsd.setQuestions( (String) createNativeQuery.getParameterValue("Questions"));
			qnsPsd.setChoice( (String) createNativeQuery.getParameterValue("Choice"));
			qnsChoiceList.add(qnsPsd);
		}
		
		return 	qnsChoiceList;
	}
	
	
}
