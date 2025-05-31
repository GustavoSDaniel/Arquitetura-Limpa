package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.exception.ValidandoCPFException;

public interface ValidarCPFUseCase {

    Boolean validarCPF(String cpfValidado) throws ValidandoCPFException;

}
