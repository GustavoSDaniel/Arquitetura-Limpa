package dev.gustavosdaniel.infrastructure.mapper;

import dev.gustavosdaniel.infrastructure.entity.TransicaoPinEntity;
import dev.gustavosdanielcore.domain.TransicaoPin;
import org.springframework.stereotype.Component;

@Component
public class TransicaoPinMapper {

   public TransicaoPinEntity paraTransicaoPinEntity(TransicaoPin transicaoPin){
       return new TransicaoPinEntity(
               transicaoPin.getPin(),
               transicaoPin.getQuantidadeDeTentativa(),
               transicaoPin.getBloqueado(),
               transicaoPin.getCriandoAt(),
               transicaoPin.getAtuaalizandoAt()
       );
   }

   public TransicaoPin paraTransicaoPin(TransicaoPinEntity transicaoPinEntity){
        return new TransicaoPin(
                transicaoPinEntity.getQuantidadeDeTentativa(),
                transicaoPinEntity.getPin(),
                transicaoPinEntity.getId(),
                transicaoPinEntity.getCriandoAt(),
                transicaoPinEntity.getBloqueado(),
                transicaoPinEntity.getAtualizadoAt()
        );
   }
}
