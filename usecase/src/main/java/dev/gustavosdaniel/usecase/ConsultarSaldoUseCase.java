package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Carteira;

import java.math.BigDecimal;

public interface ConsultarSaldoUseCase {

    BigDecimal consultar(String numeroCPF) throws Exception;
}
