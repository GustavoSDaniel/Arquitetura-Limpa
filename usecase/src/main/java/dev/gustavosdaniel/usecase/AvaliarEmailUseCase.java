package dev.gustavosdaniel.usecase;

import dev.gustavosdanielcore.exception.EmailException;

public interface AvaliarEmailUseCase {

    Boolean emailValidado(String email) throws EmailException;
}
