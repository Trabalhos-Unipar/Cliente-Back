package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Especialidade;
import com.clinica.clinica.Model.HorarioAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioAtendimentoRepository extends JpaRepository<HorarioAtendimento, Long> {

}
