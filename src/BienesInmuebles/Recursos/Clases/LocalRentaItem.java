package BienesInmuebles.Recursos.Clases;

public class LocalRentaItem {
    private  int   Precio;
    private String Descripcion;

    public LocalRentaItem(){
    }

    public LocalRentaItem(int Precio, String Ubicacion){
        this.Precio = Precio;
        this.Descripcion = Ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setPrecio(int precio) {
        this.Precio = precio;
    }
    public int getPrecio() {
        return Precio;
    }

    @Override
    public String toString(){
        return Descripcion;
    }
}
