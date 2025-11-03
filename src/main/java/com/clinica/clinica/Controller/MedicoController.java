package com.clinica.clinica.Controller;


import org.springframework.web.bind.annotation.*;
import com.clinica.clinica.Model.Medico;
import com.clinica.clinica.Service.MedicoService;

import java.util.List;

@RestController

@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping("/listar")
    public List<Medico> listarTodosMedico() {
        return medicoService.listarTodosCLientes();
    }

    @PostMapping("/salvar-medico")
    public Medico salvarMedico(@RequestBody Medico medico) {
        return medicoService.salvarMedico(medico);
    }

    @GetMapping("/buscar-medico/{id}")
    public Medico buscarMedicoPorId(@PathVariable Long id) {
        return medicoService.buscarMedicoPorId(id);
    }

    @DeleteMapping("/deletar-medico/{id}")
    public void deletarMedicoPorId(@PathVariable Long id) {
        medicoService.deletarMedicoPorId(id);
    }

    @PutMapping("/atualizar-medico/{id}")
    public Medico atualizarMedicoPorId(@PathVariable Long id, @RequestBody Medico medico) {
        return medicoService.atualizarMedico(id, medico);
    }
}

