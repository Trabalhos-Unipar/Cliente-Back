package com.clinica.clinica.Service;

import com.clinica.clinica.Model.Consulta;
import com.clinica.clinica.Repository.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> listarTodosCLientes() {
        return consultaRepository.findAll();
    }

    public Consulta salvarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta buscarConsultaPorId(Long id) {
        return consultaRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Consulta de ID " + id + " não encontrada"));
    }

    public void deletarConsultaPorId(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta atualizarConsulta(Long id, Consulta consulta) {
        Consulta consultaSalvo = buscarConsultaPorId(id);
        BeanUtils.copyProperties(consulta, consultaSalvo, "id");
        return consultaRepository.save(consultaSalvo);
    }
}
