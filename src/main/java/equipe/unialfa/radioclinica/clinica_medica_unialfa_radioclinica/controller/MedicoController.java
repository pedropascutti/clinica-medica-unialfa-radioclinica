package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("medico")
public class MedicoController {

    @GetMapping()
    public String iniciar(Model model) {
        return "medico/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        return "medico/lista";
    }
}
