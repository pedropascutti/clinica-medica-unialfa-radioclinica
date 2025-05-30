package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException("Paciente não encontrado com o ID: " + id));
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setCpf(pacienteAtualizado.getCpf());
            return pacienteRepository.save(paciente);
        }).orElseThrow(() -> new RuntimeException("Paciente não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
