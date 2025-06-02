package dev.gustavosdaniel.infrastructure.dto.response;


import java.util.List;

public record ErrorResponse(
        String mensagem,
        String codego,
        List<ErroValidado> erroValidadoList
        ) {

}
