package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.api;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteApiController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.atualizar(id, paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
