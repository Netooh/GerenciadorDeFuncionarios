package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @GetMapping("/listar")
    public String listar(){
        return "Lista de lojas";
    }

    @GetMapping("/listarID")
    public String listarID(){
        return "Listar Loja por ID";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLoja(){
        return "Loja Cadastrada com sucesso!";
    }

    @PutMapping("/alterarID")
    public String alterarLoja(){
        return "Loja Alterada com sucesso!";
    }

    @DeleteMapping("/deletarID")
    public String deletarLojaID(){
        return "Loja Deletada com sucesso!";
    }

}
