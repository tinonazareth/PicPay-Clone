package br.com.edu.picpayclone.dto;


import br.com.edu.picpayclone.enums.BandeiraCartao;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoCreditoDTO {

    @NotBlank
    private BandeiraCartao bandeira;

    @NotBlank
    private String codigoSeguranca;

    @NotBlank
    private String dataExpiracao;

    @NotBlank
    private String nomeTitular;

    private String numero;

    private String numeroToken;

    @NotNull
    private UsuarioDTO usuario;

    private Boolean isSalva = false;

}
