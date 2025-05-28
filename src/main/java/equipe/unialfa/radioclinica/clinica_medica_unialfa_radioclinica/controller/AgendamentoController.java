package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("agendamento")
public class AgendamentoController {

    @GetMapping()
    public String iniciar(Model model) {
        return "agendamento/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        return "agendamento/lista";
    }
}
