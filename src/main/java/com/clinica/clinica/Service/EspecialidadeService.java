package com.clinica.clinica.Service;

import com.clinica.clinica.Repository.EspecialidadeRepository;
import com.clinica.clinica.Model.Especialidade;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Especialidade> listarTodasEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade salvarEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public Especialidade buscarEspecialidadePorId(Long id) {
        return especialidadeRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Especialidade de ID " + id + " não encontrado"));
    }

    public void deletarEspecialidadePorId(Long id) {
        especialidadeRepository.deleteById(id);
    }

    public Especialidade atualizarEspecialidade(Long id, Especialidade especialidade) {
        Especialidade especialidadeSalvo = buscarEspecialidadePorId(id);
        BeanUtils.copyProperties(especialidade, especialidadeSalvo, "id");
        return especialidadeRepository.save(especialidadeSalvo);
    }

    public Especialidade buscarPorEspecialidade(String especialidade) {
        return especialidadeRepository.findByEspecialidade(especialidade);
    }
}
