package com.clinica.clinica.Controller;


import com.clinica.clinica.Model.Especialidade;
import com.clinica.clinica.Model.Especialidade;
import com.clinica.clinica.Service.EspecialidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidade")

public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @GetMapping("/listar")
    public List<Especialidade> listarTodosEspecialidade() {
        return especialidadeService.listarTodasEspecialidades();
    }

    @PostMapping("/salvar-especialidade")
    public Especialidade salvarEspecialidade(@RequestBody Especialidade especialidade) {
        return especialidadeService.salvarEspecialidade(especialidade);
    }

    @GetMapping("/buscar-especialidade/{id}")
    public Especialidade buscarEspecialidadePorId(@PathVariable Long id) {
        return especialidadeService.buscarEspecialidadePorId(id);
    }

    @DeleteMapping("/deletar-especialidade/{id}")
    public void deletarEspecialidadePorId(@PathVariable Long id) {
        especialidadeService.deletarEspecialidadePorId(id);
    }

    @PutMapping("/atualizar-especialidade/{id}")
    public Especialidade atualizarEspecialidadePorId(@PathVariable Long id, @RequestBody Especialidade especialidade) {
        return especialidadeService.atualizarEspecialidade(id, especialidade);
    }
}
