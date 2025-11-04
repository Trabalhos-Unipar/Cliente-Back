package com.clinica.clinica.Repository;

import com.clinica.clinica.Model.Medico;
import com.clinica.clinica.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Medico findByNome(String Nome);

}
