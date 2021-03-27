package PropiedadIntelectual.recursos.ClasesMarca;

import java.util.Date;

public class Marca {
    private Long Id;
    private String Nombre;
    private String Propietario;
    private String Sede;
    private Date FechaCreacion;

    public Marca(){

    }
    public Marca (Long Id, String Nombre, String Propietario, String Sede, Date FechaCreacion){
        this.Id            = Id;
        this.Nombre        = Nombre;
        this.Propietario   = Propietario;
        this.Sede          = Sede;
        this.FechaCreacion = FechaCreacion;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String Propietario) {
        this.Propietario = Propietario;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
}
