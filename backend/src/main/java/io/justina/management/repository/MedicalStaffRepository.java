package io.justina.management.repository;

import io.justina.management.model.MedicalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Long> {



}