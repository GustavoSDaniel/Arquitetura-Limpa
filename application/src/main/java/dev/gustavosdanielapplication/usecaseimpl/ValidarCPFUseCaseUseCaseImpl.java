package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.ValidarCPFUseCase;
import dev.gustavosdanielapplication.gateway.ValidarCPFUseCaseGatewway;

public class ValidarCPFUseCaseUseCaseImpl implements ValidarCPFUseCase {

    private ValidarCPFUseCaseGatewway validarCPFUseCaseGatewway;

    public ValidarCPFUseCaseUseCaseImpl(ValidarCPFUseCaseGatewway validarCPFUseCaseGatewway) {
        this.validarCPFUseCaseGatewway = validarCPFUseCaseGatewway;
    }

    @Override
    public Boolean validarCPF(String cpfValidado) {
        return validarCPFUseCaseGatewway.validandoCPF(cpfValidado);
    }
}
