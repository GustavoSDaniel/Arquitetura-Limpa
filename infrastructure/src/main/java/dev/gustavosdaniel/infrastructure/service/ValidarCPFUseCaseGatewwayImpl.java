package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.repository.UsuarioEntityRepository;
import dev.gustavosdanielapplication.gateway.ValidarCPFUseCaseGatewway;
import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

public class ValidarCPFUseCaseGatewwayImpl implements ValidarCPFUseCaseGatewway {
    private UsuarioEntityRepository usuarioEntityRepository;

    public ValidarCPFUseCaseGatewwayImpl(UsuarioEntityRepository usuarioEntityRepository) {
        this.usuarioEntityRepository = usuarioEntityRepository;
    }

    // AS INGREÇÕES DE DEPENDENCIA GERALMENTES SÃO DO MAPPER E DO REPOSITORRY


    @Override
    public Boolean validandoCPF(String cpfValidado) {
        log.info("Inicio da verificação se o CPF est[a disponivel");
        return !usuarioEntityRepository.existsByValidarCPF(cpfValidado);
    } // METODO PARA SABER SE O NUMERO DO CPF INFORMADO ESTA DISPONIVEL
}
