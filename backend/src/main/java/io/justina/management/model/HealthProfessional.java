
package io.justina.management.model;


import io.justina.management.enums.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_staff")
public class HealthProfessional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_medico")
    private Long id;

    @Column(name="telefono")
    private String phone;

    @Column(name = "numero_registro_medico")
    private Integer medicalRegistrationNumber;

    @Column(name = "especialidad")
    @Enumerated(EnumType.STRING)
    private Specialty specialities;

    @Column(name = "descripcion")
    private String description;



}
