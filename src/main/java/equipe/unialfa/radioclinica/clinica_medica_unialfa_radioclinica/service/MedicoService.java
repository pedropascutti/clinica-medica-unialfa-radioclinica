package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MedicoService {
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    

}