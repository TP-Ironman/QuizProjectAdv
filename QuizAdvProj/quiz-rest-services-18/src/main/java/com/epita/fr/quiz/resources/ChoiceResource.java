package com.epita.fr.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epita.fr.quiz.dao.QuizServiceClass;
import com.epita.fr.quiz.datamodel.ChoicesProvided;
import com.epita.fr.quiz.datamodel.QuestionsPosed;

@Path("/choices")
public class ChoiceResource {
	
	@Inject
	QuizServiceClass quizServCls;
	
	@POST
	@Path("/updateChoices")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateChoices(ChoiceForJs chsPd) throws URISyntaxException {
		ChoicesProvided chPd = new ChoicesProvided();
		chPd.setId(chsPd.getQid());
		chPd.setChoice_opt(chsPd.getChOpid());
		chPd.setChoice_Val(chsPd.getChoice());
		chPd.setCorrect(chsPd.getIsCorrect());
		quizServCls.updateChoices(chPd);
		return Response.created(new URI("choices" + "/" + String.valueOf(chPd.getId()))).build();
		
	}

}
