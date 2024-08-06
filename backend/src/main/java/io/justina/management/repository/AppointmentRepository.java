package io.justina.management.repository;

import io.justina.management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

/*
    List<Appointment> findByPatient_Id(Long idPatient);

    List<Appointment> findByMedicalStaff_Id(Long idDoctor);*/
}

