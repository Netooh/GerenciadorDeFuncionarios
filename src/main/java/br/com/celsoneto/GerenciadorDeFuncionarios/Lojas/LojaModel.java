package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table( name = "tb_lojas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LojaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    @OneToMany(mappedBy = "lojas")
    private List<FuncionarioModel> funcionarios;

}
