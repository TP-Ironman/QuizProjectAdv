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
import com.epita.fr.quiz.datamodel.StudentDetails;

@Path("/student")
public class StudentResource {

	@Inject
	QuizServiceClass quizServCls;
	
	static int count=0;
	
	@POST
	@Path("/nextQn")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response checkAnswer() throws URISyntaxException {
		int qnId=5;
		String choiceVal="A";
		boolean boolVal=quizServCls.checkSelOptionIsRight(qnId, choiceVal);
		if(boolVal==true)
		{
			count=count+1;
		}
		return Response.created(new URI("student" + "/" + String.valueOf(qnId))).build();
		
	}
	
	@POST
	@Path("/saveQuiz")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response displayScore(StudentDetails sd) throws URISyntaxException {
		//quizServCls.updateStudentScore(sd.getStudentMailId(), count);
		String result = "Your result is "+count+"/20";
		return Response.status(200).entity(result).build();
		
	}

}
