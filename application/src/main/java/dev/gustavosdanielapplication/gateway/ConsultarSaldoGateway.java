package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.Carteira;

import java.math.BigDecimal;

public interface ConsultarSaldoGateway {

    BigDecimal consultarSaldo(Carteira carteira);
}
