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
    private final HorarioAtendimentoRepository horarioAtendimentoRepository;

    public ConsultaService(ConsultaRepository consultaRepository, HorarioAtendimentoRepository horarioAtendimentoRepository) {
        this.consultaRepository = consultaRepository;
        this.horarioAtendimentoRepository = horarioAtendimentoRepository;
    }

    public List<Consulta> listarTodoConsultas() {
        return consultaRepository.findAll();
    }

    @Transactional
    public Consulta salvarConsulta(Consulta consulta) {
        if (consulta.getHorarioAtendimento() == null || consulta.getHorarioAtendimento().getId() == null) {
            throw new RuntimeException("A consulta deve estar associada a um ID de horário de atendimento válido.");
        }
        Long horarioId = consulta.getHorarioAtendimento().getId();
        HorarioAtendimento horarioParaMarcar = horarioAtendimentoRepository.findById(horarioId)
                .orElseThrow(() -> new RuntimeException("Horário de ID " + horarioId + " não encontrado."));

        if (horarioParaMarcar.getMarcado() != null && horarioParaMarcar.getMarcado()) {
            throw new RuntimeException("Este horário (" + horarioId + ") já está reservado.");
        }

        horarioParaMarcar.setMarcado(true);

        consulta.setHorarioAtendimento(horarioParaMarcar);

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
//arruma o metodo de deletar consulta, quando deletar a consilta tem que liberar o horario caso tenha marcado
//uma consulta nesse horario, faz verificação com um if