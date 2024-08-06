package io.justina.management.service.impl;

import io.justina.management.dto.request.FinancierRegisterDTO;
import io.justina.management.dto.response.FinancierResponseDTO;
import io.justina.management.model.HealthInsurance;
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

    private final io.justina.management.repository.HealthInsurance healthInsurance;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public HealthInsuranceServiceImpl(io.justina.management.repository.HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    @Override
    public List<FinancierResponseDTO> getAllFinanciers() {
        List<HealthInsurance> healthInsuranceList = healthInsurance.findAll();
        Type listType = new TypeToken<List<FinancierResponseDTO>>() {}.getType();
        return modelMapper.map(healthInsuranceList, listType);
    }

    /**
     * Obtiene un financiador por su ID.
     *
     * @param financierId ID del financiador que se desea obtener.
     * @return DTO que representa al financiador encontrado.
     * @throws RuntimeException Si el financiador no se encuentra en la base de datos.
     */
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

    /**
     * Registra un nuevo financiador en el sistema.
     *
     * @param financier DTO con los datos del financiador que se desea registrar.
     * @return DTO que representa al financiador registrado.
     */
    @Override
    public FinancierResponseDTO registerFinancier(FinancierRegisterDTO financier) {
        HealthInsurance healthInsuranceEntity = modelMapper.map(financier, HealthInsurance.class);
        healthInsurance.save(healthInsuranceEntity);
        return modelMapper.map(healthInsuranceEntity, FinancierResponseDTO.class);
    }
}
