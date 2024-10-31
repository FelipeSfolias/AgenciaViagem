package br.edu.famper.agenciaviagem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDto {

    @Schema(description = "Data da Reserva", example = "2024-01-01")
    private String dataReserva;

    @Schema(description = "Status da Reserva", example = "Confirmada", maxLength = 50)
    private String status;

    @Schema(description = "ID do Cliente", example = "1")
    private Long clienteId;

    @Schema(description = "ID do Pacote de Viagem", example = "1")
    private Long pacoteViagemId;
}
