package equipe.unialfa.radioclinica.clinica_medica_unialfa_radioclinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe o nome do paciente")
    private String nome;
    @NotNull(message = "Informe o CPF")
    private String cpf;
    @NotNull(message = "Informe um número para contato")
    private String telefone;
    @NotNull(message = "Informe a Data de Nascimento do Paciente")
    private Date dataNascimento;

}
