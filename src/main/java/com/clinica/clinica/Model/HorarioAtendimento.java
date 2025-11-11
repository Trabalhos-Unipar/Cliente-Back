package com.clinica.clinica.Model;

import com.clinica.clinica.Enum.DiaSemanaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "horario_atendimento")
public class HorarioAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana", nullable = true)
    private DiaSemanaEnum diaSemana;
    @Column(name = "hora_inicio", nullable = true)
    private LocalTime horaInicio;
    @Column(name = "hora_fim", nullable = true)
    private LocalTime horaFim;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = true)
    @JsonBackReference //indica que é o filho
    private Medico medico;



    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaSemanaEnum getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemanaEnum diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}