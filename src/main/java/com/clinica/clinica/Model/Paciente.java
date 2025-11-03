package com.clinica.clinica.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Paciente extends Pessoa {

    private Date dataNascimento;


}
