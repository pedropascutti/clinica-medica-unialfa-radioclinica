package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.AgendaService;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.MedicoService;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AgendaService agendaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalMedicos", medicoService.listarTodos().size());
        model.addAttribute("totalPacientes", pacienteService.listarTodos().size());
        model.addAttribute("totalAgendamentos", agendaService.listarTodos().size());

        return "index";
    }
}
