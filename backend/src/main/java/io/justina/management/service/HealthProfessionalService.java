package io.justina.management.service;

import io.justina.management.dto.response.MedicalStaffResponseDTO;

import java.util.List;


public interface HealthProfessionalService {

    List<MedicalStaffResponseDTO> getAllMedicalStaff();

    List<MedicalStaffResponseDTO> getMedicalStaffByActive();
}


