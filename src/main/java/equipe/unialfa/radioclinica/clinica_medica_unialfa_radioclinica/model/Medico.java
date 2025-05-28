package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "medico")
    private List<Agenda> agendas;

    @NotNull(message = "Informe o nome do paciente")
    private String nome;
    @NotNull(message = "Informe o CRM")
    private String crm;
    @NotNull(message = "Informe a especilidade do médico")
    private String especialidade;


}
