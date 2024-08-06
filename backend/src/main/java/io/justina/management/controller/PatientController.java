package io.justina.management.controller;

import io.justina.management.dto.request.PatientRequestDTO;
import io.justina.management.dto.response.PatientResponseDTO;
import io.justina.management.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/api/patient")
public class PatientController {

    @Autowired
    private  PatientService patientService;

    @Operation(summary = "Get all patients")
    @GetMapping()
    public ResponseEntity<List<PatientResponseDTO>> findAll () {
        List<PatientResponseDTO> patientList = patientService.getAllPatients();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }


    @Operation(summary = "Get a patient by ID")
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> findById (@PathVariable Long id){
        try {
            return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
        }catch (AccessDeniedException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Operation(summary = "Create a new patient")
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient (@RequestBody @Valid PatientRequestDTO patient){
        PatientResponseDTO createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a patient by ID")
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletePatient (@PathVariable Long id){
        patientService.deactivatePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
