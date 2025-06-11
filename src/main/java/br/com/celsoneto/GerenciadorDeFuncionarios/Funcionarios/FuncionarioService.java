package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public List<FuncionarioDTO> listarFuncionarios() {
        List<FuncionarioModel> funcionario = funcionarioRepository.findAll();
        return funcionario.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO listarFuncionarioID(Long id) {
        Optional<FuncionarioModel> funcionarioID = funcionarioRepository.findById(id);
        return funcionarioID.map(funcionarioMapper::map).orElse(null);
    }

    public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    public void deletarFuncionarioID(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO alterarFuncionario(Long id,FuncionarioDTO funcionarioAT){
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()){
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.map(funcionarioAT);
            funcionarioAtualizado.setId(id);
            FuncionarioModel funcionarioSalvo = funcionarioRepository.save(funcionarioAtualizado);
            return funcionarioMapper.map(funcionarioSalvo);
        }

        return null;
    }

}
