package com.clinica.clinica.Controller;


import org.springframework.web.bind.annotation.*;
import com.clinica.clinica.Model.Paciente;
import com.clinica.clinica.Service.PacienteService;

import java.util.List;

@RestController

@RequestMapping("/paciente")
public class    PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listar")
    public List<Paciente> listarTodosPaciente() {
        return pacienteService.listarTodosPacientes();
    }

    @PostMapping("/salvar-paciente")
    public Paciente salvarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.salvarPaciente(paciente);
    }

    @GetMapping("/buscar-paciente/{id}")
    public Paciente buscarPacientePorId(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }

    @DeleteMapping("/deletar-paciente/{id}")
    public void deletarPacientePorId(@PathVariable Long id) {
        pacienteService.deletarPacientePorId(id);
    }

    @PutMapping("/atualizar-paciente/{id}")
    public Paciente atualizarPacientePorId(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.atualizarPaciente(id, paciente);
    }
}

