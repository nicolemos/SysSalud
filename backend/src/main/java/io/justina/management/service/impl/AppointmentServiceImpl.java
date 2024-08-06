package io.justina.management.service.impl;

import io.justina.management.dto.request.AppointmentDataRegisterDTO;
import io.justina.management.dto.response.AppointmentResponseDTO;
import io.justina.management.exception.BadRequestException;
import io.justina.management.model.Appointment;
import io.justina.management.model.MedicalStaff;
import io.justina.management.model.Patient;
import io.justina.management.repository.AppointmentRepository;
import io.justina.management.repository.MedicalStaffRepository;
import io.justina.management.repository.PatientRepository;
import io.justina.management.service.AppointmentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private  AppointmentRepository appointmentRepository;
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private  MedicalStaffRepository medicalStaffRepository;

    private final ModelMapper modelMapper = new ModelMapper();




    @Transactional
    @Override
    public void deleteAppointment(Long idAppointment) {
        appointmentRepository.deleteById(idAppointment);
    }
}
