package dev.gustavosdaniel.infrastructure.exception;

import dev.gustavosdaniel.infrastructure.dto.response.BaseResponse;
import dev.gustavosdaniel.infrastructure.dto.response.ErroValidado;
import dev.gustavosdaniel.infrastructure.dto.response.ErrorResponse;
import dev.gustavosdanielcore.exception.*;
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
        ErrorResponse erro = new ErrorResponse(
                ErrorCodeEnum.NO0002.getMensagem(),
                ErrorCodeEnum.NO0002.getCodego(),
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new ErroValidado(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList()) //código está processando erros de validação e transformando-os em uma lista de objetos
        );

        return new ResponseEntity<>(BaseResponse.<ErroValidado>builder().success(false).errorResponse(erro).build(),HttpStatus.BAD_REQUEST );
        //construindo uma resposta padronizada para erros de validação
    }

    @ExceptionHandler(AutentificacaoException.class)
    public ResponseEntity<BaseResponse<String>> handleAutentificacaoException(AutentificacaoException autentificacaoException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                autentificacaoException.getMessage(), autentificacaoException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<String>> handleBadRequestException(BadRequestException badRequestException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                badRequestException.getMessage(), badRequestException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<BaseResponse<String>> handleEmailException(EmailException emailException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                emailException.getMessage(), emailException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<String>> handleInternalServerErrorException(InternalServerErrorException internalServerErrorException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                internalServerErrorException.getMessage(), internalServerErrorException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<String>> handleNotFoundException(NotFoundException notFoundException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                notFoundException.getMessage(), notFoundException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotificacaoException.class)
    public ResponseEntity<BaseResponse<String>> handleNotificacaoException(NotificacaoException notificacaoException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                notificacaoException.getMessage(), notificacaoException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PinException.class)
    public ResponseEntity<BaseResponse<String>> handlePinException(PinException pinException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                pinException.getMessage(), pinException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(TransferenciaException.class)
    public ResponseEntity<BaseResponse<String>> handleTransferenciaException(TransferenciaException transferenciaException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                transferenciaException.getMessage(), transferenciaException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransicaoPinException.class)
    public ResponseEntity<BaseResponse<String>> handleTransicaoPinException(TransicaoPinException transicaoPinException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                transicaoPinException.getMessage(), transicaoPinException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidandoCPFException.class)
    public ResponseEntity<BaseResponse<String>> handleValidandoCPFException(ValidandoCPFException validandoCPFException, WebRequest webRequest){
        ErrorResponse erro = new ErrorResponse(
                validandoCPFException.getMessage(), validandoCPFException.getCodego(), null
        );

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).errorResponse(erro).build(), HttpStatus.BAD_REQUEST);
    }

}
