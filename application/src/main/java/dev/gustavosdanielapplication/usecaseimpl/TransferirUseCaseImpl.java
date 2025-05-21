package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.BuscarCarteiraCPFUseCase;
import dev.gustavosdaniel.usecase.TransferirUseCase;
import dev.gustavosdaniel.usecase.ValidarTransacaoUseCase;
import dev.gustavosdanielcore.domain.Carteira;

import java.math.BigDecimal;

public class TransferirUseCaseImpl implements TransferirUseCase {

    private BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase;
    private ValidarTransacaoUseCase validarTransacaoUseCase;

    public TransferirUseCaseImpl(BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase, ValidarTransacaoUseCase validarTransacaoUseCase) {
        this.buscarCarteiraCPFUseCase = buscarCarteiraCPFUseCase;
        this.validarTransacaoUseCase = validarTransacaoUseCase;
    }

    @Override
    public Boolean tranferir(String deCPF, String paraCPF, BigDecimal valor) {
        Carteira de = buscarCarteiraCPFUseCase.fundBayValidandoCPF(deCPF);
        Carteira para = buscarCarteiraCPFUseCase.fundBayValidandoCPF(paraCPF);

        validarTransacaoUseCase.validar()

        return null;
    }// VALIDANDO SE EXISTE OS NUMEROS DE CPF
}
