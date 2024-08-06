package io.justina.management.service.impl;

import io.justina.management.repository.AppointmentRepository;
import io.justina.management.repository.HealthProfessional;
import io.justina.management.repository.PatientRepository;
import io.justina.management.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private  AppointmentRepository appointmentRepository;
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private HealthProfessional healthProfessional;

    private final ModelMapper modelMapper = new ModelMapper();




    @Transactional
    @Override
    public void deleteAppointment(Long idAppointment) {
        appointmentRepository.deleteById(idAppointment);
    }
}
