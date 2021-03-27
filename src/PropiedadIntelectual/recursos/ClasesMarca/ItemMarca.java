package PropiedadIntelectual.recursos.ClasesMarca;

public class ItemMarca {
    private long Id;
    private String Nombre;

    public ItemMarca(){
    }

    public ItemMarca(long Id, String Nombre){
        this.Id     = Id;
        this.Nombre = Nombre;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    @Override
    public String toString(){
        return Nombre;
    }
}
