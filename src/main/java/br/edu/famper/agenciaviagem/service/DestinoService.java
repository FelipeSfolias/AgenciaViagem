package br.edu.famper.agenciaviagem.service;

import br.edu.famper.agenciaviagem.dto.ClienteDto;
import br.edu.famper.agenciaviagem.dto.DestinoDto;
import br.edu.famper.agenciaviagem.model.Cliente;
import br.edu.famper.agenciaviagem.model.Destino;
import br.edu.famper.agenciaviagem.repository.ClienteRepository;
import br.edu.famper.agenciaviagem.repository.DestinoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<DestinosDto> getAllDestinos() {
        return destinoRepository
                .findAll()
                .stream()
                .map(destino -> DestinoDto
                        .builder()
                        .nomeDestino(destino.getNomeDestino())
                        .pais(destino.getPais())
                        .cidade(destino.getCidade())
                        .descricao(destino.getDescricao())
                        .pacote(destino.getPacote())
                        .build())
                .toList();
    }
    public Destino salvar(Destino destino) {
        return destinoRepository.save(destino);
    }

    public Optional<Destino> findById(Long id) {
        return destinoRepository.findById(id);
    }

    public Destino update(Destino destino) {
        Destino salvo = destinoRepository.findById(destino.getId()).orElseThrow(()->
                new RuntimeException("Destino não encontrado"));;
        salvo.setNomeDestino(destino.getNomeDestino());
        salvo.setPais(destino.getPais());
        salvo.setCidade(destino.getCidade());
        salvo.setDescricao(destino.getDescricao());
        salvo.setPacote(destino.getPacote());
        return destinoRepository.save(destino);
    }

    public void delete(Long id) {
        destinoRepository.deleteById(id);
    }
}
