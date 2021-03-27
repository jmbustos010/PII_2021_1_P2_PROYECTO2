package BienesInmuebles.Recursos.Clases;

public class TerrenoItem {
    private String TipoSuelo;
    private int Precio;


    public TerrenoItem(){
    }
    public TerrenoItem(String TipoSuelo, int Precio){
        this.Precio = Precio;
        this.TipoSuelo = TipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.TipoSuelo = tipoSuelo;
    }
    public String getTipoSuelo() {
        return TipoSuelo;
    }

    public void setPrecio(int precio) {
        this.Precio = precio;
    }
    public int getPrecio() {
        return Precio;
    }

    @Override
    public String toString(){
        return TipoSuelo;
    }
}
