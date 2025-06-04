package br.com.celsoneto.GerenciadorDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO){

        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setCpf(funcionarioDTO.getCpf());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setTelefone(funcionarioDTO.getTelefone());
        funcionarioModel.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionarioModel.setEstadoCivil(funcionarioDTO.getEstadoCivil());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());
        funcionarioModel.setDataCadastro(funcionarioDTO.getDataCadastro());
        funcionarioModel.setDataUpdate(funcionarioDTO.getDataUpdate());
        funcionarioModel.setLojas(funcionarioDTO.getLojas());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel){

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setCpf(funcionarioModel.getCpf());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setTelefone(funcionarioModel.getTelefone());
        funcionarioDTO.setDataNascimento(funcionarioModel.getDataNascimento());
        funcionarioDTO.setEstadoCivil(funcionarioModel.getEstadoCivil());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());
        funcionarioDTO.setDataCadastro(funcionarioModel.getDataCadastro());
        funcionarioDTO.setDataUpdate(funcionarioModel.getDataUpdate());
        funcionarioDTO.setLojas(funcionarioModel.getLojas());

        return funcionarioDTO;
    }
}
