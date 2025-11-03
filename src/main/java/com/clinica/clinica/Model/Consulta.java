package com.clinica.clinica.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataConsulta;
    private Date horaConsulta;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    //fazeer o prontuario

}
