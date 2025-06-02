package dev.gustavosdaniel.infrastructure.dto.request;


import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUsuarioRequest (

        @NotBlank String email,
        @NotBlank String senha,
        @NotBlank String numeroCPF,
        @NotBlank String nomeCompleto,
        @NotNull TipoUsuarioEnum tipoUsuarioEnum,
        @NotBlank String pin
){

}
