package dev.gustavosdaniel.infrastructure.config;

import dev.gustavosdaniel.usecase.AvaliarEmailUseCase;
import dev.gustavosdaniel.usecase.CriarUsuarioUseCase;
import dev.gustavosdaniel.usecase.ValidarCPFUseCase;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielapplication.usecaseimpl.CriarUsuarioUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {


    
    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(ValidarCPFUseCase validarCPFUseCase, AvaliarEmailUseCase avaliarEmailUseCase, CriarUsuarioGateway criarUsuarioGateway){
        return new CriarUsuarioUseCaseImpl(validarCPFUseCase,avaliarEmailUseCase, criarUsuarioGateway);
    }; // ESSE BEAN SERVE PARA FALAR PARA O SPRING QUE ESSA INTERFACE DEVE INTERAGIR POIS COMO ELA ESTA EM UMA CAMADA MAIS PROFUNDA O SPRING NÃO IRIA RECONHECELO

}
