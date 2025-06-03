package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel listarFuncionarioID(Long id) {
        Optional<FuncionarioModel> funcionarioID = funcionarioRepository.findById(id);
        return funcionarioID.orElse(null);
    }

    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }


}
