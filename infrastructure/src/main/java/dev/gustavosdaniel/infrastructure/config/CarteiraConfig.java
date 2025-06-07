package dev.gustavosdaniel.infrastructure.config;

import dev.gustavosdaniel.infrastructure.service.AtualizarTransicaoPinUseCaseImpl;
import dev.gustavosdaniel.usecase.*;
import dev.gustavosdanielapplication.gateway.*;
import dev.gustavosdanielapplication.usecaseimpl.*;
import dev.gustavosdanielcore.domain.TransicaoPin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarteiraConfig {

    //conectando as implementações concretas com suas respectivas interfaces e gateways (portas de entrada para infraestrutura/externos)

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
    public CriarTransicaoUseCase criarTransicaoUseCase(CriarTransicaoGateway criarTransicaoGateway) {
        return new CriarTransicaoUseCaseImpl(criarTransicaoGateway);
    }

    @Bean
    public UsuarioNotificacaoUseCase usuarioNotificacaoUseCase(UsuarioNotificacaoGateway usuarioNotificacaoGateway) {
        return new UsuarioNotificacaoUseCaseImpl(usuarioNotificacaoGateway);
    }

    @Bean
    public AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase(){
        return  new AtualizarTransicaoPinUseCase(){
            @Override
            public TransicaoPin atualizar(TransicaoPin transicaoPin) {
                return null;
            }
        };
    }

    @Bean
    public ValidarTransacaoPinUseCase validarTransacaoPinUseCase(ValidarTransacaoPinGateway validarTransacaoPinGateway, AtualizarTransicaoPinUseCase atualizarTransicaoPinUseCase) {
        return new ValidarTransacaoPinUseCaseImpl(validarTransacaoPinGateway, atualizarTransicaoPinUseCase);
    }

    @Bean
    public TransferirUseCase transacaoUseCase(TransferirGateway transferirGateway){
        return new TransferirUseCaseImpl( transferirGateway) {
        };
    }
}
