package com.clinica.clinica.Service;

import com.clinica.clinica.Repository.HorarioAtendimentoRepository;
import com.clinica.clinica.Model.HorarioAtendimento;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HorarioAtendimentoService {

    private final HorarioAtendimentoRepository horarioAtendimentoRepository;

    public HorarioAtendimentoService(HorarioAtendimentoRepository horarioAtendimentoRepository) {
        this.horarioAtendimentoRepository = horarioAtendimentoRepository;
    }

    public List<HorarioAtendimento> listarTodasHoras() {
        return horarioAtendimentoRepository.findAll();
    }

    public HorarioAtendimento salvarHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
        return horarioAtendimentoRepository.save(horarioAtendimento);
    }

    public HorarioAtendimento buscarHorarioAtendimentoPorId(Long id) {
        return horarioAtendimentoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("HorarioAtendimento de ID " + id + " não encontrado"));
    }

    public void deletarHorarioAtendimentoPorId(Long id) {
        horarioAtendimentoRepository.deleteById(id);
    }

    public HorarioAtendimento atualizarHorarioAtendimento(Long id, HorarioAtendimento horarioAtendimento) {
        HorarioAtendimento horarioAtendimentoSalvo = buscarHorarioAtendimentoPorId(id);
        BeanUtils.copyProperties(horarioAtendimento, horarioAtendimentoSalvo, "id");
        return horarioAtendimentoRepository.save(horarioAtendimentoSalvo);
    }
}
