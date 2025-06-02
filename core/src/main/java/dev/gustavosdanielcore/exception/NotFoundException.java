package dev.gustavosdanielcore.exception;

public class NotFoundException extends Exception{
    //COMO A MENSAGEM NÃO MUDAR ELA PODE SER "SUPER" SOBRE ESCREVIDA JA O CodiGO COMO MUDA TEM QUE PASSAR ELE
    private String codego;

    public NotFoundException(String mensagem, String codego) {
        super(mensagem);
        this.codego = codego;

    }

    public String getCodego() {
        return codego;
    }
}
