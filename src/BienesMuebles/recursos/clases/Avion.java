package BienesMuebles.recursos.clases;

public class Avion {
    private int Id;
    private int NumeroDeMotores;
    private int CapacidadDePeso;
    private String NombrePropietario;
    private String TipoDeAvion;


    public Avion(){

    }
    public Avion(int id, int numeroDeMotores, String nombrePropiedtario, String tipoDeAvion, int capacidadDePeso){
        this.Id = id;
        this.NumeroDeMotores = numeroDeMotores;
        this.CapacidadDePeso = capacidadDePeso;
        this.NombrePropietario = nombrePropiedtario;
        this.TipoDeAvion = tipoDeAvion;
    }


    public int getId(){
        return Id;
    }
    public void setId(int id){
        this.Id = id;
    }


    public int getNumeroDeMotores(){
        return NumeroDeMotores;
    }
    public void setNumeroDeMotores(int numeroDeMotores){
        this.NumeroDeMotores = numeroDeMotores;
    }


    public int getCapacidadDePeso(){
        return CapacidadDePeso;
    }
    public void setCapacidadDePeso(int capacidadDePeso){
        this.CapacidadDePeso = capacidadDePeso;
    }


    public String getNombrePropietario(){
        return NombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario){
        this.NombrePropietario = nombrePropietario;
    }


    public String getTipoDeAvion(){
        return TipoDeAvion;
    }
    public void setTipoDeAvion(String tipoDeAvion){
        this.TipoDeAvion = tipoDeAvion;
    }

    //------------------------------------------------------------------------------------------------------------------
}
