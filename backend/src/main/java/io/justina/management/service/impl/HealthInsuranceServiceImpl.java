package io.justina.management.service.impl;

import io.justina.management.dto.request.FinancierRegisterDTO;
import io.justina.management.dto.response.FinancierResponseDTO;
import io.justina.management.model.HealthInsurance;
import io.justina.management.repository.HealthInsuranceRepository;
import io.justina.management.service.HealthInsuranceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {


    @Autowired
    private HealthInsuranceRepository healthInsurance;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<FinancierResponseDTO> getAllFinanciers() {
        List<HealthInsurance> healthInsuranceList = healthInsurance.findAll();
        Type listType = new TypeToken<List<FinancierResponseDTO>>() {}.getType();
        return modelMapper.map(healthInsuranceList, listType);
    }

    @Override
    public FinancierResponseDTO getFinancierById(UUID financierId) {
        Optional<HealthInsurance> financierOptional = healthInsurance.findById(financierId);
        if (financierOptional.isPresent()) {
            HealthInsurance healthInsurance = financierOptional.get();
            return modelMapper.map(healthInsurance, FinancierResponseDTO.class);
        } else {
            throw new RuntimeException("HealthInsurance not found");
        }
    }

    @Override
    public FinancierResponseDTO registerFinancier(FinancierRegisterDTO financier) {
        HealthInsurance healthInsuranceEntity = modelMapper.map(financier, HealthInsurance.class);
        healthInsurance.save(healthInsuranceEntity);
        return modelMapper.map(healthInsuranceEntity, FinancierResponseDTO.class);
    }
}