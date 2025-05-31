package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.TransferenciaException;

import java.math.BigDecimal;

public interface CriarTransicaoUseCase {

    Transicao criar(Carteira deCarteira, Carteira paraCarteira, BigDecimal valor) throws Exception;
}
