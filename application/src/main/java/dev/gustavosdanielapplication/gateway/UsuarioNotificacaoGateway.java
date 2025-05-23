package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Transicao;

public interface UsuarioNotificacaoGateway {

    Boolean notificacao(Transicao transicao, String email);

}
