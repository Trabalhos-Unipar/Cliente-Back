package com.clinica.clinica.Controller;


import com.clinica.clinica.Model.Consulta;
import com.clinica.clinica.Service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }


    @PatchMapping("/concluir/{id}")
    public ResponseEntity<Consulta> concluirConsulta(@PathVariable Long id) {
        try {
            Consulta consultaConcluida = consultaService.concluirConsulta(id);

            return ResponseEntity.ok(consultaConcluida);
        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public List<Consulta> listarTodosConsulta() {
        return consultaService.listarTodoConsultas();
    }

    @PostMapping("/salvar-consulta")
    public Consulta salvarConsulta(@RequestBody Consulta consulta) {
        return consultaService.salvarConsulta(consulta);
    }

    @GetMapping("/buscar-consulta/{id}")
    public Consulta buscarConsultaPorId(@PathVariable Long id) {
        return consultaService.buscarConsultaPorId(id);
    }

    @DeleteMapping("/deletar-consulta/{id}")
    public void deletarConsultaPorId(@PathVariable Long id) {
        consultaService.deletarConsultaPorId(id);
    }

    @PutMapping("/atualizar-consulta/{id}")
    public Consulta atualizarConsultaPorId(@PathVariable Long id, @RequestBody Consulta consulta) {
        return consultaService.atualizarConsulta(id, consulta);
    }
}

