package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
