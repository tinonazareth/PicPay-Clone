package br.com.edu.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransacaoDTO {

    @NotBlank
    private String codigo;

    @NotNull
    private UsuarioDTO origem;

    @NotNull
    private UsuarioDTO destino;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private Double valor;

    private CartaoCreditoDTO cartaoCredito;

    private Boolean isCartaoCredito = false;
}
