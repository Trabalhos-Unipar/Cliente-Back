package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Consulta;
import com.clinica.clinica.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
