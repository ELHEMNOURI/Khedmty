package com.project.job.controller;

import com.project.job.DTO.DemandeEmploiDTO;
import com.project.job.DTO.DiplomeDTO;
import com.project.job.DTO.ResponseDTO;
import com.project.job.service.DemandeEmploiService;
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
public class DemandeEmploiController {

    @Autowired
    private Response response;

    @Autowired
    private DemandeEmploiService demandeEmploiService;

    @RequestMapping(value = "/demandes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllExperiences() {

        return response.successResponse("GET OK !!",demandeEmploiService.findAllDemandes());
    }

    @PostMapping(value = "/demande", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createDemandeEmploi(@Valid @RequestBody DemandeEmploiDTO demande) {


        demandeEmploiService.createDemandeEmploi(demande);
        return response.successResponse("Demande Emploi created !!", true);
    }

    @PutMapping(value = "/demande/{idDemande}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateDemandeEmploi(@PathVariable Long idDemande, @Valid @RequestBody DemandeEmploiDTO demnande) {

        demandeEmploiService.updateDemandeEmploi(idDemande, demnande);
        return response.successResponse("Demande Emploi created !!", true);
    }
}
