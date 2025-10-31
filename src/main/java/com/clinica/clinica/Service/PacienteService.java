package com.clinica.clinica.Service;

import com.clinica.clinica.Repository.PacienteRepository;
import com.clinica.clinica.Model.Paciente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodosCLientes() {
        return pacienteRepository.findAll();
    }

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Paciente de ID " + id + " não encontrado"));
    }

    public void deletarPacientePorId(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente atualizarPaciente(Long id, Paciente paciente) {
        Paciente pacienteSalvo = buscarPacientePorId(id);
        BeanUtils.copyProperties(paciente, pacienteSalvo, "id");
        return pacienteRepository.save(pacienteSalvo);
    }

    public Paciente buscarPacientePorNome(String nome) {
        return pacienteRepository.findByNome(nome);
    }
}
