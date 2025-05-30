package dev.gustavosdaniel.infrastructure.config;

import dev.gustavosdaniel.usecase.BuscarCarteiraCPFUseCase;
import dev.gustavosdaniel.usecase.ConsultarSaldoUseCase;
import dev.gustavosdanielapplication.gateway.BuscarCarteiraCPFGateway;
import dev.gustavosdanielapplication.usecaseimpl.BuscarCarteiraCPFUseCaseImpl;
import dev.gustavosdanielapplication.usecaseimpl.ConsultarSaldoUseCaseImpl;
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
}
