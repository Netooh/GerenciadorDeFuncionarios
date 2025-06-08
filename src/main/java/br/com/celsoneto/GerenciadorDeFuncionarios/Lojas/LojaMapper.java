package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import org.springframework.stereotype.Component;

@Component
public class LojaMapper {

    public LojaModel map(LojaDTO lojaDTO){

        LojaModel lojaModel = new LojaModel();
        lojaModel.setId(lojaDTO.getId());
        lojaModel.setNome(lojaDTO.getNome());
        lojaModel.setCnpj(lojaDTO.getCnpj());
        lojaModel.setEndereco(lojaDTO.getEndereco());
        lojaModel.setFuncionarios(lojaDTO.getFuncionarios());

        return lojaModel;
    }

    public LojaDTO map(LojaModel lojaModel){

        LojaDTO lojaDTO = new LojaDTO();
        lojaDTO.setId(lojaModel.getId());
        lojaDTO.setNome(lojaModel.getNome());
        lojaDTO.setCnpj(lojaModel.getCnpj());
        lojaDTO.setEndereco(lojaModel.getEndereco());
        lojaDTO.setFuncionarios(lojaModel.getFuncionarios());

        return lojaDTO;
    }
}
