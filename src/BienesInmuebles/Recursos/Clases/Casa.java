package BienesInmuebles.Recursos.Clases;

public class Casa extends RegistroInmueble {
    private String TipoDiseño;
    private int Precio;

    public Casa(){
        super();
    }
    public Casa(String TipoDiseño, long Tamaño, String Ubicacion, String Descripcion){
        super(Tamaño,Ubicacion,Descripcion);
        this.TipoDiseño = TipoDiseño;
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

}
