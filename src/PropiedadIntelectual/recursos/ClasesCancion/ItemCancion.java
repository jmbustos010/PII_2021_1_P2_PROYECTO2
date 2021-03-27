package PropiedadIntelectual.recursos.ClasesCancion;

public class ItemCancion {
    private String Nombre;
    private String Autor;

    public ItemCancion(){
    }
    public ItemCancion(String Nombre, String Autor){
        this.Nombre = Nombre;
        this.Autor  = Autor;
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

    @Override
    public String toString(){
        return Nombre;
    }
}
