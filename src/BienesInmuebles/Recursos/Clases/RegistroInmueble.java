package BienesInmuebles.Recursos.Clases;

public abstract class RegistroInmueble {
    protected long   Tamaño;
    protected String Ubicacion;
    protected String Descripcion;

    public RegistroInmueble(){
    }
    public RegistroInmueble(long Tamaño, String Ubicacion, String Descripcion){
        this.Tamaño = Tamaño;
        this.Ubicacion = Ubicacion;
        this.Descripcion = Descripcion;
    }

    //////////Setters//////////
    public void setTamaño(long tamaño) {
        this.Tamaño = tamaño;
    }
    public void setUbicacion(String ubicacion) {
        this.Ubicacion = ubicacion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
    //////////Getters//////////

    public long getTamaño() {
        return Tamaño;
    }
    public String getUbicacion() {
        return Ubicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

}
