package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.AvaliarEmailUseCase;
import dev.gustavosdanielapplication.gateway.AvaliarEmailUseCaseGateway;

public class AvaliarEmailUseCaseImpl implements AvaliarEmailUseCase {
    private AvaliarEmailUseCaseGateway avaliarEmailUseCaseGateway;

    public AvaliarEmailUseCaseImpl(AvaliarEmailUseCaseGateway avaliarEmailUseCaseGateway) {
        this.avaliarEmailUseCaseGateway = avaliarEmailUseCaseGateway;
    }//INJEÇÃO DE DEPENDENCIAS

    @Override
    public Boolean emailValidado(String email) {
        return avaliarEmailUseCaseGateway.avaliarEmail(email);
    }
}
