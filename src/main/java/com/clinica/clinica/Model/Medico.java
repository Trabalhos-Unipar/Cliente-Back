package com.clinica.clinica.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Medico extends Pessoa {

    @Column(name = "crm", unique = true, nullable = false)
    private String crm;

    @Column(name = "especialidade", nullable = false)
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

    public List<HorarioAtendimento> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioAtendimento> horarios) {
        this.horarios = horarios;
    }

}