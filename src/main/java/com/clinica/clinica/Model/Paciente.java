package com.clinica.clinica.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Paciente extends Pessoa {

    private Date dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
