package trabalho1;

public class Mensagem {

    private String texto;
    private boolean lido;
    private String  enviadaPor;

    public Mensagem( String texto, String enviadaPor) {
        this.texto = texto;
        this.enviadaPor = enviadaPor;
        this.lido = false;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    //@Override
    public String toString () {

        String out = "Status da mensagem: ";
        if(lido) {
            out = out + "Lida\n";
        } else {
            out = out + "Não lida\n";
        }
        out = out + "Mensagem enviada por: " + enviadaPor + "\n";
        out = out + texto + "\n";
        return out;
    }
}
