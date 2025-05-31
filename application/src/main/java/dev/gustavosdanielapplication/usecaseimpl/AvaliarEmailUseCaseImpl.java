package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.AvaliarEmailUseCase;
import dev.gustavosdanielapplication.gateway.AvaliarEmailUseCaseGateway;
import dev.gustavosdanielcore.exception.EmailException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class AvaliarEmailUseCaseImpl implements AvaliarEmailUseCase {
    final private AvaliarEmailUseCaseGateway avaliarEmailUseCaseGateway;

    public AvaliarEmailUseCaseImpl(AvaliarEmailUseCaseGateway avaliarEmailUseCaseGateway) {
        this.avaliarEmailUseCaseGateway = avaliarEmailUseCaseGateway;
    }//INJEÇÃO DE DEPENDENCIAS

    @Override
    public Boolean emailValidado(String email) throws EmailException {

        if (!avaliarEmailUseCaseGateway.avaliarEmail(email)){
            throw new EmailException(ErrorCodeEnum.EMA0001.getMensagem(), ErrorCodeEnum.EMA0001.getCodego());
        }// SE O EMAIL NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        return true;
    }
}
