package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProntuarioRepository extends JpaRepository<Prontuario,Long> {
    Optional<Prontuario> findByConsultaId(Long consultaId);

}
