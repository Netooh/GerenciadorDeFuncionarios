package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionarioControllerUi {

    private final FuncionarioService funcionarioService;

    public FuncionarioControllerUi(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/inicio")
    public String listarFuncionarios(Model model){
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "html/gerenciadorDeFuncionarios";
    }

    @GetMapping("/listar/{id}")
    public String listarFuncionarioID(@PathVariable Long id, Model model) {
        FuncionarioDTO funcionario = funcionarioService.listarFuncionarioID(id);

        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario);
            return "html/listarFuncionarioID";
        } else {
            model.addAttribute("mensagem", "Funcionário não encontrado.");
            return "html/gerenciadorDeFuncionarios";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionarioID(@PathVariable Long id){
        funcionarioService.deletarFuncionarioID(id);
        return "redirect:/funcionarios/ui/inicio";
    }

}
