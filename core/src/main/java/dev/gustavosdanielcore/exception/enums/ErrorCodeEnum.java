package dev.gustavosdanielcore.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Número de documento invalido", "ON-0001"),
    ON0002("Número de documento indisponivel", "ON-0002"),
    TR0001("logista não tem a função de tranferência disponivel", "TR-0001"),
    TR0002("Saldo indisponivel", "TR-0002"),
    TRP0001("Pin inválido", "TRP-0001"),
    EMA0001("Email já utilizado", "EMA-0001"),
    ON0004("Houver um erro na criação doo usuario", "ON-0004"),
    TRAN0001("Houve um erro ao realizar a transferencia", "TRAN-0001"),
    NOT0001("Carteira não encontrada", "NOT-0001"),
    NO0001("Houve um erro na notificação do usúario", "NO-0001"),
    TRAN0002("Transferencia não autorizada", "TRAN-0002"),
    ATHN0002("Houve um erro de autentificalçao", "ATH-0002"),
    PIN0001("Pin de transação bloqueado", "PIN-0001"),
    PIN0002("Pin incorreto, %d tentativa(s) restante(s)", "PIN-0002"), //O "%d" vai ser subistituido pelo "quantidadeDeTentativas"
    NO0002("Invalid request", "NO-0002");




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

    public static String pin0002GetMensagem(Integer quantidadeDeTentativas ){
        return String.format(PIN0002.mensagem, quantidadeDeTentativas);
    } // STATIC PARA QUE NÃO PRECISA FICAR INSTANCIANDO
}
