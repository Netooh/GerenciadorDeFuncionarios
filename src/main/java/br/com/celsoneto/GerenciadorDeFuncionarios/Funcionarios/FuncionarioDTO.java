package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import br.com.celsoneto.GerenciadorDeFuncionarios.Lojas.LojaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private CargoFuncionario cargo;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUpdate;
    private LojaModel lojas;

}
