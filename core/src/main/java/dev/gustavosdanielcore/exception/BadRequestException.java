package dev.gustavosdanielcore.exception;

public class BadRequestException extends Exception{
    //COMO A MENSAGEM NÃO MUDAR ELA PODE SER "SUPER" SOBRE ESCREVIDA JA O CIDGO COMO MUDA TEM QUE PASSAR ELE
    private String codego;

    public BadRequestException(String mensagem, String codego) {
        super(mensagem);
        this.codego = codego;

    }

    public String getCodego() {
        return codego;
    }
}
