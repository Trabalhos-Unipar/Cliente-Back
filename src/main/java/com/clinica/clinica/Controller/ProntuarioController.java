package com.clinica.clinica.Controller;


import org.springframework.web.bind.annotation.*;
import com.clinica.clinica.Model.Prontuario;
import com.clinica.clinica.Service.ProntuarioService;

import java.util.List;

@RestController

@RequestMapping("/prontuario")
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @GetMapping("/listar")
    public List<Prontuario> listarTodosProntuario() {
        return prontuarioService.listarTodosCLientes();
    }

    @PostMapping("/salvar-prontuario")
    public Prontuario salvarProntuario(@RequestBody Prontuario prontuario) {
        return prontuarioService.salvarProntuario(prontuario);
    }

    @GetMapping("/buscar-prontuario/{id}")
    public Prontuario buscarProntuarioPorId(@PathVariable Long id) {
        return prontuarioService.buscarProntuarioPorId(id);
    }

    @DeleteMapping("/deletar-prontuario/{id}")
    public void deletarProntuarioPorId(@PathVariable Long id) {
        prontuarioService.deletarProntuarioPorId(id);
    }

    @PutMapping("/atualizar-prontuario/{id}")
    public Prontuario atualizarProntuarioPorId(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return prontuarioService.atualizarProntuario(id, prontuario);
    }
    @GetMapping("/consulta/{consultaId}")
    public Prontuario buscarProntuarioPorConsulta(@PathVariable Long consultaId) {
        return prontuarioService.buscarPorConsulta(consultaId);
    }
}

