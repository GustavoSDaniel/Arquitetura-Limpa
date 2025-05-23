package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.exception.AutentificacaoException;

public interface AutentificarUsuarioUseCase {

    Boolean autentificar(String nomeUssuario, String senha) throws AutentificacaoException;
}
