package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.api;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente; 
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.PacienteService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/pacientes")
public class PacienteApi {
    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }


    }
}
