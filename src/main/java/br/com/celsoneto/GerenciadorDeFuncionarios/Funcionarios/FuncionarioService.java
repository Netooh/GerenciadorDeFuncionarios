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

    public void deletarFuncionarioID(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioModel alterarFuncionario(Long id,FuncionarioModel funcionarioAT){
        if (funcionarioRepository.existsById(id)){
            funcionarioAT.setId(id);
            return funcionarioRepository.save(funcionarioAT);
        }

        return null;
    }


}
