package io.justina.management.service.impl;


import io.justina.management.dto.request.PatientRequestDTO;
import io.justina.management.dto.response.PatientResponseDTO;
import io.justina.management.enums.RoleEnum;
import io.justina.management.model.Patient;
import io.justina.management.model.User;
import io.justina.management.repository.PatientRepository;
import io.justina.management.repository.UserRepository;
import io.justina.management.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para gestionar pacientes en el sistema.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private  PatientRepository patientRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .toList();
    }

    @Override
    public PatientResponseDTO getPatientById(Long patientId) {
        return null;
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patient) {
        return null;
    }


    @Override
    public void deactivatePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setActive(false);
        patientRepository.save(patient);
    }
}
