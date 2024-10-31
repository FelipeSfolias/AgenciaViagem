package br.edu.famper.agenciaviagem.service;


import br.edu.famper.agenciaviagem.dto.PacoteDto;
import br.edu.famper.agenciaviagem.model.Destino;
import br.edu.famper.agenciaviagem.model.Pacote;
import br.edu.famper.agenciaviagem.repository.DestinoRepository;
import br.edu.famper.agenciaviagem.repository.PacoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public List<PacoteDto> getAllPacotes() {
        return pacoteRepository
                .findAll()
                .stream()
                .map(pacote -> PacoteDto
                        .builder()
                        .nome(pacote.getNome())
                        .descricao(pacote.getDescricao())
                        .preco(pacote.getPreco())
                        .dataInicio(String.valueOf(pacote.getDataInicio()))
                        .dataFim(String.valueOf(pacote.getDataFim()))
                        .destinoId(pacote.getId())
                        .build())
                .toList();
    }
    public Pacote salvar(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Optional<Pacote> findById(Long id) {
        return pacoteRepository.findById(id);
    }

    public Pacote update(Pacote pacote) {
        Pacote salvo = pacoteRepository.findById(pacote.getId()).orElseThrow(()->
                new RuntimeException("Pacote não encontrado"));;
        salvo.setNome(pacote.getNome());
        salvo.setDescricao(pacote.getDescricao());
        salvo.setPreco(pacote.getPreco());
        salvo.setDataInicio(pacote.getDataInicio());
        salvo.setDataFim(pacote.getDataFim());
        salvo.setDestinos(pacote.getDestinos());
        return pacoteRepository.save(pacote);
    }

    public void delete(Long id) {
        pacoteRepository.deleteById(id);
    }
}
