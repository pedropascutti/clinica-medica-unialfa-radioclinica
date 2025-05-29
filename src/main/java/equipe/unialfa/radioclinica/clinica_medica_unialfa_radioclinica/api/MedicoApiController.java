package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.api;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoApiController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listar() {
        return ResponseEntity.ok(medicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Medico> criar(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.salvar(medico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizar(@PathVariable Long id, @RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.atualizar(id, medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
