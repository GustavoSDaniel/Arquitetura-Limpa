package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Usuario;

public interface BuscarUsuarioCPFUseCase {

    Usuario fundBayValidandoCPF(String validandoCPF);
}
