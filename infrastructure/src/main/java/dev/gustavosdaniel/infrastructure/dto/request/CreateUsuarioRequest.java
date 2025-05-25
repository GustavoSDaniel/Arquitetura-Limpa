package dev.gustavosdaniel.infrastructure.dto.request;


import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;

public record CreateUsuarioRequest (

        String email,
        String senha,
        String numeroCPF,
        String nomeCompleto,
        TipoUsuarioEnum tipoUsuarioEnum,
        String pin
){

}
