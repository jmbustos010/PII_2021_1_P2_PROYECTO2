package PropiedadIntelectual.recursos.ClasesSoftware;

public class ItemSoftware {
    private String Nombre;
    private String Dispositivo;

    public ItemSoftware(){
    }
    public ItemSoftware(String Nombre, String Dispositivo){
        this.Nombre = Nombre;
        this.Dispositivo  = Dispositivo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDispositivo() {
        return Dispositivo;
    }

    public void setDispositivo(String Dispositivo) {
        this.Dispositivo = Dispositivo;
    }

    @Override
    public String toString(){
        return Nombre;
    }
}
