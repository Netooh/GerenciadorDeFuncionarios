package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios.FuncionarioModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table( name = "tb_lojas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LojaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(unique = true)
    private String endereco;

    @OneToMany(mappedBy = "lojas")
    @JsonIgnore
    private List<FuncionarioModel> funcionarios;

}
