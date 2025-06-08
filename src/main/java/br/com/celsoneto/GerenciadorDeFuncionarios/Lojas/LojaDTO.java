package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios.FuncionarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LojaDTO {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private List<FuncionarioModel> funcionarios;

}
