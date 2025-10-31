package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByNome(String Nome);
}
