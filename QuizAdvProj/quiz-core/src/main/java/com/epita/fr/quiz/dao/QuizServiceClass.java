package com.epita.fr.quiz.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epita.fr.quiz.datamodel.AdminDetails;
import com.epita.fr.quiz.datamodel.ChoicesProvided;
import com.epita.fr.quiz.datamodel.QuestionsPosed;
import com.epita.fr.quiz.datamodel.StudentDetails;

public class QuizServiceClass {

	
	@Inject
	StudentRefDAO sdlDao;
	
	@Inject
	AdminRefDAO adDAO;
	
	@Inject
	QuestionsRefDAO qnsRefDAO;
	
	@Inject
	ChoicesRefDAO chsRefDAO;
	
	@PersistenceContext
	EntityManager em;

	private static final Logger LOGGER = LogManager.getLogger(QuizServiceClass.class);

	@Transactional(Transactional.TxType.REQUIRED)
	public void createStudentAcc(StudentDetails sd) {
		LOGGER.info("entering the createQuestionAndChoices method");
		sdlDao.createStudent(sd);	
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteStudentAcc(StudentDetails sd) {
		LOGGER.info("entering the deleteStudentAcc method");
		sdlDao.deleteStudent(sd);	
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public boolean checkValidAdmin(AdminDetails admDet) {
		LOGGER.info("entering the checkValidAdmin method");
		boolean retVal = adDAO.checkAdminAccess(admDet);
		return retVal;
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public List<QuestionsPosed> displayQuestionsChoices() {
		LOGGER.info("entering the displayQuestionsChoices method");
		List<QuestionsPosed> displayQuestionsChoices = adDAO.displayQuestionsChoices();
		return displayQuestionsChoices;
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void addQuestions(QuestionsPosed qnsPsd){
		LOGGER.info("entering the addQuestions method");
		qnsRefDAO.addQuestions(qnsPsd);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void addChoices(QuestionsPosed qnsPsd,ChoicesProvided chPd){
		chPd.setId(qnsPsd.getQnId());
		LOGGER.info("entering the addChoices method");
		chsRefDAO.addChoices(chPd);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteQnsChoices(int qnId){
		LOGGER.info("entering the deleteQnsChoices method");
		qnsRefDAO.deleteQnsChoices(qnId);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void updateQuestions(QuestionsPosed qnsPsd){
		LOGGER.info("entering the updateQuestions method");
		qnsRefDAO.updateQuestions(qnsPsd);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void updateChoices(ChoicesProvided chPd){
		LOGGER.info("entering the updateChoices method");
		chsRefDAO.updateChoices(chPd);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public boolean checkSelOptionIsRight(int qnId, String choiceVal) {
		LOGGER.info("entering the updateChoices method");
		return sdlDao.VerifyAnswer(qnId,choiceVal);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void updateStudentScore(String sid, int score) {
		LOGGER.info("entering the updateChoices method");
		sdlDao.updateScore(sid,score);
	}
	
	
	
	
	
	
	
	
	

}
