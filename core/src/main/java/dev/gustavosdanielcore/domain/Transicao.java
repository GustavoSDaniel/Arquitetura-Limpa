package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.domain.enums.TransicaoStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transicao {

    private Long id;
    private Carteira paraCarteira;
    private Carteira daCarteira;
    private BigDecimal valor;
    private TransicaoStatusEnum status;
    private LocalDateTime atualizandoAt;
    private LocalDateTime criandoAt;

    public Transicao() {
    }

    public Transicao(BigDecimal valor, TransicaoStatusEnum status, Carteira paraCarteira, Long id, Carteira daCarteira, LocalDateTime criandoAt, LocalDateTime atualizandoAt) {
        this.valor = valor;
        this.status = status;
        this.paraCarteira = paraCarteira;
        this.id = id;
        this.daCarteira = daCarteira;
        this.criandoAt = criandoAt;
        this.atualizandoAt = atualizandoAt;
    }

    public Transicao(Carteira daCarteira, Carteira paraCarteira, BigDecimal valor) {  // VALORES QUE PRECISA SER RECEBIDO
        this.daCarteira = daCarteira;
        this.paraCarteira = paraCarteira;
        this.valor = valor;
        this.status = TransicaoStatusEnum.CRIADO; //Não precisa receber esse valor, mas vai ser mostrado
        this.criandoAt = LocalDateTime.now(); //Não precisa receber esse valor, mas vai ser mostrado
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TransicaoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransicaoStatusEnum status) {
        this.status = status;
    }

    public Carteira getParaCarteira() {
        return paraCarteira;
    }

    public void setParaCarteira(Carteira paraCarteira) {
        this.paraCarteira = paraCarteira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carteira getDaCarteira() {
        return daCarteira;
    }

    public void setDaCarteira(Carteira daCarteira) {
        this.daCarteira = daCarteira;
    }

    public LocalDateTime getCriandoAt() {
        return criandoAt;
    }

    public LocalDateTime getAtualizandoAt() {
        return atualizandoAt;
    }

    public void setAtualizandoAt(LocalDateTime atualizandoAt) {
        this.atualizandoAt = atualizandoAt;
    }


    //METODO USADO PARA VER SE NÃO TA FAZENDO A TRANSAÇÃO PARA A PROPIA CARTEIRA
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Transicao transicao = (Transicao) o;
        return Objects.equals(id, transicao.id) && paraCarteira.equals(transicao.paraCarteira) && daCarteira.equals(transicao.daCarteira) && valor.equals(transicao.valor) && status == transicao.status && Objects.equals(atualizandoAt, transicao.atualizandoAt) && criandoAt.equals(transicao.criandoAt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + paraCarteira.hashCode();
        result = 31 * result + daCarteira.hashCode();
        result = 31 * result + valor.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + Objects.hashCode(atualizandoAt);
        result = 31 * result + criandoAt.hashCode();
        return result;
    }
}
