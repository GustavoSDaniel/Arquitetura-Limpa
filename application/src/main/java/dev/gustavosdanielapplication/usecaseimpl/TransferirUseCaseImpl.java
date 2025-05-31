package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.TransferirGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.*;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class TransferirUseCaseImpl implements TransferirUseCase {


    private TransferirGateway transferirGateway;


    public TransferirUseCaseImpl(TransferirGateway transferirGateway) {
        this.transferirGateway = transferirGateway;

    }

    @Override
    public Boolean tranferir(Transicao transicao) throws Exception {

        transicao.getDaCarteira().tranferir(transicao.getValor());
        transicao.getParaCarteira().receberTransferencia(transicao.getValor());

        if (!transferirGateway.transicao(transicao)) {// CASO A TRANSFERENCIA NÃO SEJA REALIZADA
            throw new InternalServerErrorException(ErrorCodeEnum.TRAN0001.getMensagem(), ErrorCodeEnum.TRAN0001.getCodego());
        }
        ;

        return true;
    }// VALIDANDO SE EXISTE OS NUMEROS DE CPF

}
