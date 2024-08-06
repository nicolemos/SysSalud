package io.justina.management.repository;

import io.justina.management.model.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, Long> {
}