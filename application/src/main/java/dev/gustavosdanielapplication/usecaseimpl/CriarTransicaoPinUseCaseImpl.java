package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.CriarTransicaoPinUseCase;
import dev.gustavosdanielapplication.gateway.CriarTransicaoPinGateway;
import dev.gustavosdanielcore.domain.TransicaoPin;

public class CriarTransicaoPinUseCaseImpl implements CriarTransicaoPinUseCase {

    private CriarTransicaoPinGateway criarTransicaoPinGateway;

    public CriarTransicaoPinUseCaseImpl(CriarTransicaoPinGateway criarTransicaoPinGateway) {
        this.criarTransicaoPinGateway = criarTransicaoPinGateway;
    }//INJEÇÃO DE DEPENDENCIAS

    @Override
    public void criar(TransicaoPin transicaoPin) {
        criarTransicaoPinGateway.criar(transicaoPin);

    }
}
