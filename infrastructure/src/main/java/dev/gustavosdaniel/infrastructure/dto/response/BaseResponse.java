package dev.gustavosdaniel.infrastructure.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> { // T SIGNIFICA QUE É DO TIPO GENERICO QUE PODE RECEBER QUALQUER TIPO
    private Boolean success;
    private String mensagem;
    private T resultado;
    private ErrorResponse errorResponse;
}

// EXEMPLO DE COMO USAR O BUILDER nome("Maria")
//    .email("maria@email.com")
//    .senha("123456")
//    .build();