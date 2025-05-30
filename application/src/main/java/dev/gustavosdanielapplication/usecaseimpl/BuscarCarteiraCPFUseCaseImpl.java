package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.BuscarCarteiraCPFUseCase;
import dev.gustavosdanielapplication.gateway.BuscarCarteiraCPFGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.exception.NotFoundException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class BuscarCarteiraCPFUseCaseImpl implements BuscarCarteiraCPFUseCase {

    private BuscarCarteiraCPFGateway buscarCarteiraCPFGateway;

    public BuscarCarteiraCPFUseCaseImpl(BuscarCarteiraCPFGateway buscarCarteiraCPFGateway) {
        this.buscarCarteiraCPFGateway = buscarCarteiraCPFGateway;
    }

    @Override
    public Carteira findBayCPFValido(String cpfValidado) throws Exception {

        Carteira carteira = buscarCarteiraCPFGateway.findByNumeroCPF(cpfValidado);

        if (carteira == null) {
            throw new NotFoundException(ErrorCodeEnum.NOT0001.getMensagem(), ErrorCodeEnum.NOT0001.getCodego());
        }

        return carteira;
    }
}
