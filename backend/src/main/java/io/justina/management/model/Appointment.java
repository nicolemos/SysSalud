package io.justina.management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * Clase que representa un turno médico.
 * Esta entidad está mapeada a la tabla "turnos" en la base de datos.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turnos")
@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long id;

    @Column(name = "centro_atencion")
    private String healthCenter;

    @Column(name = "fecha_turno")
    private LocalDateTime date;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Patient patient;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_id")
    private HealthProfessional healthProfessional;


}

