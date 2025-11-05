package com.clinica.clinica.Service;

import com.clinica.clinica.Model.HorarioAtendimento;
import com.clinica.clinica.Repository.MedicoRepository;
import com.clinica.clinica.Model.Medico;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Transactional //garante que medico e horario sejam salvos na mesma transação
    public Medico salvarMedico(Medico medico) {
        //caso a lista de horario n for nula, é preciso dizer para cada horario qm é o medico pai
        if (medico.getHorarios() != null && !medico.getHorarios().isEmpty()) {
            //percorre a lista de horarios e para cada horario indica quem é o medico 
            for (HorarioAtendimento horario : medico.getHorarios()) {
                horario.setMedico(medico);
            }
        }
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodosCLientes() {
        return medicoRepository.findAll();
    }


    public Medico buscarMedicoPorId(Long id) {
        return medicoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Medico de ID " + id + " não encontrado"));
    }

    public void deletarMedicoPorId(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico atualizarMedico(Long id, Medico medicoAtualizado) {
        medicoAtualizado.setId(id);
        return medicoRepository.save(medicoAtualizado);
    }

}
