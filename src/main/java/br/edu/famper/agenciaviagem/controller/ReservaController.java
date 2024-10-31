package br.edu.famper.agenciaviagem.controller;

import br.edu.famper.agenciaviagem.dto.ReservaDto;
import br.edu.famper.agenciaviagem.service.ReservaService;
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
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "reserva", description = "Operações para reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obter todas as reservas", description = "Busca todas as reservas no banco de dados e retorna como um JSON Array")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado")
    })
    public List<ReservaDto> getAllReservas() {
        log.info("Buscando todas as reservas");
        return reservaService.getAllReservas();
    }
}
