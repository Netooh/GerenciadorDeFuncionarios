package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @GetMapping("/listar")
    public String listar(){
        return "Lista de Funcionarios";
    }

    @GetMapping("/listarID")
    public String listarID(){
        return "Listar Funcionarios por ID";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFuncionario() {
        return "Funcionario cadastrado com sucesso!";
    }

    @PutMapping("/alterarID")
    public String alterarFuncionario(){
        return "Alterar Funcionario por ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarFuncionarioID(){
        return "Funcionario Deletado por ID";
    }

}
