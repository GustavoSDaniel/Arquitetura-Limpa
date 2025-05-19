package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;

public interface NotificacaoUseCase {

    Boolean notificar(Transicao transicao, String email);
}
