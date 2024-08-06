package io.justina.management.repository;

import io.justina.management.model.HealthInsurance;
import io.justina.management.model.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance, UUID> {
}
