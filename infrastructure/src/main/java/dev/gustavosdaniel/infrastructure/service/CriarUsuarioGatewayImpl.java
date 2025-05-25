package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.entity.TransicaoPinEntity;
import dev.gustavosdaniel.infrastructure.entity.UsuarioEntity;
import dev.gustavosdaniel.infrastructure.mapper.CarteiraMapper;
import dev.gustavosdaniel.infrastructure.mapper.TransicaoPinMapper;
import dev.gustavosdaniel.infrastructure.mapper.UsuarioMapper;
import dev.gustavosdaniel.infrastructure.repository.CarteiraEntityRepository;
import dev.gustavosdaniel.infrastructure.repository.TransacaoPinEntityRepository;
import dev.gustavosdaniel.infrastructure.repository.UsuarioEntityRepository;
import dev.gustavosdanielapplication.gateway.CriarUsuarioGateway;
import dev.gustavosdanielcore.domain.Carteira;
import dev.gustavosdanielcore.domain.Usuario;
import org.springframework.stereotype.Service;
import static dev.gustavosdaniel.infrastructure.utils.Utilites.log;
//DESSA FORMA EU CONSIGO CHAMAR O METODO DIRETO SEM PRECISAR CHAMAR O NOME DA CLASSE

@Service
public class CriarUsuarioGatewayImpl implements CriarUsuarioGateway {

    private UsuarioEntityRepository usuarioEntityRepository;
    private UsuarioMapper usuarioMapper;
    private TransacaoPinEntityRepository transacaoPinEntityRepository;
    private TransicaoPinMapper transicaoPinMapper;
    private CarteiraEntityRepository carteiraEntityRepository;
    private CarteiraMapper carteiraMapper;

    // AS INGREÇÕES DE DEPENDENCIA GERALMENTES SÃO DO MAPPER E DO REPOSITORRY

    public CriarUsuarioGatewayImpl(UsuarioEntityRepository usuarioEntityRepository, UsuarioMapper usuarioMapper, TransacaoPinEntityRepository transacaoPinEntityRepository, TransicaoPinMapper transicaoPinMapper, CarteiraEntityRepository carteiraEntityRepository, CarteiraMapper carteiraMapper) {
        this.usuarioEntityRepository = usuarioEntityRepository;
        this.usuarioMapper = usuarioMapper;
        this.transacaoPinEntityRepository = transacaoPinEntityRepository;
        this.transicaoPinMapper = transicaoPinMapper;
        this.carteiraEntityRepository = carteiraEntityRepository;
        this.carteiraMapper = carteiraMapper;
    }

    @Override
    public Boolean criar(Usuario usuario, Carteira carteira) {
        try {
            log.info("Inicio da criação do  usuario :: CriarUsuarioGatewayImpl "); //ESSE LOG INDICA QUE FOI CHAMADO ESSE METODO PARA A CRIAÇÃO DO USUARIO
            UsuarioEntity usuarioSalvo = usuarioEntityRepository.save(usuarioMapper.paraUsuarioEntity(usuario));
            TransicaoPinEntity transicaoPinSalvo = transacaoPinEntityRepository.save(transicaoPinMapper.paraTransicaoPinEntity(carteira.getTransicaoPin()));
            carteiraEntityRepository.save(carteiraMapper.paraCarteiraEntity(carteira, usuarioSalvo, transicaoPinSalvo)); //A CARTEIRA TEM QUE ESTAR VINCULADA A ESSES 2 QUANDO O USUARIO FOR CRIADO
            log.info("Usuario criado com sucesso :: CriarUsuarioGatewayImpl ");
            return true;
        } catch (Exception e) {
            log.error("Houve um erro na criação do usuario :: CriarUsuarioGatewayImpl ");
            return false;
        }
    }
}
