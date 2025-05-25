package dev.gustavosdaniel.infrastructure.dto.response;


import java.util.List;

public record ErrorResponse(
        String codego,
        String mensagem,
        List<ErroValidado> erroValidadoList
        ) {

}
