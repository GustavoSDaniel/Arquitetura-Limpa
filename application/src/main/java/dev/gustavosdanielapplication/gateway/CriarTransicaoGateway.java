package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Transicao;

public interface CriarTransicaoGateway {

    Transicao criar(Transicao transicao) throws Exception;
}
