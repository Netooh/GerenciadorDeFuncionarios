package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import br.com.celsoneto.GerenciadorDeFuncionarios.Lojas.LojaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionarioControllerUi {

    private final FuncionarioService funcionarioService;
    private final LojaService lojaService;

    public FuncionarioControllerUi(FuncionarioService funcionarioService, LojaService lojaService) {
        this.funcionarioService = funcionarioService;
        this.lojaService = lojaService;
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

    @GetMapping("/cadastrar")
    public String mostrarFormularioFuncionario(Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO());
        model.addAttribute("cargos", CargoFuncionario.values());
        model.addAttribute("lojas", lojaService.listarLojas());
        return "html/cadastrarFuncionario";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute FuncionarioDTO funcionario, RedirectAttributes redirectAttributes) {
        funcionarioService.cadastrarFuncionario(funcionario);
        redirectAttributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
        return "redirect:/funcionarios/ui/inicio";
    }


    @GetMapping("/deletar/{id}")
    public String deletarFuncionarioID(@PathVariable Long id){
        funcionarioService.deletarFuncionarioID(id);
        return "redirect:/funcionarios/ui/inicio";
    }

}
