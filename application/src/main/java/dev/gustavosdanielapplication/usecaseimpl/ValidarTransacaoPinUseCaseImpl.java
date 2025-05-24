package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.ValidarTransacaoPinUseCase;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.exception.TransferenciaException;

public class ValidarTransacaoPinUseCaseImpl implements ValidarTransacaoPinUseCase {
    @Override
    public Boolean validar(TransicaoPin transicaoPin) throws TransferenciaException {
        return null;
    }
}
