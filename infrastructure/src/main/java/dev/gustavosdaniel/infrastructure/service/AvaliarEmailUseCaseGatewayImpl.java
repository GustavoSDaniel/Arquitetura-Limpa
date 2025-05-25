package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.repository.UsuarioEntityRepository;
import dev.gustavosdanielapplication.gateway.AvaliarEmailUseCaseGateway;
import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

public class AvaliarEmailUseCaseGatewayImpl implements AvaliarEmailUseCaseGateway {
    private UsuarioEntityRepository usuarioEntityRepository;
    // AS INGREÇÕES DE DEPENDENCIA GERALMENTES SÃO DO MAPPER E DO REPOSITORRY

    public AvaliarEmailUseCaseGatewayImpl(UsuarioEntityRepository usuarioEntityRepository) {
        this.usuarioEntityRepository = usuarioEntityRepository;
    }

    @Override
    public Boolean avaliarEmail(String email) {
        log.info("Inicio da verificação se o email est[a disponivel");

        return !usuarioEntityRepository.existsByAvaliarEmail(email);
    } // CASO O EMAIL NÃO EXISTA VAI RETORNAR TRUE
}
