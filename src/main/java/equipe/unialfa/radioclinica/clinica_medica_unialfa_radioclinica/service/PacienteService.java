package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository.PacienteRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
    
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public void salvar(Paciente paciente) {
        try {
            if (paciente.getItens() == null)
                throw new RuntimeException("Informe ao menos um paciente");
            paciente.getItens().forEach(itemPaciente -> itemPaciente.setPaciente(paciente));

            repository.save(paciente);

        } catch (ConstraintViolationException cve) {
            System.out.println(cve.getMessage());
        } catch (RuntimeException re){
            throw re;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
