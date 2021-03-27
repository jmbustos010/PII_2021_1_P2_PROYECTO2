package PropiedadIntelectual.recursos.ClasesSoftware;

import java.util.Date;

public class Software {
    private String Nombre;
    private String Descripcion;
    private String Dispositivo;
    private Date FechaCreacion;

    public Software(){

    }
    public Software(String Nombre, String Descripcion, String Dispositivo, Date FechaCreacion){
        this.Nombre        = Nombre;
        this.Descripcion   = Descripcion;
        this.Dispositivo   = Dispositivo;
        this.FechaCreacion = FechaCreacion;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String getDispositivo() {
        return Dispositivo;
    }
    public void setDispositivo(String Dispositivo) {
        this.Dispositivo = Dispositivo;
    }
    public Date getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
}
