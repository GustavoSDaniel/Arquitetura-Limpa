package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;

public interface UsuarioNotificacaoUseCase {

    Boolean notificar(Transicao transicao, String email);
}
