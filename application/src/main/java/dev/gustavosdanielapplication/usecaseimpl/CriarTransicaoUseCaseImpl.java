package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.CriarTransicaoUseCase;
import dev.gustavosdanielapplication.gateway.CriarTransicaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class CriarTransicaoUseCaseImpl implements CriarTransicaoUseCase {

    private CriarTransicaoGateway criarTransicaoGateway;

    @Override
    public Transicao criar(Transicao transicao) throws TransferenciaException {

        Transicao salvarTransacao = criarTransicaoGateway.criar(transicao);

        if (salvarTransacao == null){
            throw  new TransferenciaException(ErrorCodeEnum.TRAN0001.getMensagem(), ErrorCodeEnum.TRAN0001.getCodego());
        }
        return salvarTransacao;
    }
}
