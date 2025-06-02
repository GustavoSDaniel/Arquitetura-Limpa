package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.client.ValidarApiClient;
import dev.gustavosdaniel.infrastructure.repository.TransacaoPinEntityRepository;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import org.springframework.stereotype.Service;

@Service
public class ValidarTransacaoGatewayImpl implements ValidarTransacaoGateway {

    private final ValidarApiClient validarApiClient;

    public ValidarTransacaoGatewayImpl(ValidarApiClient validarApiClient) {
        this.validarApiClient = validarApiClient;
    }

    @Override
    public Boolean validar(Transicao transicao) {
        var response = validarApiClient.validar();
        if (response == null) {
            return false;
        }
        return response.success();
    }
}
