package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.repository.UsuarioEntityRepository;
import dev.gustavosdanielapplication.gateway.ValidarCPFUseCaseGatewway;
import org.springframework.stereotype.Service;

import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

@Service
public class ValidarCPFUseCaseGatewwayImpl implements ValidarCPFUseCaseGatewway {
    private final UsuarioEntityRepository usuarioEntityRepository;
    // AS INGREÇÕES DE DEPENDENCIA SÃO DO MAPPER E DO REPOSITORRY

    public ValidarCPFUseCaseGatewwayImpl(UsuarioEntityRepository usuarioEntityRepository) {
        this.usuarioEntityRepository = usuarioEntityRepository;
    }


    @Override
    public Boolean validandoCPF(String cpfValidado) {
        log.info("Inicio da verificação se o CPF est[a disponivel");
        return !usuarioEntityRepository.existsByNumeroCPF(cpfValidado);
    } // METODO PARA SABER SE O NUMERO DO CPF INFORMADO ESTA DISPONIVEL
}
