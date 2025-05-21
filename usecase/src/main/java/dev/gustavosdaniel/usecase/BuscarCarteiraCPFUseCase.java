package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Usuario;

public interface BuscarCarteiraCPFUseCase {

    Carteira fundBayValidandoCPF(String validandoCPF);
}
