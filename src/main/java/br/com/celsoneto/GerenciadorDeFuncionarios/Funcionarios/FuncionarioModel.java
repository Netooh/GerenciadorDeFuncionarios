package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import br.com.celsoneto.GerenciadorDeFuncionarios.Lojas.LojaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;

    private LocalDate dataNascimento;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Enumerated(EnumType.STRING)
    private CargoFuncionario cargo;

    @Column(columnDefinition = "TIMESTAMP(0)", updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "TIMESTAMP(0)")
    @UpdateTimestamp
    private LocalDateTime dataUpdate;

    @ManyToOne
    @JoinColumn(name = "lojas_id")
    private LojaModel lojas;

}
