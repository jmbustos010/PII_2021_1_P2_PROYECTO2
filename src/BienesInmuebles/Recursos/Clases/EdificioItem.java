package BienesInmuebles.Recursos.Clases;

public class EdificioItem {
    private String TipoConstruccion;
    private int Altura;

    public EdificioItem(){
    }

    public EdificioItem(String TipoConstruccion, int Altura){
        this.TipoConstruccion = TipoConstruccion;
        this.Altura = Altura;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.TipoConstruccion = tipoConstruccion;
    }

    public String getTipoConstruccion() {
        return TipoConstruccion;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int altura) {
        this.Altura = altura;
    }

    @Override
    public String toString(){
        return TipoConstruccion;
    }
}
