package com.clinica.clinica.Model;

import jakarta.persistence.*;


import java.sql.Timestamp;
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

    @OneToOne
    @JoinColumn(name = "horario_atendimento_id")
    private HorarioAtendimento horarioAtendimento;

    public HorarioAtendimento getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
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
