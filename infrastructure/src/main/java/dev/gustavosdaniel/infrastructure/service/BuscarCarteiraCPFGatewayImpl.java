package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.mapper.CarteiraMapper;
import dev.gustavosdaniel.infrastructure.repository.CarteiraEntityRepository;
import dev.gustavosdanielapplication.gateway.BuscarCarteiraCPFGateway;
import dev.gustavosdanielcore.domain.Carteira;
import org.springframework.stereotype.Service;

@Service
public class BuscarCarteiraCPFGatewayImpl implements BuscarCarteiraCPFGateway {

    private CarteiraEntityRepository carteiraEntityRepository;
    private CarteiraMapper carteiraMapper;
    // AS INGREÇÕES DE DEPENDENCIA SÃO DO MAPPER E DO REPOSITORRY


    public BuscarCarteiraCPFGatewayImpl(CarteiraEntityRepository carteiraEntityRepository, CarteiraMapper carteiraMapper) {
        this.carteiraEntityRepository = carteiraEntityRepository;
        this.carteiraMapper = carteiraMapper;
    }

    @Override
    public Carteira findByNumeroCPF(String numeroCPF) throws Exception {
        return carteiraMapper.paraCarteiraEntity(carteiraEntityRepository.findByUsuarioNumeroCPF(numeroCPF));
    }
}
