package br.edu.famper.agenciaviagem.service;


import br.edu.famper.agenciaviagem.dto.ReservaDto;
import br.edu.famper.agenciaviagem.model.Destino;
import br.edu.famper.agenciaviagem.model.Reserva;
import br.edu.famper.agenciaviagem.repository.DestinoRepository;
import br.edu.famper.agenciaviagem.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaDto> getAllReservas() {
        return reservaRepository
                .findAll()
                .stream()
                .map(reserva -> ReservaDto
                        .builder()
                        .dataReserva(String.valueOf(reserva.getDataReserva()))
                        .status(reserva.getStatus())
                        .clienteId(reserva.getId())
                        .pacoteViagemId(reserva.getId())
                        .build())
                .toList();
    }
    public Reserva salvar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva update(Reserva reserva) {
        Reserva salvo = reservaRepository.findById(reserva.getId()).orElseThrow(()->
                new RuntimeException("Reserva não encontrada"));;
        salvo.setDataReserva(reserva.getDataReserva());
        salvo.setStatus(reserva.getStatus());
        salvo.setCliente(reserva.getCliente());
        salvo.setPacote(reserva.getPacote());
        salvo.setPagamento(reserva.getPagamento());
        return reservaRepository.save(reserva);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
