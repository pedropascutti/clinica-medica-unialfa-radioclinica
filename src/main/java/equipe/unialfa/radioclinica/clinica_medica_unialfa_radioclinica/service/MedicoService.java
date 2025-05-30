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

    // isso aqui é pra listar todos os médicos no lindo front ende
    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    // isso aqui busca o médico por id único na databeise
    public Medico buscarPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    // isso aqui é pra salvar um médico (meio doido)
     public Medico salvar(Medico medico) {
        try {
            return medicoRepository.save(medico);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            System.out.println("Erro ao salvar médico: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar médico: " + e.getMessage());
        }
    }

    
    public Medico atualizar(Long id, Medico medicoAtualizado) {
        try {
            Medico medicoExistente = buscarPorId(id);

            medicoExistente.setNome(medicoAtualizado.getNome());
            medicoExistente.setCrm(medicoAtualizado.getCrm());
            medicoExistente.setEspecialidade(medicoAtualizado.getEspecialidade());
            

            return medicoRepository.save(medicoExistente);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar médico: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar médico: " + e.getMessage());
        }
    }

    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

}