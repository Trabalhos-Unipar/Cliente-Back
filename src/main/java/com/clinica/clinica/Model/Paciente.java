package com.clinica.clinica.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;

@Entity
public class Paciente extends Pessoa {

    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
