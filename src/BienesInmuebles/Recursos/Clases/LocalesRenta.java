package BienesInmuebles.Recursos.Clases;

public class LocalesRenta extends RegistroInmueble {
    private  int Precio;


    public LocalesRenta(){
        super();
    }
    public LocalesRenta(int Precio, long Tamaño, String Ubicacion, String Descripcion){
        super(Tamaño,Ubicacion,Descripcion);
        this.Precio = Precio;
    }


    public void setPrecio(int precio) {
        this.Precio = precio;
    }
    public int getPrecio() {
        return Precio;
    }
}
