package dev.gustavosdaniel.infrastructure.service;

import dev.gustavosdaniel.infrastructure.entity.TransacaoEntity;
import dev.gustavosdaniel.infrastructure.mapper.TransacaoMapper;
import dev.gustavosdaniel.infrastructure.repository.TransacaoEntityRepository;
import dev.gustavosdanielapplication.gateway.CriarTransicaoGateway;
import dev.gustavosdanielcore.domain.Transicao;
import org.springframework.stereotype.Service;

@Service
public class CriarTransicaoGatewayImpl implements CriarTransicaoGateway {

    private TransacaoEntityRepository transacaoEntityRepository;
    private TransacaoMapper transacaoMapper;

    public CriarTransicaoGatewayImpl(TransacaoEntityRepository transacaoEntityRepository, TransacaoMapper transacaoMapper) {
        this.transacaoEntityRepository = transacaoEntityRepository;
        this.transacaoMapper = transacaoMapper;
    }

    @Override
    public Transicao criar(Transicao transicao){
        try {
            TransacaoEntity transacaoEntity = transacaoMapper.criarTransacao(transicao);
            // TransacaoEntity transacaoEntitySalvo = transacaoEntityRepository.save(transacaoEntity); é uma opção tbm
            return transacaoMapper.paraTransacao(transacaoEntityRepository.save(transacaoEntity));
        } catch (Exception e) {
            return null;
        }
    }
}
