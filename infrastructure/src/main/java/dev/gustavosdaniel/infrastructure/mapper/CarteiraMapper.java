package dev.gustavosdaniel.infrastructure.mapper;

import dev.gustavosdaniel.infrastructure.entity.CarteiraEntity;
import dev.gustavosdaniel.infrastructure.entity.TransicaoPinEntity;
import dev.gustavosdaniel.infrastructure.entity.UsuarioEntity;
import dev.gustavosdanielcore.domain.Carteira;
import org.springframework.stereotype.Component;

@Component
public class CarteiraMapper {

    private TransicaoPinMapper transicaoPinMapper;
private UsuarioMapper usuarioMapper;

    public CarteiraMapper(TransicaoPinMapper transicaoPinMapper, UsuarioMapper usuarioMapper) {
        this.transicaoPinMapper = transicaoPinMapper;

        this.usuarioMapper = usuarioMapper;
    }

    public CarteiraEntity paraCarteiraEntity(Carteira carteira, UsuarioEntity usuarioEntity, TransicaoPinEntity transicaoPinEntity){
        return new CarteiraEntity(
                usuarioEntity,
                carteira.getSaldo(),
                transicaoPinEntity,
                carteira.getCriandoAt(),
                carteira.getAtualizandoAt()
        );
    };

    public Carteira paraCarteiraEntity(CarteiraEntity carteiraEntity) throws Exception {
        if (carteiraEntity == null) {
                return null;
        }
        return new Carteira(
                usuarioMapper.paraUsuario(carteiraEntity.getUsuario()),
                carteiraEntity.getSaldo(),
                carteiraEntity.getId(),
                carteiraEntity.getCriandoAt(),
                carteiraEntity.getAtualizadoAt(),
                transicaoPinMapper.paraTransicaoPin(carteiraEntity.getTransicaoPin())
        );
    }



}
