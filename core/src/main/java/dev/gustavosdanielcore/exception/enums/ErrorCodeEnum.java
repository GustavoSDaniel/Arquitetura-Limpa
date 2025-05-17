package dev.gustavosdanielcore.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Número de documento invalido", "ON-0001"),
    TR0001("logista não tem a função de tranferência disponivel", "TR-0001"),
    TR0002("Saldo indisponivel", "TR-0002"),
    TRP0001("Pin inválido", "TRP-0001");


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
