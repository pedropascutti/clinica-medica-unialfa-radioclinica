package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @GetMapping()
    public String iniciar(Model model) {
        return "paciente/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        return "paciente/lista";
    }
}
