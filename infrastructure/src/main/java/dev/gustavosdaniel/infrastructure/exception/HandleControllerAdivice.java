package dev.gustavosdaniel.infrastructure.exception;

import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.dto.response.ErroValidado;
import dev.gustavosdaniel.infrastructure.dto.response.ErrorResponse;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice //componente global que lida com exceções, validações e model attributes
public class HandleControllerAdivice {

    @ExceptionHandler(MethodArgumentNotValidException.class) //para capturar e tratar exceções de forma local
    public ResponseEntity<BaseResponse<ErroValidado>> handleMethodArgumentNotValidException (MethodArgumentNotValidException e, WebRequest webRequest){
        var erro = new ErrorResponse(
                ErrorCodeEnum.NO0002.getMensagem(),
                ErrorCodeEnum.NO0002.getCodego(),
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new ErroValidado(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList()) //código está processando erros de validação e transformando-os em uma lista de objetos
        );

        return new ResponseEntity<>(BaseResponse.<ErroValidado>builder().success(false).errorResponse(erro).build(),HttpStatus.BAD_REQUEST );
        //construindo uma resposta padronizada para erros de validação
    }
}
