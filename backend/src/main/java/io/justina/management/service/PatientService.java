package io.justina.management.service;


import io.justina.management.dto.request.PatientRequestDTO;
import io.justina.management.dto.response.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO getPatientById(Long patientId);


    PatientResponseDTO createPatient(PatientRequestDTO patient);

    void deactivatePatient(Long patientId);

}
