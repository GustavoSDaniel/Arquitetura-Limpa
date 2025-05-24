package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.*;

import java.math.BigDecimal;

public interface TransferirUseCase {

    Boolean tranferir(String deCPF, String paraCPF, BigDecimal valor, String pin) throws InternalServerErrorException, TransferenciaException, NotFoundException, NotificacaoException, PinException;
}
