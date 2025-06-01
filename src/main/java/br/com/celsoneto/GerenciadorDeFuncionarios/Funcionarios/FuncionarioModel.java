package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import br.com.celsoneto.GerenciadorDeFuncionarios.Lojas.LojaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;


@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private LocalDate dataNascimento;

    private String cargo;

    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "lojas_id")
    private LojaModel lojas;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
    }

}
