package PropiedadIntelectual.recursos.ClasesPatentes;

public class ItemPatente {
    private Long Id;
    private String Nombre;

    public ItemPatente(){

    }
    public ItemPatente(Long Id, String Nombre){
        this.Id     = Id;
        this.Nombre = Nombre;
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

    @Override
    public String toString(){
        return Nombre;
    }
}

