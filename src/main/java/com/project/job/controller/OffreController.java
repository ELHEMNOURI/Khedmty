package com.project.job.controller;

import com.project.job.DTO.Exception.ApiRequestException;
import com.project.job.DTO.OffreDTO;
import com.project.job.DTO.ResponseDTO;
import com.project.job.model.Offre;
import com.project.job.service.OffreService;
import com.project.job.service.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OffreController {

    @Autowired
    private Response response;

    @Autowired
    private OffreService offreService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OffreController.class);

    @GetMapping(value = "/offre/{idOffre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> FindOffreById(@PathVariable Long idOffre) {
        LOGGER.info("Request to return a given offre by Id : {}", idOffre);
        Offre offre = offreService.findById(idOffre);
        if (offre == null) {
            throw new ApiRequestException("This Request Is Invalid!",
                    "Gite with the given id does not exist");
        }
        return response.successResponse("Offre {}" +
                "" +
                "returned successfully", offre.convertModelDTO());
    }

    @RequestMapping(value = "/offres", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllOffres() {

        return response.successResponse("GET OK !!",offreService.findAllOffres());
    }

    @PostMapping(value = "/offre", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createPatient(@Valid @RequestBody OffreDTO offre) {

        offreService.createOffre(offre);
        return response.successResponse("Offre created !!", true);
    }
}
