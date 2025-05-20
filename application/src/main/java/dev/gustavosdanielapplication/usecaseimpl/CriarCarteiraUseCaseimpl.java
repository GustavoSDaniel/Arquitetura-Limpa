package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.CriarCarteiraUseCase;
import dev.gustavosdanielapplication.gateway.CriarCateiraGateway;
import dev.gustavosdanielcore.domain.Carteira;

public class CriarCarteiraUseCaseimpl implements CriarCarteiraUseCase {

    private CriarCateiraGateway criarCateiraGateway;

    public CriarCarteiraUseCaseimpl(CriarCateiraGateway criarCateiraGateway) {
        this.criarCateiraGateway = criarCateiraGateway;
    }//INJEÇÃO DE DEPENDENCIAS

    @Override
    public void criar(Carteira carteira) {
        criarCateiraGateway.criar(carteira);
    }
}
