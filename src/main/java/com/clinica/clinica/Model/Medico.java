package com.clinica.clinica.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
public class Medico extends Pessoa {

    @Column(name = "crm", unique = true)
    private String crm;

    @Column(name = "especialidade")
    private String especialidade;

    @OneToMany(
            mappedBy = "medico",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Column(name = "especialidade")
    @JsonManagedReference //indica que é o pai
    private List<HorarioAtendimento> horarios;

    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public List<HorarioAtendimento> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioAtendimento> horarios) {
        this.horarios = horarios;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}