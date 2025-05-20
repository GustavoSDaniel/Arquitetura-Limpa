package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.TransicaoPin;
import dev.gustavosdanielcore.domain.Usuario;
import dev.gustavosdanielcore.exception.EmailException;
import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.ValidandoCPFException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;

public class CriarUsuarioUseCaseImpl implements CriarUsuarioUseCase {

    private ValidarCPFUseCase validarCPFUseCase;
    private AvaliarEmailUseCase avaliarEmailUseCase;
    private CriarUsuarioGateway criarUsuarioGateway;
    private CriarCarteiraUseCase criarCarteiraUseCase;
    private CriarTransicaoPinUseCase criarTransicaoPinUseCase;

    public CriarUsuarioUseCaseImpl(ValidarCPFUseCase validarCPFUseCase, AvaliarEmailUseCase avaliarEmailUseCase, CriarUsuarioGateway criarUsuarioGateway, CriarCarteiraUseCase criarCarteiraUseCase, CriarTransicaoPinUseCase criarTransicaoPinUseCase) {
        this.validarCPFUseCase = validarCPFUseCase;
        this.avaliarEmailUseCase = avaliarEmailUseCase;
        this.criarUsuarioGateway = criarUsuarioGateway;
        this.criarCarteiraUseCase = criarCarteiraUseCase;
        this.criarTransicaoPinUseCase = criarTransicaoPinUseCase;
    } //INJEÇÃO DE DEPENDENCIAS

    @Override
    public void criar(Usuario usuario, String pin) throws ValidandoCPFException, EmailException, TransicaoPinException {
        if (!validarCPFUseCase.validarCPF(usuario.getTaxNumber().getValue())){
            throw new ValidandoCPFException(ErrorCodeEnum.ON0002.getMensagem(), ErrorCodeEnum.ON0002.getCodego());
        }// SE O CPPF NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        if (!avaliarEmailUseCase.emailValidado(usuario.getEmail())){
            throw new EmailException(ErrorCodeEnum.EMA0001.getMensagem(), ErrorCodeEnum.EMA0001.getCodego());
        }// SE O EMAIL NÃO FOR VALIDO VAI LANÇAR ESSA EXEÇÃO

        Usuario salvarUsuario = criarUsuarioGateway.criar(usuario);

        criarCarteiraUseCase.criar(new Carteira(salvarUsuario, BigDecimal.ZERO));
        criarTransicaoPinUseCase.criar(new TransicaoPin(pin, salvarUsuario));

    }
}
