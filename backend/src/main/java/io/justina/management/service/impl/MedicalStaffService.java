package io.justina.management.service.impl;

import io.justina.management.dto.response.MedicalStaffResponseDTO;
import io.justina.management.model.MedicalStaff;
import io.justina.management.repository.MedicalStaffRepository;
import io.justina.management.service.IMedicalStaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Servicio para la gestión del personal médico.
 * Implementa la interfaz IMedicalStaffService.
 */

@Service
public class MedicalStaffService implements IMedicalStaffService {

    @Autowired
    private  MedicalStaffRepository medicalStaffRepository;



    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<MedicalStaffResponseDTO> getAllMedicalStaff() {
        List<MedicalStaff> medicalStaffs = medicalStaffRepository.findAll();
        return getMedicalStaffResponseDTOS(medicalStaffs);
    }


    @Override
    public List<MedicalStaffResponseDTO> getMedicalStaffByActive() {
        List<MedicalStaff> medicalStaffs = medicalStaffRepository.findByUser_ActiveTrue();
        return getMedicalStaffResponseDTOS(medicalStaffs);
    }




    private List<MedicalStaffResponseDTO> getMedicalStaffResponseDTOS(List<MedicalStaff> medicalStaffs) {
        return medicalStaffs.stream()
                .map(medicalStaff -> {
                    MedicalStaffResponseDTO dto = modelMapper.map(medicalStaff, MedicalStaffResponseDTO.class);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
