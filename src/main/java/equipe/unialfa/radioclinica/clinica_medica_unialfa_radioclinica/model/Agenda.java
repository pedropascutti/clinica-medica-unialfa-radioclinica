package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pacientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> paciente;


}
