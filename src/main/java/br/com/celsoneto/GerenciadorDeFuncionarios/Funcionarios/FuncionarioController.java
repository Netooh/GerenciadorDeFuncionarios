package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/listar/{id}")
    public FuncionarioModel listarFuncionarioID(@PathVariable Long id){
        return funcionarioService.listarFuncionarioID(id);
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
