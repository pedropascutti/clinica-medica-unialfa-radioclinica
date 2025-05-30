package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.controller;

import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Agenda;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Medico;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model.Paciente;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.AgendaService;
import equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.service.MedicoService;
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
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private AgendaService service;

    @Autowired
    private MedicoService Medicoservice;

    @Autowired
    private PacienteService Pacienteservice;

    @GetMapping()
    public String iniciar(Agenda agenda,Model model) {
        model.addAttribute("medicos", Medicoservice.listarTodos());
        model.addAttribute("pacientes", Pacienteservice.listarTodos());
        return "agendamento/formulario";
    }

    @GetMapping("lista")
    public String listar(Model model) {
        model.addAttribute("agendamentos", service.listarTodos());
        return "agendamento/lista";
    }

    @PostMapping("salvar")
    public String salvar(Agenda agenda, Model model) {
        try {
            service.salvar(agenda);
            return "redirect:/agendamento/lista";

        } catch (ConstraintViolationException cve) {
            cve.getConstraintViolations().forEach(cv -> {
                model.addAttribute("erro", cv.getMessageTemplate());
            });
            return iniciar(agenda, model);
        } catch (Exception e) {
            return iniciar(agenda, model);
        }
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("medicos", Medicoservice.listarTodos());
        model.addAttribute("pacientes", Pacienteservice.listarTodos());
        model.addAttribute("agenda", service.buscarPorId(id));
        return "agendamento/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.deletar(id);
        return "redirect:/agendamento/lista";
    }
}
