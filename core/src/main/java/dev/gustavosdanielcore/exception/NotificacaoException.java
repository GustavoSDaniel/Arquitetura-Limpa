package dev.gustavosdanielcore.exception;

public class NotificacaoException extends Exception{
    //COMO A MENSAGEM NÃO MUDAR ELA PODE SER "SUPER" SOBRE ESCREVIDA JA O CIDGO COMO MUDA TEM QUE PASSAR ELE
    private String codego;

    public NotificacaoException(String mensagem, String codego) {
        super(mensagem);
        this.codego = codego;

    }

    public String getCodego() {
        return codego;
    }
}
