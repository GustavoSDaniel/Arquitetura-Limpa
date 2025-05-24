package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.exception.TransicaoPinException;
import dev.gustavosdanielcore.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransicaoPin {

    private Long id;
    private String pin;
    private Integer quantidadeDeTentativa;
    private Boolean bloqueado;
    private LocalDateTime criandoAt;
    private LocalDateTime atuaalizandoAt;

    public TransicaoPin() {
    }

    public TransicaoPin(Integer quantidadeDeTentativa, String pin, Long id, LocalDateTime criandoAt, Boolean bloqueado, LocalDateTime atuaalizandoAt) {
        this.quantidadeDeTentativa = quantidadeDeTentativa;
        this.pin = pin;
        this.id = id;
        this.criandoAt = criandoAt;
        this.bloqueado = bloqueado;
        this.atuaalizandoAt = atuaalizandoAt;
    }

    public TransicaoPin(String pin) throws TransicaoPinException {  // VALORES QUE PRECISA SER RECEBIDO
        setPin(pin);
        this.quantidadeDeTentativa = 3;
        this.bloqueado = false;
        this.criandoAt = LocalDateTime.now(); //Não precisa receber esse valor, mas vai ser mostrado
    }

    public Integer getQuantidadeDeTentativa() {
        return quantidadeDeTentativa;
    }

    public void setQuantidadeDeTentativa() {

        if (this.quantidadeDeTentativa == 1 ){
            this.bloqueado = true;
            this.quantidadeDeTentativa = 0;
        }else {
            this.quantidadeDeTentativa = this.quantidadeDeTentativa - 1;
        } //SE Q AUTNIDADE DE TENTATIVAS FOR IGUAL A 1 ELE JA VAI BLOQUEAR O SUARIO CASO FOR PÁRA 0 SE NÃO VAI CONTINUAR SUBITRAINDO
    }

    public void restaurarQuantidadeTentativa(){
        this.quantidadeDeTentativa = 3;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        TransicaoPin that = (TransicaoPin) o;
        return Objects.equals(id, that.id) && pin.equals(that.pin) && quantidadeDeTentativa.equals(that.quantidadeDeTentativa) && bloqueado.equals(that.bloqueado) && criandoAt.equals(that.criandoAt) && Objects.equals(atuaalizandoAt, that.atuaalizandoAt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + pin.hashCode();
        result = 31 * result + quantidadeDeTentativa.hashCode();
        result = 31 * result + bloqueado.hashCode();
        result = 31 * result + criandoAt.hashCode();
        result = 31 * result + Objects.hashCode(atuaalizandoAt);
        return result;
    }
}
