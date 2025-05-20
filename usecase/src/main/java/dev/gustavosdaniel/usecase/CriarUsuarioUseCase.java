package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.EmailException;
import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.ValidandoCPFException;

public interface CriarUsuarioUseCase {

    void criar(Usuario usuario, String pin) throws ValidandoCPFException, EmailException, TransicaoPinException;
}
