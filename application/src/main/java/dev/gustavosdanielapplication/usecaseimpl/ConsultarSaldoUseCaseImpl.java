package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.ConsultarSaldoUseCase;
import dev.gustavosdanielapplication.gateway.ConsultarSaldoGateway;
import dev.gustavosdanielcore.domain.Carteira;

import java.math.BigDecimal;

public class ConsultarSaldoUseCaseImpl implements ConsultarSaldoUseCase {

    private ConsultarSaldoGateway consultarSaldoGateway;

    public ConsultarSaldoUseCaseImpl(ConsultarSaldoGateway consultarSaldoGateway) {
        this.consultarSaldoGateway = consultarSaldoGateway;
    }



    @Override
    public BigDecimal consultar(Carteira carteira) {

        return consultarSaldoGateway.consultarSaldo(carteira);
    }
}
