package br.edu.famper.agenciaviagem.controller;

import br.edu.famper.agenciaviagem.dto.PagamentoDto;
import br.edu.famper.agenciaviagem.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "pagamento", description = "Operações para pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obter todos os pagamentos", description = "Busca todos os pagamentos no banco de dados e retorna como um JSON Array")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado")
    })
    public List<PagamentoDto> getAllPagamentos() {
        log.info("Buscando todos os pagamentos");
        return pagamentoService.getAllPagamentos();
    }
}
