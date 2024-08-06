package io.justina.management.controller;

import io.justina.management.dto.response.MedicalStaffResponseDTO;
import io.justina.management.service.HealthProfessionalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/medical-staff")
public class HealthProfessionalController {


    @Autowired
    private HealthProfessionalService medicalStaffService;

    @GetMapping("/getAll")
    @Operation(summary = "Get all medical staff")
    public ResponseEntity<List<MedicalStaffResponseDTO>> getAllMedicalStaff(){
        return ResponseEntity.ok(medicalStaffService.getAllMedicalStaff());
    }


    @GetMapping("/getActive")
    @Operation(summary = "Get all active medical staff")
    public ResponseEntity<List<MedicalStaffResponseDTO>> getMedicalStaffByActive(){
        return ResponseEntity.ok(medicalStaffService.getMedicalStaffByActive());
    }







}