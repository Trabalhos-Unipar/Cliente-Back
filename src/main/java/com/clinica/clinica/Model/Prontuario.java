package com.clinica.clinica.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="motivoConsulta")
    private String motivoConsulta;

    @Column(name="diagnostico")
    private String diagnostico;

    @Column(name="receita")
    private String receita;

    @Column(name="observacao")
    private String observacao;

    @ManyToOne
    private Consulta consulta;





}
