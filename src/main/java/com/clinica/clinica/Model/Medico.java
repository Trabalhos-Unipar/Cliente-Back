package com.clinica.clinica.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Medico extends Pessoa{

    @Column(name = "crm")
    private String crm;

    @Column(name = "data_hora_atendimento")
    private Date data_hora_atendimento;

    @Column(name = "especialidade")
    private String especialidade;
}
