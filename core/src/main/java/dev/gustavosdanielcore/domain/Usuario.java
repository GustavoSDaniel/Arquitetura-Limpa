package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private ValidandoCPF validandoCPF;
    private String nomeCompleto;
    private TipoUsuarioEnum tipo;
    private TransicaoPin transicaoPin;
    private  LocalDateTime criandoAt;
    private LocalDateTime atuaalizandoAt;

    public Usuario() {
    }

    public Usuario(TransicaoPin transicaoPin, TipoUsuarioEnum tipo, ValidandoCPF validandoCPF, String senha, String nomeCompleto, Long id, String email, LocalDateTime criandoAt, LocalDateTime atuaalizandoAt) {
        this.transicaoPin = transicaoPin;
        this.tipo = tipo;
        this.validandoCPF = validandoCPF;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.id = id;
        this.email = email;
        this.criandoAt = criandoAt;
        this.atuaalizandoAt = atuaalizandoAt;
    }

    public Usuario(TransicaoPin transicaoPin, TipoUsuarioEnum tipo, ValidandoCPF validandoCPF, String senha, String nomeCompleto, String email) {
        this.transicaoPin = transicaoPin;
        this.tipo = tipo;
        this.validandoCPF = validandoCPF;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.email = email;

    }

    public TransicaoPin getTransicaoPin() {
        return transicaoPin;
    }

    public void setTransicaoPin(TransicaoPin transicaoPin) {
        this.transicaoPin = transicaoPin;
    }

    public TipoUsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioEnum tipo) {
        this.tipo = tipo;
    }

    public ValidandoCPF getTaxNumber() {
        return validandoCPF;
    }

    public void setTaxNumber(ValidandoCPF validandoCPF) {
        this.validandoCPF = validandoCPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCriandoAt() {
        return criandoAt;
    }

    public LocalDateTime getAtuaalizandoAt() {
        return atuaalizandoAt;
    }

    public void setAtuaalizandoAt(LocalDateTime atuaalizandoAt) {
        this.atuaalizandoAt = atuaalizandoAt;
    }


    //METODO USADO PARA VER SE NÃO NÃO É O MESMO USUARIO

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && email.equals(usuario.email) && senha.equals(usuario.senha) && validandoCPF.equals(usuario.validandoCPF) && nomeCompleto.equals(usuario.nomeCompleto) && tipo == usuario.tipo && transicaoPin.equals(usuario.transicaoPin) && criandoAt.equals(usuario.criandoAt) && Objects.equals(atuaalizandoAt, usuario.atuaalizandoAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + senha.hashCode();
        result = 31 * result + validandoCPF.hashCode();
        result = 31 * result + nomeCompleto.hashCode();
        result = 31 * result + tipo.hashCode();
        result = 31 * result + transicaoPin.hashCode();
        result = 31 * result + criandoAt.hashCode();
        result = 31 * result + Objects.hashCode(atuaalizandoAt);
        return result;
    }
}
