package dev.gustavosdanielapplication.gateway;

import dev.gustavosdanielcore.domain.TransicaoPin;

public interface ValidarTransacaoPinGateway {

    Boolean validar(TransicaoPin transicaoPin);


}
