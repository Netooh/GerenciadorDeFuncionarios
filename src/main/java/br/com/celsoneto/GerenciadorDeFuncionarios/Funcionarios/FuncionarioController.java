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
    public FuncionarioModel cadastrarFuncionario(@RequestBody FuncionarioModel funcionario) {
        return funcionarioService.cadastrarFuncionario(funcionario);
    }

    @PutMapping("/alterarID")
    public String alterarFuncionario(){
        return "Alterar Funcionario por ID";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionarioID(@PathVariable Long id){
        funcionarioService.deletarFuncionarioID(id);
    }

}
