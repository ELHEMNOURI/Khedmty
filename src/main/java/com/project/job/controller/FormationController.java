package com.project.job.controller;

import com.project.job.DTO.Exception.ApiRequestException;
import com.project.job.DTO.FormationDTO;
import com.project.job.DTO.ResponseDTO;
import com.project.job.service.FormationService;
import com.project.job.service.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.job.model.Formation;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class FormationController {
    @Autowired
    private Response response;

    @Autowired
    private FormationService formationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(FormationController.class);

    @GetMapping(value = "/formation/{idF}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> FindFormationById(@PathVariable Long idF) {
        LOGGER.info("Request to return a given formation by Id : {}", idF);
        Formation formation = formationService.findById(idF);
        if (formation == null) {
            throw new ApiRequestException("This Request Is Invalid!",
                    "Gite with the given id does not exist");
        }
        return response.successResponse("Formation {}" +
                "" +
                "returned successfully", formation.convertModelDTO());
    }
    @PostMapping(value = "/formation", produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createFormation(@Valid @RequestBody FormationDTO formation) {

        formationService.createFormation(formation);
        return response.successResponse("Formation creee", true);
    }
    @RequestMapping(value = "/formations", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllFormations() {

        return response.successResponse("GET OK !!",formationService.findAllFormations());
    }
    @PutMapping(value = "/formation/{idF}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateFormation(@PathVariable Long idF, @Valid @RequestBody FormationDTO formation) {

        formationService.updateFormation(idF, formation);
        return response.successResponse("Formation modifieee !!", true);
    }

}

