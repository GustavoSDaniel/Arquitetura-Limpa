package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.*;

import java.math.BigDecimal;

public interface TransferirUseCase {

    Boolean tranferir(Transicao transicao) throws Exception;
}
