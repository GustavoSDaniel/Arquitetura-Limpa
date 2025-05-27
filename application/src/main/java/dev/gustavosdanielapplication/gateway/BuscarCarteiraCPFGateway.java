package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Carteira;

public interface BuscarCarteiraCPFGateway {

    Carteira findByNumeroCPF(String numeroCPF) throws Exception;
}
