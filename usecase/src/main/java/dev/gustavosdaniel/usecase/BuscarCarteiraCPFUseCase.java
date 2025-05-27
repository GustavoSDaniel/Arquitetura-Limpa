package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.NotFoundException;

public interface BuscarCarteiraCPFUseCase {

    Carteira fundBayCPFValido(String cpfValidado) throws Exception;
}
