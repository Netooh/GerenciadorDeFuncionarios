package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
