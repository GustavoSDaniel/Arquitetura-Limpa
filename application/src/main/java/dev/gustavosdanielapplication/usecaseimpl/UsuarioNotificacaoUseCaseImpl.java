package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.UsuarioNotificacaoUseCase;
import dev.gustavosdanielapplication.gateway.UsuarioNotificacaoGateway;
import dev.gustavosdanielcore.domain.Transicao;

public class UsuarioNotificacaoUseCaseImpl implements UsuarioNotificacaoUseCase {

    private UsuarioNotificacaoGateway usuarioNotificacaoGateway;

    public UsuarioNotificacaoUseCaseImpl(UsuarioNotificacaoGateway usuarioNotificacaoGateway) {
        this.usuarioNotificacaoGateway = usuarioNotificacaoGateway;
    }

    @Override
    public Boolean notificar(Transicao transicao, String email) {
        return usuarioNotificacaoGateway.notificacao(transicao, email);
    }
}
