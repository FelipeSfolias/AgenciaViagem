package br.edu.famper.agenciaviagem.service;


import br.edu.famper.agenciaviagem.dto.PagamentoDto;
import br.edu.famper.agenciaviagem.model.Pagamento;
import br.edu.famper.agenciaviagem.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoDto> getAllPagamentos() {
        return pagamentoRepository
                .findAll()
                .stream()
                .map(pagamento -> PagamentoDto
                        .builder()
                        .dataPagamento(pagamento.getDataPagamento())
                        .valor(pagamento.getValor())
                        .metodoPagamento(pagamento.getMetodoPagamento())
                        .reserva(pagamento.getReserva()
                        .build())
                .toList();
    }
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Optional<Pagamento> findById(Long id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento update(Pagamento pagamento) {
        Pagamento salvo = pagamentoRepository.findById(pagamento.getId()).orElseThrow(()->
                new RuntimeException("Pagamento não encontrado"));;
        salvo.setDataPagamento(pagamento.getDataPagamento());
        salvo.setValor(pagamento.getValor());
        salvo.setMetodoPagamento(pagamento.getMetodoPagamento());
        salvo.setReserva(pagamento.getReserva());

        return pagamentoRepository.save(pagamento);
    }

    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
