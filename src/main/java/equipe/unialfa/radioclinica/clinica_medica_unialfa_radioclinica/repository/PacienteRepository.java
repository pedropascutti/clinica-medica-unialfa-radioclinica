package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
