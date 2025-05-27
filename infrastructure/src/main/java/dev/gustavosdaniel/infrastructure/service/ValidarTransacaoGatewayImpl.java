package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.repository.TransacaoPinEntityRepository;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import org.springframework.stereotype.Service;

@Service
public class ValidarTransacaoGatewayImpl implements ValidarTransacaoGateway {

    private TransacaoPinEntityRepository transacaoPinEntityRepository;

    public ValidarTransacaoGatewayImpl(TransacaoPinEntityRepository transacaoPinEntityRepository) {
        this.transacaoPinEntityRepository = transacaoPinEntityRepository;
    }

    @Override
    public Boolean validar(Transicao transicao) {

        return null;
    }
}
