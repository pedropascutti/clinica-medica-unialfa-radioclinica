package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.api;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Agenda;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaApiController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<Agenda>> listar() {
        return ResponseEntity.ok(agendaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Agenda> criar(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(agendaService.salvar(agenda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizar(@PathVariable Long id, @RequestBody Agenda agenda) {
        return ResponseEntity.ok(agendaService.atualizar(id, agenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        agendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
