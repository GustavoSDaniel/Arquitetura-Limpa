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
}
