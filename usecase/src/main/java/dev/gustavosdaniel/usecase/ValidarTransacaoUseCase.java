package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;

public interface ValidarTransacaoUseCase {

    Boolean validar(Transicao transicao);
}
