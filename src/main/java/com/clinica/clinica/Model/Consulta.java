package com.clinica.clinica.Model;

import com.clinica.clinica.Enum.DiaSemanaEnum;
import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Column(name = "diaConsulta")
    private DiaSemanaEnum diaConsulta;

    @Column(name = "horaConsulta")
    private LocalTime horaConsulta;

    public DiaSemanaEnum getDiaConsulta() {
        return diaConsulta;
    }

    public void setDiaConsulta(DiaSemanaEnum diaConsulta) {
        this.diaConsulta = diaConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
