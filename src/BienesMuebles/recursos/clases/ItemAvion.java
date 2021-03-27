package BienesMuebles.recursos.clases;

public class ItemAvion {

    private String NombrePropietario;
    private int Id;

    public ItemAvion(String nombrePropietario, int id){
        this.NombrePropietario = nombrePropietario;
        this.Id = id;
    }

    public int getId(){
        return Id;
    }
    public void setId(int id){
        this.Id = id;
    }


    public String getNombrePropietario(){
        return NombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario){
        this.NombrePropietario = nombrePropietario;
    }


    @Override
    public String toString(){
        return NombrePropietario;
    }
    //------------------------------------------------------------------------------------------------------------------
}
