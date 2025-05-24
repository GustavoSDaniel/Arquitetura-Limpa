package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.ValidandoCPFException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Carteira {

    private Long id;
    private BigDecimal saldo;
    private Usuario usuario;
    private LocalDateTime criandoAt;
    private LocalDateTime atualizandoAt;
    private TransicaoPin transicaoPin;

    public Carteira() {
    }

    public Carteira(Usuario usuario, BigDecimal saldo, Long id, LocalDateTime criandoAt, LocalDateTime atualizandoAt, TransicaoPin transicaoPin) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.id = id;
        this.criandoAt = criandoAt;
        this.atualizandoAt = atualizandoAt;
        this.transicaoPin = transicaoPin;
    }

    public Carteira(Usuario usuario, BigDecimal saldo, TransicaoPin transicaoPin) { // VALORES QUE PRECISA SER RECEBIDO
        this.usuario = usuario;
        this.saldo = saldo;
        this.transicaoPin = transicaoPin;
        this.criandoAt = LocalDateTime.now(); //Não precisa receber esse valor, mas vai ser mostrado
    }

    public TransicaoPin getTransicaoPin() {
        return transicaoPin;
    }

    public void setTransicaoPin(TransicaoPin transicaoPin) {
        this.transicaoPin = transicaoPin;
    }

    public LocalDateTime getAtualizandoAt() {
        return atualizandoAt;
    }

    public void setAtualizandoAt(LocalDateTime atualizandoAt) {
        this.atualizandoAt = atualizandoAt;
    }

    public LocalDateTime getCriandoAt() {
        return criandoAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void receberValor(BigDecimal valor){ // METODO PARA RECEBER SALDO
        this.saldo.add(valor);
    }

    public void tranferir(BigDecimal valor) throws TransferenciaException{

        if (this.usuario.getTipo() == TipoUsuarioEnum.LOGISTA){
            throw new TransferenciaException(ErrorCodeEnum.TR0001.getMensagem(), ErrorCodeEnum.TR0001.getCodego());
        }
        if (this.saldo.compareTo(valor) < 0){
            throw new TransferenciaException(ErrorCodeEnum.TR0002.getMensagem(), ErrorCodeEnum.TR0002.getCodego());
        }
        this.saldo.subtract(valor);
    }

    public void receberTransferencia(BigDecimal valor){
        this.saldo.add(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Carteira carteira = (Carteira) o;
        return Objects.equals(id, carteira.id) && saldo.equals(carteira.saldo) && usuario.equals(carteira.usuario) && criandoAt.equals(carteira.criandoAt) && Objects.equals(atualizandoAt, carteira.atualizandoAt) && transicaoPin.equals(carteira.transicaoPin);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + saldo.hashCode();
        result = 31 * result + usuario.hashCode();
        result = 31 * result + criandoAt.hashCode();
        result = 31 * result + Objects.hashCode(atualizandoAt);
        result = 31 * result + transicaoPin.hashCode();
        return result;
    }
}
