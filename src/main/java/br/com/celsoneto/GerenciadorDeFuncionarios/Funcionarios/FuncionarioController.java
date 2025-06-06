package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios(){
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarFuncionarioID(@PathVariable Long id){

        FuncionarioDTO funcionario = funcionarioService.listarFuncionarioID(id);

        if (funcionario != null){
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário "+ funcionario.getNome() + " Não Encontrado!");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario) {
        FuncionarioDTO novoFuncionario = funcionarioService.cadastrarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionário "+ novoFuncionario.getNome()+ " Cadastrado com Sucesso! ");
    }

    @PutMapping("/alterarID/{id}")
    public ResponseEntity<?> alterarFuncionario(@PathVariable Long id,@RequestBody FuncionarioDTO funcionarioAT){

        FuncionarioDTO funcionaroAlterado = funcionarioService.alterarFuncionario(id,funcionarioAT);

        if(funcionaroAlterado!=null){
            return ResponseEntity.ok(funcionaroAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário "+ funcionaroAlterado.getNome() + " Não Encontrado!")
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionarioID(@PathVariable Long id){

        FuncionarioDTO funcionarioDeletar = funcionarioService.listarFuncionarioID(id);

        if(funcionarioDeletar != null){
            funcionarioService.deletarFuncionarioID(id);
            return ResponseEntity.ok("Funcionário " + funcionarioDeletar.getNome() + " Removido com Sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário não encontrado");
        }

    }

}
