package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.BuscarCarteiraCPFUseCase;
import dev.gustavosdaniel.usecase.ConsultarSaldoUseCase;

import java.math.BigDecimal;

public class ConsultarSaldoUseCaseImpl implements ConsultarSaldoUseCase {

    final private BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase;

    public ConsultarSaldoUseCaseImpl(BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase) {
        this.buscarCarteiraCPFUseCase = buscarCarteiraCPFUseCase;
    }

    @Override
    public BigDecimal consultar(String numeroCPF) throws Exception {

        return buscarCarteiraCPFUseCase.findByCPFValido(numeroCPF).getSaldo();
    }

}
