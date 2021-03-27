package BienesInmuebles.Recursos.Clases;

public class CasaItem {
    private String TipoDiseño;
    private int Precio;

    public CasaItem(){
    }

    public CasaItem(String TipoDiseño, int Precio){
        this.TipoDiseño = TipoDiseño;
        this.Precio = Precio;
    }

    public void setTipoDiseño(String tipoDiseño) {
        this.TipoDiseño = tipoDiseño;
    }

    public String getTipoDiseño() {
        return TipoDiseño;
    }

    public void setPrecio(int precio) {
        this.Precio = precio;
    }

    public int getPrecio() {
        return Precio;
    }

    @Override
    public String toString(){
        return TipoDiseño;
    }

}
