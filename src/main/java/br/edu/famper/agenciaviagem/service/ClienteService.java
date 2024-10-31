package br.edu.famper.agenciaviagem.service;


import br.edu.famper.agenciaviagem.dto.ClienteDto;
import br.edu.famper.agenciaviagem.model.Cliente;
import br.edu.famper.agenciaviagem.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> getAllClientes() {
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> ClienteDto
                        .builder()
                        .nome(cliente.getNome())
                        .cpf(cliente.getCpf())
                        .email(cliente.getEmail())
                        .telefone(cliente.getTelefone())
                        .endereco(cliente.getEndereco())
                        .build())
                .toList();
    }
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente update(Cliente cliente) {
        Cliente salvo = clienteRepository.findById(cliente.getId()).orElseThrow(()->
                new RuntimeException("Cliente não encontrado"));;
        salvo.setNome(cliente.getNome());
        salvo.setCpf(cliente.getCpf());
        salvo.setEmail(cliente.getEmail());
        salvo.setTelefone(cliente.getTelefone());
        salvo.setEndereco(cliente.getEndereco());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
