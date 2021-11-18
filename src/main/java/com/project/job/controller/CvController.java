package com.project.job.controller;


import com.project.job.DTO.CvDTO;
import com.project.job.DTO.Exception.ApiRequestException;
import com.project.job.DTO.ResponseDTO;

import com.project.job.model.Cv;
import com.project.job.service.CvService;

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
public class CvController {

    @Autowired
    private Response response;

    @Autowired
    private CvService cvService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CvController.class);

   @GetMapping(value = "/cv/{idCv}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> FindCvById(@PathVariable Long idCv) {
        LOGGER.info("Request to return a given CV by Id : {}", idCv);
        Cv cv = cvService.findById(idCv);
        if (cv == null) {
            throw new ApiRequestException("This Request Is Invalid!",
                    "Gite with the given id does not exist");
        }
        return response.successResponse("CV {}" +
                "" +
                "returned successfully", cv.convertModelDTO());
    }

    @RequestMapping(value = "/cvs", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllCVs() {

        return response.successResponse("GET OK !!",cvService.findAllCv());
    }

    @PostMapping(value = "/cv", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createCV(@Valid @RequestBody CvDTO cv) {

        cvService.createCV(cv);
        return response.successResponse("CV created !!", true);
    }

    @PutMapping(value = "/cv/{idCv}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateCV(@PathVariable Long idCv, @Valid @RequestBody CvDTO cv) {

        cvService.updateCV(idCv, cv);
        return response.successResponse("CV created !!", true);
    }
}
