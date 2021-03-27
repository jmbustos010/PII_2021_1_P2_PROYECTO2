package BienesInmuebles.Recursos.Clases;

public class Terrenos extends RegistroInmueble{
    private String TipoSuelo;
    private int Precio;

    public Terrenos(){
        super();
    }
    public Terrenos(String TipoSuelo, long Tamaño, String Ubicacion, String Descripcion){
        super(Tamaño,Ubicacion,Descripcion);
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
}
