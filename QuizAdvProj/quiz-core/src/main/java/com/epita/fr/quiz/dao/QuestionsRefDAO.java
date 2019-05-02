package com.epita.fr.quiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.epita.fr.quiz.datamodel.QuestionsPosed;

@Repository
public class QuestionsRefDAO {
	
	@PersistenceContext
	EntityManager em;

	private static final Logger LOGGER = LogManager.getLogger(QuestionsRefDAO.class);
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void addQuestions(QuestionsPosed qnsPsd) {
		// TODO Auto-generated method stub
		LOGGER.info("entering the addQuestions method");
		em.persist(qnsPsd);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteQnsChoices(int qnId) {
		// TODO Auto-generated method stub
		Query createQuery = em.createQuery("from QUESTIONS, CHOICES WHERE Quest_Id=Q_Id AND Quest_Id=:id");
		createQuery.setParameter("id", qnId);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateQuestions(QuestionsPosed qnsPsd) {
		// TODO Auto-generated method stub
		LOGGER.info("entering the updateQuestions method");
		em.merge(qnsPsd);
	}

	
}
