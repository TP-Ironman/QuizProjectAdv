package com.epita.fr.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epita.fr.quiz.dao.QuizServiceClass;
import com.epita.fr.quiz.datamodel.ChoicesProvided;
import com.epita.fr.quiz.datamodel.QuestionsPosed;





@Path("/questions")
public class QuestionResource {
	
	@Inject
	QuizServiceClass quizServCls;
	private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);

	@GET
	@Path("/questions")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response convertCtoF() {
 
		List<QuestionForJs> list = new ArrayList<QuestionForJs>() ;
		QuestionForJs qnsPd = new QuestionForJs();
		qnsPd.setId(55);
		qnsPd.setQuestionLabel("huhu");
		qnsPd.setChoice("dsjks");
		list.add(qnsPd);
		LOGGER.fatal("jkjkcdfdsadjj");
		return Response.ok(list).build();
	
	}
	
	@POST
	@Path("/addQns")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response saveQuestionChoices(QuestionForJs qnPsd) throws URISyntaxException {
		QuestionsPosed qnsPd = new QuestionsPosed();
		qnsPd.setQuestions(qnPsd.getQuestionLabel());
		qnsPd.setQnId(qnPsd.getId());
		qnsPd.setDifficulty(qnPsd.getDifficulty());
		ChoicesProvided chPd = new ChoicesProvided();
		chPd.setChoicesMap(qnPsd.getChoicesMap());
		LOGGER.fatal("assiwsdou");
		quizServCls.addQuestions(qnsPd);
		quizServCls.addChoices(qnsPd,chPd);
		LOGGER.fatal("sdgfssddgf");
		List<QuestionsPosed> list = new ArrayList<QuestionsPosed>() ;
		list.add(qnsPd);
		
		return Response.ok(list).build();
		
	}
	
	@GET
	@Path("/displayAll")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response displayAllQuestions(){
		List<QuestionsPosed> list = quizServCls.displayQuestionsChoices();
		return Response.ok(list).build();
	}
	
	@POST
	@Path("/updateQns")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateQuestion(QuestionForJs qnPsd) throws URISyntaxException {
		QuestionsPosed qnsPd = new QuestionsPosed();
		qnsPd.setQnId(qnPsd.getId());
		qnsPd.setQuestions(qnPsd.getQuestionLabel());
		qnsPd.setDifficulty(qnPsd.getDifficulty());
		quizServCls.updateQuestions(qnsPd);
		return Response.created(new URI("questions" + "/" + String.valueOf(qnsPd.getQnId()))).build();
		
	}
	
	@POST
	@Path("/deleteQns")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteQuestions(QuestionForJs qnPsd) throws URISyntaxException {
		quizServCls.deleteQnsChoices(qnPsd.getId());
		return Response.created(new URI("questions" + "/" + String.valueOf(qnPsd.getId()))).build();
		
	}
	
	

}
