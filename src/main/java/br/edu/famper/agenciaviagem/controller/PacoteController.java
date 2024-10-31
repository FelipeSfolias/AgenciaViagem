package br.edu.famper.agenciaviagem.controller;

import br.edu.famper.agenciaviagem.service.PacoteService;
import br.edu.famper.agenciaviagem.dto.PacoteDto;
import br.edu.famper.agenciaviagem.service.PacoteService;
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
@RequestMapping("/api/agencia")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "pacote", description = "Operações para pacotes de viagem")
public class PacoteController {

    private final PacoteService pacoteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obter todos os pacotes de viagem",
            description = "Busca todos os pacotes de viagem no banco de dados e retorna como um JSON Array")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado")
    })
    public List<PacoteDto> getAllPacotes() {
        log.info("Buscando todos os pacotes de viagem");
        return pacoteService.getAllPacotes();
    }
}
