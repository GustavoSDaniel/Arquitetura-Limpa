package dev.gustavosdaniel.infrastructure.mapper;

import dev.gustavosdaniel.infrastructure.entity.TransacaoEntity;
import dev.gustavosdanielcore.domain.Transicao;
import dev.gustavosdanielcore.domain.enums.TransicaoStatusEnum;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {
    private CarteiraMapper carteiraMapper;

    public TransacaoMapper(CarteiraMapper carteiraMapper) {
        this.carteiraMapper = carteiraMapper;
    }

    public TransacaoEntity paraTransacaoEntity(Transicao transicao){
        return new TransacaoEntity(
                carteiraMapper.paraCarteiraEntity(transicao.getDaCarteira()),
                carteiraMapper.paraCarteiraEntity(transicao.getParaCarteira()),
                transicao.getValor(),
                transicao.getStatus(),
                transicao.getCriandoAt(),
                transicao.getAtualizandoAt()
        );
    };

    public TransacaoEntity criarTransacao(Transicao transicao){
        return new TransacaoEntity(
                carteiraMapper.paraCarteiraEntity(transicao.getDaCarteira()),
                carteiraMapper.paraCarteiraEntity(transicao.getParaCarteira()),
                transicao.getValor(),
                TransicaoStatusEnum.CRIADO,
                transicao.getCriandoAt(),
                transicao.getAtualizandoAt()
        );
    };

    public Transicao paraTransacao(TransacaoEntity transacaoEntity) throws Exception {
        return new Transicao(
                transacaoEntity.getValor(),
                transacaoEntity.getStatus(),
                carteiraMapper.paraCarteiraEntity(transacaoEntity.getParaCarteira()),
                transacaoEntity.getId(),
                carteiraMapper.paraCarteiraEntity(transacaoEntity.getDeCarteira()),
                transacaoEntity.getCriandoAt(),
                transacaoEntity.getAtualizadoAt()
        );

    }
}
