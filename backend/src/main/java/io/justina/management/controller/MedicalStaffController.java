package io.justina.management.controller;

import io.justina.management.dto.request.MedicalStaffRegisterDTO;
import io.justina.management.dto.response.MedicalStaffResponseDTO;
import io.justina.management.service.IMedicalStaffService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/medical-staff")
public class MedicalStaffController {


    @Autowired
    private  IMedicalStaffService medicalStaffService;







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
