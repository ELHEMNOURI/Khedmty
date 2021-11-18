package com.project.job.controller;

import com.project.job.DTO.Exception.ApiRequestException;
import com.project.job.DTO.ExprerienceDTO;
import com.project.job.DTO.ResponseDTO;
import com.project.job.model.Exprerience;
import com.project.job.service.ExperienceService;
import com.project.job.service.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private Response response;

    @Autowired
    private ExperienceService experienceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiplomeController.class);

    @GetMapping(value = "/experience/{idExperience}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> FindExperienceById(@PathVariable Long idExperience) {
        LOGGER.info("Request to return a given experience by Id : {}", idExperience);
        Exprerience exprerience = experienceService.findById(idExperience);
        if (exprerience == null) {
            throw new ApiRequestException("This Request Is Invalid!",
                    "Gite with the given id does not exist");
        }
        return response.successResponse("Diplome {}" +
                "" +
                "returned successfully", exprerience.convertModelDTO());
    }

    @RequestMapping(value = "/experinces", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllExperiences() {

        return response.successResponse("GET OK !!",experienceService.findAllExpreriences());
    }

    @PostMapping(value = "/experience", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createExperience(@Valid @RequestBody ExprerienceDTO exprerience) {

        experienceService.createExperience(exprerience);
        return response.successResponse("Experience created !!", true);
    }

    @PutMapping(value = "/experience/{idExperience}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateExperience(@PathVariable Long idExperience, @Valid @RequestBody ExprerienceDTO exprerience) {

        experienceService.updateExprerience(idExperience, exprerience);
        return response.successResponse("Experience created !!", true);
    }
}
