package com.epita.fr.quiz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.epita.fr.quiz.datamodel.ChoicesProvided;

@Repository
public class ChoicesRefDAO {

	@PersistenceContext
	EntityManager em;
	
	private static final Logger LOGGER = LogManager.getLogger(ChoicesRefDAO.class);
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void addChoices(ChoicesProvided chPd) {
		// TODO Auto-generated method stub
		LOGGER.info("entering the addChoices method");
		em.persist(chPd);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateChoices(ChoicesProvided chPd) {
		// TODO Auto-generated method stub
		LOGGER.info("entering the updateChoices method");
		em.merge(chPd);
	}

}
