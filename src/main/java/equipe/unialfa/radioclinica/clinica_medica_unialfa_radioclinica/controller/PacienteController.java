package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.PacienteService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping()
    public String iniciar(Paciente paciente, Model model) {
        return "paciente/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        model.addAttribute("pacientes", service.listarTodos());
        return "paciente/lista";
    }

    @PostMapping("salvar")
    public String salvar(Paciente paciente, Model model) {
        try {
            service.salvar(paciente);
            return "redirect:/paciente/lista";
        } catch (ConstraintViolationException cve) {
            cve.getConstraintViolations().forEach(cv -> {
                model.addAttribute("erro", cv.getMessageTemplate());
            });
            return iniciar(paciente, model);
        } catch (Exception e) {
            return iniciar(paciente, model);
        }
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", service.buscarPorId(id));
        return "paciente/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.deletar(id);
        return "redirect:/paciente/lista";
    }
}
