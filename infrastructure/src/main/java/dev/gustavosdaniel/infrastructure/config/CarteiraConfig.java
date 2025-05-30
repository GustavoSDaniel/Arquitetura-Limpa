package dev.gustavosdaniel.infrastructure.config;

import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.BuscarCarteiraCPFGateway;
import dev.gustavosdanielapplication.gateway.TransferirGateway;
import dev.gustavosdanielapplication.gateway.ValidarTransacaoGateway;
import dev.gustavosdanielapplication.usecaseimpl.BuscarCarteiraCPFUseCaseImpl;
import dev.gustavosdanielapplication.usecaseimpl.ConsultarSaldoUseCaseImpl;
import dev.gustavosdanielapplication.usecaseimpl.ValidarTransacaoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarteiraConfig {

    @Bean
    public BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase(BuscarCarteiraCPFGateway buscarCarteiraCPFGateway) {
        return new BuscarCarteiraCPFUseCaseImpl( buscarCarteiraCPFGateway);
    }

    @Bean
    public ConsultarSaldoUseCase consultarSaldoUseCase(BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase) {
        return new ConsultarSaldoUseCaseImpl(buscarCarteiraCPFUseCase);
    }

    @Bean
    public ValidarTransacaoUseCase validarTransacaoUseCase(ValidarTransacaoGateway validarTransacaoGateway) {
        return new ValidarTransacaoUseCaseImpl(validarTransacaoGateway);
    }


    @Bean
    public ValidarTransacaoUseCase transacaoUseCase(BuscarCarteiraCPFUseCase buscarCarteiraCPFUseCase, CriarTransicaoUseCase criarTransicaoUseCase, TransferirGateway transferirGateway, ValidarTransacaoUseCase validarTransacaoUseCase, UsuarioNotificacaoUseCase usuarioNotificacaoUseCase, ValidarTransacaoPinUseCase validarTransacaoPinUseCase(){
        return new ValidarTransacaoUseCaseImpl(transacaoUseCaseImpl(buscarCarteiraCPFUseCase,criarTransicaoUseCase,transferirGateway,validarTransacaoUseCase,usuarioNotificacaoUseCase,validarTransacaoPinUseCase));
    }
}
