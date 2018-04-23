package trabalho1;

public class Cupom {

    private String codigo;
    private boolean foiUsado;
    private float desconto;

    public Cupom (String codigo, float desconto) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.foiUsado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getFoiUsado() {
        return foiUsado;
    }

    public void setFoiUsado(boolean foiUsado) {
        this.foiUsado = foiUsado;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    // @Override
    public String toString() {
        String out = "Código do cupom: " + getCodigo() + "\n";
        if(foiUsado) {
            out = out + "Cupom foi utilizado";
        } else {
            out = out + "Cupom não foi utilizado";
        }
        return out;
    }
}
