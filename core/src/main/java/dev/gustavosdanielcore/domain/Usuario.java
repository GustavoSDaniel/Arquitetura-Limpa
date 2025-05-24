package dev.gustavosdanielcore.domain;

import dev.gustavosdanielcore.domain.enums.TipoUsuarioEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private ValidandoCPF numeroCPF;
    private String nomeCompleto;
    private TipoUsuarioEnum tipo;
    private TransicaoPin transicaoPin;
    private  LocalDateTime criandoAt;
    private LocalDateTime atualizandoAt;

    public Usuario() {
    }

    public Usuario(TransicaoPin transicaoPin, TipoUsuarioEnum tipo, ValidandoCPF numeroCPF, String senha, String nomeCompleto, Long id, String email, LocalDateTime criandoAt, LocalDateTime atualizandoAt) {
        this.transicaoPin = transicaoPin;
        this.tipo = tipo;
        this.numeroCPF = numeroCPF;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.id = id;
        this.email = email;
        this.criandoAt = criandoAt;
        this.atualizandoAt = atualizandoAt;
    }

    public Usuario(TransicaoPin transicaoPin, TipoUsuarioEnum tipo, ValidandoCPF numeroCPF, String senha, String nomeCompleto, String email) {
        this.transicaoPin = transicaoPin;
        this.tipo = tipo;
        this.numeroCPF = numeroCPF;
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
        return numeroCPF;
    }

    public void setTaxNumber(ValidandoCPF validandoCPF) {
        this.numeroCPF = validandoCPF;
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

    public LocalDateTime getAtualizandoAt() {
        return atualizandoAt;
    }

    public void setAtualizandoAt(LocalDateTime atualizandoAt) {
        this.atualizandoAt = atualizandoAt;
    }


    //METODO USADO PARA VER SE NÃO NÃO É O MESMO USUARIO

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && email.equals(usuario.email) && senha.equals(usuario.senha) && numeroCPF.equals(usuario.numeroCPF) && nomeCompleto.equals(usuario.nomeCompleto) && tipo == usuario.tipo && transicaoPin.equals(usuario.transicaoPin) && criandoAt.equals(usuario.criandoAt) && Objects.equals(atualizandoAt, usuario.atualizandoAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + senha.hashCode();
        result = 31 * result + numeroCPF.hashCode();
        result = 31 * result + nomeCompleto.hashCode();
        result = 31 * result + tipo.hashCode();
        result = 31 * result + transicaoPin.hashCode();
        result = 31 * result + criandoAt.hashCode();
        result = 31 * result + Objects.hashCode(atualizandoAt);
        return result;
    }
}
