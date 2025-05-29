package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.entity.CarteiraEntity;
import dev.gustavosdaniel.infrastructure.mapper.CarteiraMapper;
import dev.gustavosdaniel.infrastructure.mapper.TransacaoMapper;
import dev.gustavosdaniel.infrastructure.repository.CarteiraEntityRepository;
import dev.gustavosdaniel.infrastructure.repository.TransacaoEntityRepository;
import dev.gustavosdanielapplication.gateway.TransferirGateway;
import dev.gustavosdanielcore.domain.Transicao;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransferirGatewayImpl implements TransferirGateway {

    private CarteiraEntityRepository carteiraRepository;
    private TransacaoEntityRepository transacaoEntityRepository;
    private CarteiraMapper carteiraMapper;
    private TransacaoMapper transacaoMapper;

    public TransferirGatewayImpl(CarteiraEntityRepository carteiraRepository, TransacaoEntityRepository transacaoEntityRepository, CarteiraMapper carteiraMapper, TransacaoMapper transacaoMapper) {
        this.carteiraRepository = carteiraRepository;
        this.transacaoEntityRepository = transacaoEntityRepository;
        this.carteiraMapper = carteiraMapper;
        this.transacaoMapper = transacaoMapper;
    }

    @Override
    @Transactional //CASO DE ALGUM ERRO TODO O METODO SERA DESFEITO
    public Boolean transicao(Transicao transicao) {
        try {
            carteiraRepository.save(carteiraMapper.paraCarteiraEntity(transicao.getDaCarteira()));
            carteiraRepository.save(carteiraMapper.paraCarteiraEntity(transicao.getParaCarteira()));
            transacaoEntityRepository.save(transacaoMapper.transacaoConcluida(transicao));

            return true;
        } catch (Exception e) {
            transacaoEntityRepository.save(transacaoMapper.cancelarTransicao(transicao));
            return false;
        }
    }
}
