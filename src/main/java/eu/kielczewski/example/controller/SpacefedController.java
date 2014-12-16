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

import eu.kielczewski.example.domain.Spacefed;
import eu.kielczewski.example.service.BusinessService;
import eu.kielczewski.example.service.exception.AlreadyExistsException;

@RestController
public class SpacefedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpacefedController.class);
    
    @Inject
    private BusinessService<Spacefed> businessService;

    @RequestMapping(value = "/spacefed", method = RequestMethod.POST)
    public Spacefed createSpacefed(@RequestBody @Valid final Spacefed spacefed) {
        LOGGER.debug("Received request to create the {}", spacefed);
        return businessService.save(spacefed);
    }

    @RequestMapping(value = "/spacefed", method = RequestMethod.GET)
    public List<Spacefed> listSpacefeds() {
		LOGGER.debug("Received request to list all spacefeds");
        return businessService.getList();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleSpacefedAlreadyExistsException(AlreadyExistsException e) {
        return e.getMessage();
    }

}