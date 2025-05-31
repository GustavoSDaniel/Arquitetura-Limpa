package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdanielapplication.gateway.UsuarioNotificacaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import org.springframework.stereotype.Service;

@Service
public class UsuarioNotificacaoGatewayImpl implements UsuarioNotificacaoGateway {
    @Override
    public Boolean notificacao(Transicao transicao, String email) {
        return true;
    }
}
