package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.ValidarTransacaoUseCase;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.InternalServerErrorException;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class ValidarTransacaoUseCaseImpl implements ValidarTransacaoUseCase {

    private ValidarTransacaoGateway validarTransacaoGateway;

    public ValidarTransacaoUseCaseImpl(ValidarTransacaoGateway validarTransacaoGateway) {
        this.validarTransacaoGateway = validarTransacaoGateway;
    }


    @Override
    public Boolean validar(Transicao transicao) throws TransferenciaException {

        if (!validarTransacaoGateway.validar(transicao)){
            throw new TransferenciaException(ErrorCodeEnum.TRAN0002.getMensagem(), ErrorCodeEnum.TRAN0002.getCodego());
        }

        return true;
    }
}
