package BienesMuebles.recursos.clases;

public class Item {
    private String NombrePropietario;
    private String NumeroDeSerieMotor;

    public Item(String nombrePropietario, String numeroDeSerieMotor){
        this.NombrePropietario =  nombrePropietario;
        this.NumeroDeSerieMotor = numeroDeSerieMotor;
    }


    public String getNumeroDeSerieMotor(){
        return NumeroDeSerieMotor;
    }
    public void setNumeroDeSerieMotor(String numeroDeSerieMotor){
        this.NumeroDeSerieMotor = numeroDeSerieMotor;
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
}
