package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.TransferenciaException;

public interface CriarTransicaoUseCase {

    Transicao criar(Transicao transicao) throws Exception;
}
