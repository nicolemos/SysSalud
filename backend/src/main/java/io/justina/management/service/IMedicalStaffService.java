package io.justina.management.service;

import io.justina.management.dto.response.MedicalStaffResponseDTO;
import io.justina.management.dto.request.MedicalStaffRegisterDTO;

import java.util.List;


public interface IMedicalStaffService {

    List<MedicalStaffResponseDTO> getAllMedicalStaff();

    List<MedicalStaffResponseDTO> getMedicalStaffByActive();
}


