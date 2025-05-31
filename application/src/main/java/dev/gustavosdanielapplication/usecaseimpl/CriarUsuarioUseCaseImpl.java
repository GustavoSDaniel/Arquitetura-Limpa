package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.InternalServerErrorException;
import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class CriarUsuarioUseCaseImpl implements CriarUsuarioUseCase {


    final private CriarUsuarioGateway criarUsuarioGateway;


    public CriarUsuarioUseCaseImpl(CriarUsuarioGateway criarUsuarioGateway) {

        this.criarUsuarioGateway = criarUsuarioGateway;

    } //INJEÇÃO DE DEPENDENCIAS

    @Override
    public void criar(Usuario usuario, String pin) throws TransicaoPinException, InternalServerErrorException {

        if (!criarUsuarioGateway.criar(usuario, new Carteira(usuario, BigDecimal.ZERO, new TransicaoPin(pin)))){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMensagem(), ErrorCodeEnum.ON0004.getCodego());
        }// VAI CRIAR DE UMA VEIS SÓ TANTO O USUARIO QUANTO A CARTEIRA E O PIN


    }
}
