package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Consulta;
import com.clinica.clinica.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c " +
            "JOIN FETCH c.paciente " +
            "JOIN FETCH c.medico" )
    List<Consulta> findAllComDetalhes();
}

