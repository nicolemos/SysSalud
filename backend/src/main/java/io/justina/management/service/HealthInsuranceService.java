package io.justina.management.service;

import io.justina.management.dto.request.FinancierRegisterDTO;
import io.justina.management.dto.response.FinancierResponseDTO;

import java.util.List;
import java.util.UUID;


public interface HealthInsuranceService {


    List<FinancierResponseDTO> getAllFinanciers();

    FinancierResponseDTO getFinancierById(UUID financierId);

    FinancierResponseDTO registerFinancier(FinancierRegisterDTO financier);
}