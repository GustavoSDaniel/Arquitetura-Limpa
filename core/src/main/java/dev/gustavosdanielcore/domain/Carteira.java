package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;
import dev.gustavosdanielcore.exception.TransferenciaException;
import dev.gustavosdanielcore.exception.ValidandoCPFException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Carteira {

    private Long id;
    private BigDecimal saldo;
    private Usuario usuario;
    private LocalDateTime criandoAt;
    private LocalDateTime atualizandoAt;

    public Carteira() {
    }

    public Carteira(Usuario usuario, BigDecimal saldo, Long id, LocalDateTime criandoAt, LocalDateTime atualizandoAt) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.id = id;
        this.criandoAt = criandoAt;
        this.atualizandoAt = atualizandoAt;
    }

    public Carteira(Usuario usuario, BigDecimal saldo) { // VALORES QUE PRECISA SER RECEBIDO
        this.usuario = usuario;
        this.saldo = saldo;
        this.criandoAt = LocalDateTime.now(); //Não precisa receber esse valor, mas vai ser mostrado
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
}
