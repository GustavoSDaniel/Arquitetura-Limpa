package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Transicao;

public interface ValidarTransacaoGateway {

    Boolean validar(Transicao transicao);
}
