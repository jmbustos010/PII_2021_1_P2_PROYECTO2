package BienesMuebles.recursos.clases;

public class Autobus {
    private String Placa;
    private int NumeroAsientos;
    private String Color;
    private String NumeroDeSerieMotor;
    private String NombrePropietario;

    public Autobus(){

    }

    public Autobus(String placa, int numeroAsientos, String color, String numeroDeSerieMotor, String nombrePropietario){
        this.Placa = placa;
        this.NumeroAsientos = numeroAsientos;
        this.Color = color;
        this.NumeroDeSerieMotor = numeroDeSerieMotor;
        this.NombrePropietario = nombrePropietario;
    }


    public String getPlaca(){
        return Placa;
    }
    public void setPlaca(String placa){
        this.Placa = placa;
    }


    public int getNumeroAsientos(){
        return NumeroAsientos;
    }
    public void setNumeroAsientos(int numeroAsientos){
        this.NumeroAsientos = numeroAsientos;
    }


    public String getColor(){
        return Color;
    }
    public void setColor(String color){
        this.Color = color;
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
    //------------------------------------------------------------------------------------------------------------------
}
