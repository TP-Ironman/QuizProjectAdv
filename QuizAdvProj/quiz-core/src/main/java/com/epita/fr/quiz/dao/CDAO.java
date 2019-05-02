package com.epita.fr.quiz.dao;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CDAO<T> {
	
	EntityManager entMan;
	
	@Transactional(value=Transactional.TxType.REQUIRED)
	public void create(T ent)
	{
		entMan.persist(ent);		
	}

	
}
