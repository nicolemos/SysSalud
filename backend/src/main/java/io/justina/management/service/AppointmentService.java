package io.justina.management.service;

import io.justina.management.dto.request.AppointmentDataRegisterDTO;
import io.justina.management.dto.response.AppointmentResponseDTO;

import java.util.List;

/**
 * Interfaz que define el servicio para gestionar citas médicas en el sistema.
 */
public interface AppointmentService {


    void deleteAppointment(Long idAppointment);

}


