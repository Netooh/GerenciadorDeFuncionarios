package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel listarFuncionarioID(Long id) {
        Optional<FuncionarioModel> funcionarioID = funcionarioRepository.findById(id);
        return funcionarioID.orElse(null);
    }

    public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
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
