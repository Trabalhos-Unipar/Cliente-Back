package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Especialidade findByEspecialidade(String Especialidade);
}
