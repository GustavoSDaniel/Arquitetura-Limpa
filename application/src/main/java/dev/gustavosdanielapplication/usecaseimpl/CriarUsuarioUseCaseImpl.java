package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.EmailException;
import dev.gustavosdanielcore.exception.InternalServerErrorException;
import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.ValidandoCPFException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class CriarUsuarioUseCaseImpl implements CriarUsuarioUseCase {

    private ValidarCPFUseCase validarCPFUseCase;
    private AvaliarEmailUseCase avaliarEmailUseCase;
    private CriarUsuarioGateway criarUsuarioGateway;


    public CriarUsuarioUseCaseImpl(ValidarCPFUseCase validarCPFUseCase, AvaliarEmailUseCase avaliarEmailUseCase, CriarUsuarioGateway criarUsuarioGateway) {
        this.validarCPFUseCase = validarCPFUseCase;
        this.avaliarEmailUseCase = avaliarEmailUseCase;
        this.criarUsuarioGateway = criarUsuarioGateway;

    } //INJEÇÃO DE DEPENDENCIAS

    @Override
    public void criar(Usuario usuario, String pin) throws ValidandoCPFException, EmailException, TransicaoPinException, InternalServerErrorException {
        if (!validarCPFUseCase.validarCPF(usuario.getTaxNumber().getValue())){
            throw new ValidandoCPFException(ErrorCodeEnum.ON0002.getMensagem(), ErrorCodeEnum.ON0002.getCodego());
        }// SE O CPF NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        if (!avaliarEmailUseCase.emailValidado(usuario.getEmail())){
            throw new EmailException(ErrorCodeEnum.EMA0001.getMensagem(), ErrorCodeEnum.EMA0001.getCodego());
        }// SE O EMAIL NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        if (!criarUsuarioGateway.criar(usuario, new Carteira(usuario, BigDecimal.ZERO), new TransicaoPin(pin, usuario))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMensagem(), ErrorCodeEnum.ON0004.getCodego());
        }// VAI CRIAR DE UMA VEIS SÓ TANTO O USUARIO QUANTO A CARTEIRA E O PIN


    }
}
