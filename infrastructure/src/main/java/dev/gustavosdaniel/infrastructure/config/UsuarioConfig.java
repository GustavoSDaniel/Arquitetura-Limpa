package dev.gustavosdaniel.infrastructure.config;

import dev.gustavosdaniel.usecase.AvaliarEmailUseCase;
import dev.gustavosdaniel.usecase.CriarUsuarioUseCase;
import dev.gustavosdaniel.usecase.ValidarCPFUseCase;
import dev.gustavosdanielapplication.gateway.AvaliarEmailUseCaseGateway;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielapplication.gateway.ValidarCPFUseCaseGatewway;
import dev.gustavosdanielapplication.usecaseimpl.AvaliarEmailUseCaseImpl;
import dev.gustavosdanielapplication.usecaseimpl.CriarUsuarioUseCaseImpl;
import dev.gustavosdanielapplication.usecaseimpl.ValidarCPFUseCaseUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public ValidarCPFUseCase validarCPFUseCase(ValidarCPFUseCaseGatewway validarCPFUseCaseGatewway){
        return new ValidarCPFUseCaseUseCaseImpl(validarCPFUseCaseGatewway);
    }// ESSE BEAN SERVE PARA FALAR PARA O SPRING QUE ESSA INTERFACE DEVE INTERAGIR POIS COMO ELA ESTA EM UMA CAMADA MAIS PROFUNDA O SPRING NÃO IRIA RECONHECELO


@Bean
    public AvaliarEmailUseCase avaliarEmailUseCase(AvaliarEmailUseCaseGateway avaliarEmailUseCaseGateway) {
    return new AvaliarEmailUseCaseImpl(avaliarEmailUseCaseGateway);
    } // ESSE BEAN SERVE PARA FALAR PARA O SPRING QUE ESSA INTERFACE DEVE INTERAGIR POIS COMO ELA ESTA EM UMA CAMADA MAIS PROFUNDA O SPRING NÃO IRIA RECONHECELO



@Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(ValidarCPFUseCase validarCPFUseCase, AvaliarEmailUseCase avaliarEmailUseCase, CriarUsuarioGateway criarUsuarioGateway){
        return new CriarUsuarioUseCaseImpl(validarCPFUseCase,avaliarEmailUseCase, criarUsuarioGateway);
    }; // ESSE BEAN SERVE PARA FALAR PARA O SPRING QUE ESSA INTERFACE DEVE INTERAGIR POIS COMO ELA ESTA EM UMA CAMADA MAIS PROFUNDA O SPRING NÃO IRIA RECONHECELO

}
