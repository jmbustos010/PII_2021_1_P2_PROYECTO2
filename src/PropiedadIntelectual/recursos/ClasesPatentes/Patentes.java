package PropiedadIntelectual.recursos.ClasesPatentes;

import java.util.Date;

public class Patentes {
    private Long Id;
    private String Nombre;
    private String Descripcion;
    private String Propietario;
    private Date FechaCreacion;

    public Patentes(){
    }

    public Patentes(Long Id,String Nombre, String Descripcion, String Propietario, Date FechaCreacion){
        this.Id            = Id;
        this.Nombre        = Nombre;
        this.Descripcion   = Descripcion;
        this.Propietario   = Propietario;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String Propietario) {
        this.Propietario = Propietario;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
}
