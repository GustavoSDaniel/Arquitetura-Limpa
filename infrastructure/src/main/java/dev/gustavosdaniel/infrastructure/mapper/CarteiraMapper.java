package dev.gustavosdaniel.infrastructure.mapper;

import dev.gustavosdaniel.infrastructure.entity.CarteiraEntity;
import dev.gustavosdaniel.infrastructure.entity.TransicaoPinEntity;
import dev.gustavosdaniel.infrastructure.entity.UsuarioEntity;
import dev.gustavosdanielcore.domain.Carteira;
import org.springframework.stereotype.Component;

@Component
public class CarteiraMapper {

    public CarteiraEntity paraCarteiraEntity(Carteira carteira, UsuarioEntity usuarioEntity, TransicaoPinEntity transicaoPinEntity){
        return new CarteiraEntity(
                usuarioEntity,
                carteira.getSaldo(),
                transicaoPinEntity,
                carteira.getCriandoAt(),
                carteira.getAtualizandoAt()
        );
    };

}
