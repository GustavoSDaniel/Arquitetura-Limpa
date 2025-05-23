package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.InternalServerErrorException;
import dev.gustavosdanielcore.exception.NotFoundException;
import dev.gustavosdanielcore.exception.NotificacaoException;
import dev.gustavosdanielcore.exception.TransferenciaException;

import java.math.BigDecimal;

public interface TransferirUseCase {

    Boolean tranferir(String deCPF, String paraCPF, BigDecimal valor) throws InternalServerErrorException, TransferenciaException, NotFoundException, NotificacaoException;
}
