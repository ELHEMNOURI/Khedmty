package com.project.job.controller;


import com.project.job.DTO.CvDTO;
import com.project.job.DTO.DiplomeDTO;
import com.project.job.DTO.Exception.ApiRequestException;
import com.project.job.DTO.ResponseDTO;
import com.project.job.model.Diplome;
import com.project.job.service.CvService;
import com.project.job.service.DiplomeService;
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
public class DiplomeController {

    @Autowired
    private Response response;

    @Autowired
    private DiplomeService diplomeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiplomeController.class);

   @GetMapping(value = "/diplome/{idDiplome}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> FindDiplomeById(@PathVariable Long idDiplome) {
        LOGGER.info("Request to return a given diplome by Id : {}", idDiplome);
        Diplome diplome = diplomeService.findById(idDiplome);
        if (diplome == null) {
            throw new ApiRequestException("This Request Is Invalid!",
                    "Gite with the given id does not exist");
        }
        return response.successResponse("Diplome {}" +
                "" +
                "returned successfully", diplome.convertModelDTO());
    }

    @RequestMapping(value = "/diplomes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> listAllDiplome() {

        return response.successResponse("GET OK !!",diplomeService.findAllDiplome());
    }

    @PostMapping(value = "/diplome", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> createDiplome(@Valid @RequestBody DiplomeDTO diplome) {


        diplomeService.createDiplome(diplome);
        return response.successResponse("Diplome created !!", true);
    }

    @PutMapping(value = "/diplome/{idDiplome}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateCV(@PathVariable Long idDiplome, @Valid @RequestBody DiplomeDTO diplome) {

        diplomeService.updateDiplome(idDiplome, diplome);
        return response.successResponse("Experience created !!", true);
    }
}
