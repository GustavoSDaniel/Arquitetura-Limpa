package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.exception.PinException;
import dev.gustavosdanielcore.exception.TransferenciaException;

public interface ValidarTransacaoPinUseCase {

    Boolean validar(TransicaoPin transicaoPin) throws TransferenciaException, PinException;
}
