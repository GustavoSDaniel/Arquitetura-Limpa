package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.AtualizarTransicaoPinUseCase;
import dev.gustavosdaniel.usecase.ValidarTransacaoPinUseCase;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoPinGateway;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.exception.PinException;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import javax.xml.stream.events.EntityReference;

public class ValidarTransacaoPinUseCaseImpl implements ValidarTransacaoPinUseCase {

    private ValidarTransacaoPinGateway validarTransacaoPinGateway;
    private AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase;

    public ValidarTransacaoPinUseCaseImpl(ValidarTransacaoPinGateway validarTransacaoPinGateway, AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase) {
        this.validarTransacaoPinGateway = validarTransacaoPinGateway;
        this.atualizarTransicaoPinUseCase = atualizarTransicaoPinUseCase;
    }

    @Override
    public Boolean validar(TransicaoPin transicaoPin) throws PinException {

        if (transicaoPin.getBloqueado()) throw new PinException(ErrorCodeEnum.PIN0001.getMensagem(), ErrorCodeEnum.PIN0001.getCodego()); // SE JA ESTIVER BLOQUEADO ELE VAI ESTOURAR UMA EXCEÇÃO


        if (!validarTransacaoPinGateway.validar(transicaoPin)){
            transicaoPin.setQuantidadeDeTentativa();
           TransicaoPin transicaoAtualizada = atualizarTransicaoPinUseCase.atualizar(transicaoPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMensagem(transicaoAtualizada.getQuantidadeDeTentativa()), ErrorCodeEnum.PIN0002.getCodego());

        } // SE TIVER UMA TENTATIVA ELE VAI BLLOQUEAR, SE FOR MAIS DE UMA ELE VAI REDUZIR A QUANTIDADE DE TENTATIVA






        if (transicaoPin.getQuantidadeDeTentativa() < 3){
            transicaoPin.restaurarQuantidadeTentativa();
            atualizarTransicaoPinUseCase.atualizar(transicaoPin);
        }

        return null;
    }
}
