package com.clinica.clinica.Service;

import com.clinica.clinica.Repository.ProntuarioRepository;
import com.clinica.clinica.Model.Prontuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository) {
        this.prontuarioRepository = prontuarioRepository;
    }

    public List<Prontuario> listarTodosCLientes() {
        return prontuarioRepository.findAll();
    }

    public Prontuario salvarProntuario(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public Prontuario buscarProntuarioPorId(Long id) {
        return prontuarioRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Prontuario de ID " + id + " não encontrado"));
    }

    public void deletarProntuarioPorId(Long id) {
        prontuarioRepository.deleteById(id);
    }

    public Prontuario atualizarProntuario(Long id, Prontuario prontuario) {
        Prontuario prontuarioSalvo = buscarProntuarioPorId(id);
        BeanUtils.copyProperties(prontuario, prontuarioSalvo, "id");
        return prontuarioRepository.save(prontuarioSalvo);
    }
    public Prontuario buscarPorConsulta(Long consultaId) {
        return prontuarioRepository.findByConsultaId(consultaId).orElse(null);
    }

}
