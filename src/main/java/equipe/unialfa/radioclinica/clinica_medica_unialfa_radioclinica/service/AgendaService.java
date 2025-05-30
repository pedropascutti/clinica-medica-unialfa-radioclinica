package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Agenda;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository.AgendaRepository;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    // pra listar todos os agendamentos 
    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    // buscar por id
    public Agenda buscarPorId(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

    }
    // salvar um agendamento

   public Agenda salvar(Agenda agenda) {
        try {
            Medico medico = medicoService.buscarPorId(agenda.getMedico().getId());
            Paciente paciente = pacienteService.buscarPorId(agenda.getPaciente().getId());
            agenda.setMedico(medico);
            agenda.setPaciente(paciente);
            return agendaRepository.save(agenda);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            System.out.println("Erro ao salvar agendamento: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar agendamento: " + e.getMessage());
        }
    }

    public Agenda atualizar(Long id, Agenda agendaAtualizada) {
        try {
            Agenda agendaExistente = buscarPorId(id); 

            agendaExistente.setData(agendaAtualizada.getData());

            if (agendaAtualizada.getMedico() != null && !agendaExistente.getMedico().getId().equals(agendaAtualizada.getMedico().getId())) {
                Medico medico = medicoService.buscarPorId(agendaAtualizada.getMedico().getId());
                agendaExistente.setMedico(medico);
            }
            if (agendaAtualizada.getPaciente() != null && !agendaExistente.getPaciente().getId().equals(agendaAtualizada.getPaciente().getId())) {
                Paciente paciente = pacienteService.buscarPorId(agendaAtualizada.getPaciente().getId());
                agendaExistente.setPaciente(paciente);
            }

            return agendaRepository.save(agendaExistente);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar agendamento: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar agendamento: " + e.getMessage());
        }
    }
    


     public void deletar(Long id) {
        agendaRepository.deleteById(id);
    }


}