package com.clinica.clinica.Controller;


import com.clinica.clinica.Model.HorarioAtendimento;
import com.clinica.clinica.Service.HorarioAtendimentoService;
import org.springframework.web.bind.annotation.*;
import com.clinica.clinica.Model.HorarioAtendimento;
import com.clinica.clinica.Service.HorarioAtendimentoService;

import java.util.List;

@RestController

@RequestMapping("/hora")
public class HoraAtendimentoController {

    private final HorarioAtendimentoService horaAtendimentoService;

    public HoraAtendimentoController(HorarioAtendimentoService horaAtendimentoService) {
        this.horaAtendimentoService = horaAtendimentoService;
    }

    @GetMapping("/listar")
    public List<HorarioAtendimento> listarTodosHoraAtendimento() {
        return horaAtendimentoService.listarTodasHoras();
    }

    @PostMapping("/salvar-hora")
    public HorarioAtendimento salvarHoraAtendimento(@RequestBody HorarioAtendimento hora) {
        return horaAtendimentoService.salvarHorarioAtendimento(hora);
    }

    @GetMapping("/buscar-hora/{id}")
    public HorarioAtendimento buscarHoraAtendimentoPorId(@PathVariable Long id) {
        return horaAtendimentoService.buscarHorarioAtendimentoPorId(id);
    }

    @DeleteMapping("/deletar-hora/{id}")
    public void deletarHoraAtendimentoPorId(@PathVariable Long id) {
        horaAtendimentoService.deletarHorarioAtendimentoPorId(id);
    }

    @PutMapping("/atualizar-hora/{id}")
    public HorarioAtendimento atualizarHoraAtendimentoPorId(@PathVariable Long id, @RequestBody HorarioAtendimento hora) {
        return horaAtendimentoService.atualizarHorarioAtendimento(id, hora);
    }
}

