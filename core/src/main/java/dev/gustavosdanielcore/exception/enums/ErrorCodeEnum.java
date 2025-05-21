package dev.gustavosdanielcore.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Número de documento invalido", "ON-0001"),
    ON0002("Número de documento indisponivel", "ON-0002"),
    TR0001("logista não tem a função de tranferência disponivel", "TR-0001"),
    TR0002("Saldo indisponivel", "TR-0002"),
    TRP0001("Pin inválido", "TRP-0001"),
    EMA0001("Email já utilizado", "EMA-0001"),
    ON0004("Houver um erro na criação doo usuario", "ON-0004");



    private String mensagem;
    private String codego;

    ErrorCodeEnum(String mensagem, String codego) {
        this.mensagem = mensagem;
        this.codego = codego;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodego() {
        return codego;
    }

    public void setCodego(String codego) {
        this.codego = codego;
    }
}
