package com.clinica.clinica.Service;

import com.clinica.clinica.Repository.MedicoRepository;
import com.clinica.clinica.Model.Medico;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listarTodosCLientes() {
        return medicoRepository.findAll();
    }

    public Medico salvarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico buscarMedicoPorId(Long id) {
        return medicoRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Medico de ID " + id + " não encontrado"));
    }

    public void deletarMedicoPorId(Long id) {
        medicoRepository.deleteById(id);
    }

    public Medico atualizarMedico(Long id, Medico medico) {
        Medico medicoSalvo = buscarMedicoPorId(id);
        BeanUtils.copyProperties(medico, medicoSalvo, "id");
        return medicoRepository.save(medicoSalvo);
    }

}
