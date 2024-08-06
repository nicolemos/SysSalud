package io.justina.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaz de repositorio para la entidad HealthInsurance.
 * Esta interfaz proporciona métodos para realizar operaciones de persistencia y consulta
 * sobre entidades de tipo HealthInsurance en la base de datos.
 */
@Repository
public interface HealthInsurance extends JpaRepository<io.justina.management.model.HealthInsurance, UUID> {

}

