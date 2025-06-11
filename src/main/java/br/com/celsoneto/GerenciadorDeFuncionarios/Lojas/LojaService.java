package br.com.celsoneto.GerenciadorDeFuncionarios.Lojas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;
    private final LojaMapper lojaMapper;

    public LojaService(LojaRepository lojaRepository, LojaMapper lojaMapper) {
        this.lojaRepository = lojaRepository;
        this.lojaMapper = lojaMapper;
    }

    public List<LojaDTO> listarLojas() {
        List<LojaModel> loja = lojaRepository.findAll();
        return loja.stream()
                .map(lojaMapper::map)
                .collect(Collectors.toList());
    }

    public LojaDTO listarLojaID(Long id) {
        Optional<LojaModel> lojaID = lojaRepository.findById(id);
        return lojaID.map(lojaMapper::map).orElse(null);
    }

    public LojaDTO cadastrarLoja(LojaDTO lojaDTO) {
        LojaModel loja = lojaMapper.map(lojaDTO);
        loja = lojaRepository.save(loja);
        return lojaMapper.map(loja);
    }

    public void deletarLojaID(Long id) {
        lojaRepository.deleteById(id);
    }

    public LojaDTO alterarLoja(Long id, LojaDTO lojaAT) {
        Optional<LojaModel> lojaExistente = lojaRepository.findById(id);
        if (lojaExistente.isPresent()) {
            LojaModel lojaAtualizado = lojaMapper.map(lojaAT);
            lojaAtualizado.setId(id);
            LojaModel lojaSalvo = lojaRepository.save(lojaAtualizado);
            return lojaMapper.map(lojaSalvo);
        }

        return null;
    }
}
