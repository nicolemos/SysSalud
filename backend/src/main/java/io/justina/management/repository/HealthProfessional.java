package io.justina.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HealthProfessional extends JpaRepository<io.justina.management.model.HealthProfessional, Long> {


    List<HealthProfessional> findByUser_ActiveTrue();
}