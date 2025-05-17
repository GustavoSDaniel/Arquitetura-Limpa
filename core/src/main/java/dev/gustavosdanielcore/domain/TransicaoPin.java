package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransicaoPin {

    private Long id;
    private Usuario usuario;
    private String pin;
    private Integer quantidadeDeTentativa;
    private Boolean bloqueado;
    private LocalDateTime criandoAt;
    private LocalDateTime atuaalizandoAt;

    public TransicaoPin() {
    }

    public TransicaoPin(Usuario usuario, Integer quantidadeDeTentativa, String pin, Long id, LocalDateTime criandoAt, Boolean bloqueado, LocalDateTime atuaalizandoAt) {
        this.usuario = usuario;
        this.quantidadeDeTentativa = quantidadeDeTentativa;
        this.pin = pin;
        this.id = id;
        this.criandoAt = criandoAt;
        this.bloqueado = bloqueado;
        this.atuaalizandoAt = atuaalizandoAt;
    }

    public TransicaoPin(String pin, Integer quantidadeDeTentativa, Usuario usuario,Boolean bloqueado ) {  // VALORES QUE PRECISA SER RECEBIDO
        this.pin = pin;
        this.quantidadeDeTentativa = quantidadeDeTentativa;
        this.usuario = usuario;
        this.bloqueado = bloqueado;
        this.criandoAt = LocalDateTime.now(); //Não precisa receber esse valor, mas vai ser mostrado
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getQuantidadeDeTentativa() {
        return quantidadeDeTentativa;
    }

    public void setQuantidadeDeTentativa(Integer quantidadeDeTentativa) {
        this.quantidadeDeTentativa = quantidadeDeTentativa;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransicaoPinException {
        pinIsValido(pin); // VALIDANDO PIN
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCriandoAt() {
        return criandoAt;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDateTime getAtuaalizandoAt() {
        return atuaalizandoAt;
    }

    public void setAtuaalizandoAt(LocalDateTime atuaalizandoAt) {
        this.atuaalizandoAt = atuaalizandoAt;
    }

    private void pinIsValido(String pin) throws TransicaoPinException { // CONDIÇÃO PARA VALIDAR PIN
        if (pin .length() != 8){
            throw new TransicaoPinException(ErrorCodeEnum.TRP0001.getMensagem(), ErrorCodeEnum.TRP0001.getCodego());
        }

    }
}
