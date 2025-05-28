package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.repository;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
