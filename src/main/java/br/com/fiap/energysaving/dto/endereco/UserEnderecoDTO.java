package br.com.fiap.energysaving.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserEnderecoDTO(

        @NotBlank
        @Schema(description = "Logradouro do endereço.", example = "Rua das Flores")
        String street,

        @NotBlank
        @Size(max = 20)
        @Schema(description = "Número do endereço.", example = "123")
        String number,

        @Schema(description = "Complemento do endereço.", example = "Apartamento 45")
        String complement,

        @NotBlank
        @Schema(description = "Cidade do endereço.", example = "São Paulo")
        String city,

        @NotBlank
        @Schema(description = "Estado do endereço.", example = "SP")
        String state,

        @NotBlank
        @Size(min = 8, max = 9)
        @Schema(description = "CEP do endereço.", example = "01234-567")
        String zipCode
) {

}