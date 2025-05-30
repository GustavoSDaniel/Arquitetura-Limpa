package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.TransferirGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.exception.*;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class TransferirUseCaseImpl implements TransferirUseCase {

    private BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase;
    private ValidarTransacaoUseCase validarTransacaoUseCase;
    private CriarTransicaoUseCase criarTransicaoUseCase;
    private TransferirGateway transferirGateway;
    private UsuarioNotificacaoUseCase usuarioNotificacaoUseCase;
    private ValidarTransacaoPinUseCase validarTransacaoPinUseCase;

    public TransferirUseCaseImpl(BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase, CriarTransicaoUseCase criarTransicaoUseCase, TransferirGateway transferirGateway, ValidarTransacaoUseCase validarTransacaoUseCase, UsuarioNotificacaoUseCase usuarioNotificacaoUseCase, ValidarTransacaoPinUseCase validarTransacaoPinUseCase) {
        this.buscarCarteiraCPFUseCase = buscarCarteiraCPFUseCase;
        this.criarTransicaoUseCase = criarTransicaoUseCase;
        this.transferirGateway = transferirGateway;
        this.validarTransacaoUseCase = validarTransacaoUseCase;
        this.usuarioNotificacaoUseCase = usuarioNotificacaoUseCase;
        this.validarTransacaoPinUseCase = validarTransacaoPinUseCase;
    }

    @Override
    public Boolean tranferir(String deCPF, String paraCPF, BigDecimal valor, String pin) throws Exception {
        Carteira de = buscarCarteiraCPFUseCase.findBayCPFValido(deCPF);
        Carteira para = buscarCarteiraCPFUseCase.findBayCPFValido(paraCPF);

        de.tranferir(valor);
        para.receberTransferencia(valor);

        validarTransacaoPinUseCase.validar(de.getTransicaoPin());

        Transicao transferir = criarTransicaoUseCase.criar(new Transicao(de, para, valor));

        validarTransacaoUseCase.validar(transferir);

        if (!transferirGateway.transicao(transferir)){// CASO A TRANSFERENCIA NÃO SEJA REALIZADA
            throw new InternalServerErrorException(ErrorCodeEnum.TRAN0001.getMensagem(), ErrorCodeEnum.TRAN0001.getCodego());
        };

        if (!usuarioNotificacaoUseCase.notificar(transferir, para.getUsuario().getEmail())){

            throw new NotificacaoException(ErrorCodeEnum.NO0001.getMensagem(), ErrorCodeEnum.NO0001.getCodego());
        }

        return true;
    }// VALIDANDO SE EXISTE OS NUMEROS DE CPF
}
