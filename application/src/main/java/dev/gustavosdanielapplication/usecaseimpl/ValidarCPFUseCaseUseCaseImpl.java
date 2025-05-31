package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.ValidarCPFUseCase;
import dev.gustavosdanielapplication.gateway.ValidarCPFUseCaseGatewway;
import dev.gustavosdanielcore.exception.ValidandoCPFException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class ValidarCPFUseCaseUseCaseImpl implements ValidarCPFUseCase {

    final private ValidarCPFUseCaseGatewway validarCPFUseCaseGatewway;

    public ValidarCPFUseCaseUseCaseImpl(ValidarCPFUseCaseGatewway validarCPFUseCaseGatewway) {
        this.validarCPFUseCaseGatewway = validarCPFUseCaseGatewway;
    }

    @Override
    public Boolean validarCPF(String cpfValidado) throws ValidandoCPFException {

        if (!validarCPFUseCaseGatewway.validandoCPF(cpfValidado)){
            throw new ValidandoCPFException(ErrorCodeEnum.ON0002.getMensagem(), ErrorCodeEnum.ON0002.getCodego());
        }// SE O CPF NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        return true;
    }
}
