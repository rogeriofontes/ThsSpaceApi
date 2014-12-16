package eu.kielczewski.example.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.kielczewski.example.domain.Project;
import eu.kielczewski.example.service.BusinessService;
import eu.kielczewski.example.service.exception.AlreadyExistsException;

@RestController
public class ProjectController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProjectController.class);

	@Inject
	private BusinessService<Project> businessService;

	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public Project createProject(@RequestBody @Valid final Project project) {
		LOGGER.debug("Received request to create the {}", project);
		return businessService.save(project);
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public List<Project> listProjects() {
		LOGGER.debug("Received request to list all projects");
		return businessService.getList();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleProjectAlreadyExistsException(AlreadyExistsException e) {
		return e.getMessage();
	}

}