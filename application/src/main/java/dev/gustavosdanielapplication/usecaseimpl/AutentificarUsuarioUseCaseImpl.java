package dev.gustavosdanielapplication.usecaseimpl;

import dev.gustavosdaniel.usecase.AutentificarUsuarioUseCase;
import dev.gustavosdanielapplication.gateway.AutentificarUsuarioGateway;
import dev.gustavosdanielcore.exception.AutentificacaoException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

public class AutentificarUsuarioUseCaseImpl implements AutentificarUsuarioUseCase {

    final private AutentificarUsuarioGateway autentificarUsuarioGateway;

    public AutentificarUsuarioUseCaseImpl(AutentificarUsuarioGateway autentificarUsuarioGateway) {
        this.autentificarUsuarioGateway = autentificarUsuarioGateway;
    }

    @Override
    public Boolean autentificar(String nomeUssuario, String senha) throws AutentificacaoException {
        if (!autentificarUsuarioGateway.autenticar(nomeUssuario, senha)){
            throw new AutentificacaoException((ErrorCodeEnum.ATHN0002.getMensagem()), ErrorCodeEnum.ATHN0002.getCodego());
        }


        return true;
    }
}
