package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe a data e hora do agendamento")
    private LocalDateTime data;

    @OneToMany(mappedBy = "pacientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> paciente;

    @OneToMany(mappedBy = "medicos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medico> medico;



}
