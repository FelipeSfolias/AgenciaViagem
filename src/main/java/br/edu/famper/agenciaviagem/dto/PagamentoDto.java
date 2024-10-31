package br.edu.famper.agenciaviagem.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagamentoDto {

    @Schema(description = "Data do Pagamento", example = "2024-01-05")
    private String dataPagamento;

    @Schema(description = "Valor do Pagamento", example = "1500.00")
    private Double valor;

    @Schema(description = "Método de Pagamento", example = "Cartão de Crédito", maxLength = 50)
    private String metodoPagamento;

    @Schema(description = "ID da Reserva", example = "1")
    private Long reservaId;
}
