package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.MedicoService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping()
    public String iniciar(Medico medico, Model model) {
        return "medico/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        model.addAttribute("medicos", service.listarTodos());
        return "medico/lista";
    }

    @PostMapping("salvar")
    public String salvar(Medico medico, Model model) {
        try {
            service.salvar(medico);
            return "redirect:/medico/lista";

        } catch (ConstraintViolationException cve) {
            cve.getConstraintViolations().forEach(cv -> {
                model.addAttribute("erro", cv.getMessageTemplate());
            });
            return iniciar(medico, model);
        } catch (Exception e) {
            return iniciar(medico, model);
        }
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("medico", service.buscarPorId(id));
        return "medico/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.deletar(id);
        return "redirect:/medico/lista";
    }
}
