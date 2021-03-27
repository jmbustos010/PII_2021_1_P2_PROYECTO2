package PropiedadIntelectual.recursos.ClasesCancion;

import java.util.Date;

public class Cancion {
    private String Nombre;
    private String Autor;
    private String Genero;
    private Date   FechaPublicada;

    public Cancion(){
    }

    public Cancion(String Nombre, String Autor, String Genero, Date FechaPublicada){
        this.Nombre         = Nombre;
        this.Autor          = Autor;
        this.Genero         = Genero;
        this.FechaPublicada = FechaPublicada;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getAutor() {
        return Autor;
    }
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    public Date getFechaPublicada() {
        return FechaPublicada;
    }
    public void setFechaPublicada(Date FechaPublicada) {
        this.FechaPublicada = FechaPublicada;
    }
}
