package io.justina.management.service.impl;

import io.justina.management.dto.response.MedicalStaffResponseDTO;
import io.justina.management.model.HealthProfessional;
import io.justina.management.service.HealthProfessionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthProfessionalServiceImpl implements HealthProfessionalService {

    @Autowired
    private io.justina.management.repository.HealthProfessional healthProfessional;



    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<MedicalStaffResponseDTO> getAllMedicalStaff() {
        List<HealthProfessional> healthProfessionals = healthProfessional.findAll();
        return getMedicalStaffResponseDTOS(healthProfessionals);
    }


    @Override
    public List<MedicalStaffResponseDTO> getMedicalStaffByActive() {
        List<HealthProfessional> healthProfessionals = healthProfessional.findByUser_ActiveTrue();
        return getMedicalStaffResponseDTOS(healthProfessionals);
    }




    private List<MedicalStaffResponseDTO> getMedicalStaffResponseDTOS(List<HealthProfessional> healthProfessionals) {
        return healthProfessionals.stream()
                .map(healthProfessional -> {
                    MedicalStaffResponseDTO dto = modelMapper.map(healthProfessional, MedicalStaffResponseDTO.class);
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
