package com.project.job.controller;

import com.project.job.DTO.DemandeEmploiDTO;
import com.project.job.DTO.ResponseDTO;
import com.project.job.model.DemandeEmploi;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DemandeEmploiController {

    @Autowired
    private Response response;

    @Autowired
    private DemandeEmploiService demandeEmploiService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemandeEmploiController.class);

    @RequestMapping(value = "/demandes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllExperiences() {

        return response.successResponse("GET OK !!",demandeEmploiService.findAllDemandes());
    }

    @GetMapping(value = "/demandes/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> allOffresByStatus(@PathVariable String status) {
        LOGGER.info("Request to return a given demande d'emploi by status : {}", status);
        List<DemandeEmploi> demandes = demandeEmploiService.findAllStatus(status);
        List<DemandeEmploiDTO> demandesDTO = listDemandesToDTO(demandes);
        return response.successResponse("\"All Offres By status\"returned successfully", demandesDTO);
    }
    public List<DemandeEmploiDTO> listDemandesToDTO(List<DemandeEmploi> demandeEmplois){
        List<DemandeEmploiDTO> demandeEmploiDTOS = new ArrayList<>();
        demandeEmplois.forEach(demandeEmploi -> {
            demandeEmploiDTOS.add(demandeEmploi.convertModelDTO());
        });
        return demandeEmploiDTOS;
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
