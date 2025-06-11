package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LojaDTO>> listarLojas(){
        List<LojaDTO> lojas = lojaService.listarLojas();
        return ResponseEntity.ok(lojas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarLojaID(@PathVariable Long id){

        LojaDTO loja = lojaService.listarLojaID(id);

        if (loja != null){
            return ResponseEntity.ok(loja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Loja "+ loja.getNome() + " Não Encontrado!");
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarLoja(@RequestBody LojaDTO loja) {
        LojaDTO novaloja = lojaService.cadastrarLoja(loja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Loja "+ novaloja.getNome()+ " Cadastrado com Sucesso! ");
    }

    @PutMapping("/alterarID/{id}")
    public ResponseEntity<?> alterarLoja(@PathVariable Long id,@RequestBody LojaDTO lojaAT){

        LojaDTO lojaAlterado = lojaService.alterarLoja(id,lojaAT);

        if(lojaAlterado!=null){
            return ResponseEntity.ok(lojaAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Loja "+ lojaAlterado.getNome() + " Não Encontrado!");
        }

    }

    @DeleteMapping("/deletarID")
    public String deletarLojaID(){
        return "Loja Deletada com sucesso!";
    }

}
