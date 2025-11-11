package com.clinica.clinica.Service;

import com.clinica.clinica.Model.Consulta;
import com.clinica.clinica.Model.HorarioAtendimento;
import com.clinica.clinica.Repository.ConsultaRepository;
import com.clinica.clinica.Repository.HorarioAtendimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository, HorarioAtendimentoRepository horarioAtendimentoRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> listarTodoConsultas() {
        return consultaRepository.findAllComDetalhes();
    }

    @Transactional
    public Consulta salvarConsulta(Consulta consulta) {
        if (consulta.getHoraConsulta() == null || consulta.getDiaConsulta() == null) {
            throw new RuntimeException("A consulta deve estar associada a um dia e/ou hora válidos");
        }
        return consultaRepository.save(consulta);
    }

    @Transactional
    public Consulta concluirConsulta(Long id) {
        Consulta consultaParaConcluir = buscarConsultaPorId(id);

        consultaParaConcluir.setStatus("CONCLUIDA");

        return consultaRepository.save(consultaParaConcluir);
    }

    public Consulta buscarConsultaPorId(Long id) {
        return consultaRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Consulta de ID " + id + " não encontrada"));
    }

    @Transactional
    public void deletarConsultaPorId(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta atualizarConsulta(Long id, Consulta consulta) {
        Consulta consultaSalvo = buscarConsultaPorId(id);
        BeanUtils.copyProperties(consulta, consultaSalvo, "id");
        return consultaRepository.save(consultaSalvo);
    }
}
