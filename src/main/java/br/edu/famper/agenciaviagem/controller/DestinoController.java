package br.edu.famper.agenciaviagem.controller;


import br.edu.famper.agenciaviagem.service.DestinoService;
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
@RequestMapping("/api/viagem")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "destino", description = "Operações para destinos")
public class DestinoController {

    private final DestinoService destinoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obter todos os destinos", description = "Busca todos os destinos no banco de dados e retorna como um JSON Array")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado")
    })
    public List<DestinoDto> getAllDestinos() {
        log.info("Buscando todos os destinos");
        return destinoService.getAllDestinos();
    }
}
