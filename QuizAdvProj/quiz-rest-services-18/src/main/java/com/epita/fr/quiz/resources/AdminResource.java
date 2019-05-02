package com.epita.fr.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epita.fr.quiz.dao.QuizServiceClass;
import com.epita.fr.quiz.datamodel.AdminDetails;

@Path("/admin")
public class AdminResource {

	@Inject
	QuizServiceClass quizServCls;
	private static final Logger LOGGER = LogManager.getLogger(AdminResource.class);
	@POST
	@Path("/login")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public boolean validateAdmin(AdminForJs adm) throws URISyntaxException {
		AdminDetails admDet = new AdminDetails();
		admDet.setUserId(adm.getId());
		admDet.setPassword(adm.getPaswd());
		LOGGER.fatal("Entering");
		boolean value = quizServCls.checkValidAdmin(admDet);
		LOGGER.fatal("Value"+value);
		return value;

	}

}
