package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.CriarTransicaoUseCase;
import dev.gustavosdanielapplication.gateway.CriarTransicaoGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class CriarTransicaoUseCaseImpl implements CriarTransicaoUseCase {

    final private CriarTransicaoGateway criarTransicaoGateway;

    public CriarTransicaoUseCaseImpl(CriarTransicaoGateway criarTransicaoGateway) {
        this.criarTransicaoGateway = criarTransicaoGateway;
    }

    @Override
    public Transicao criar(Carteira deCarteira, Carteira paraCarteira, BigDecimal valor) throws Exception {

        Transicao transicao = new Transicao(deCarteira, paraCarteira, valor);
        Transicao salvarTransacao = criarTransicaoGateway.criar(transicao);

        if (salvarTransacao == null){
            throw  new TransferenciaException(ErrorCodeEnum.TRAN0001.getMensagem(), ErrorCodeEnum.TRAN0001.getCodego());
        }
        return salvarTransacao;
    }
}
