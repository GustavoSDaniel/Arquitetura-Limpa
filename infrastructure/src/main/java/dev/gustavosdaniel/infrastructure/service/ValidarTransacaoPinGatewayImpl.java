package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.entity.TransicaoPinEntity;
import dev.gustavosdaniel.infrastructure.mapper.TransicaoPinMapper;
import dev.gustavosdaniel.infrastructure.repository.TransacaoPinEntityRepository;
import dev.gustavosdaniel.usecase.AtualizarTransicaoPinUseCase;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoPinGateway;
import dev.gustavosdanielcore.domain.TransicaoPin;
import org.springframework.stereotype.Service;

@Service
public class ValidarTransacaoPinGatewayImpl implements ValidarTransacaoPinGateway {
    // AS INGREÇÕES DE DEPENDENCIA SÃO DO MAPPER E DO REPOSITORRY

    private TransacaoPinEntityRepository transacaoPinEntityRepository;
    private AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase;

    public ValidarTransacaoPinGatewayImpl(TransacaoPinEntityRepository transacaoPinEntityRepository, TransicaoPinMapper transicaoPinMapper, AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase) {
        this.transacaoPinEntityRepository = transacaoPinEntityRepository;
        this.atualizarTransicaoPinUseCase = atualizarTransicaoPinUseCase;
    }

    @Override
    public Boolean validar(TransicaoPin transicaoPin) {

        var transicaoPinSalvo = transacaoPinEntityRepository.findById(transicaoPin.getId());

        if (transicaoPinSalvo.isEmpty()) {

        }

        if (transicaoPinSalvo.get().getPin() != transicaoPin.getPin()){
            return false;
        }

        return true;
    }
}
