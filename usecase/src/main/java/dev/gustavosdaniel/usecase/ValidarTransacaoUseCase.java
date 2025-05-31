package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.TransferenciaException;

import java.math.BigDecimal;

public interface ValidarTransacaoUseCase {

    Boolean validar(Transicao transicao) throws TransferenciaException;


}
