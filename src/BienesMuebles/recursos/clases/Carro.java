package BienesMuebles.recursos.clases;

public class Carro {
    private String Placa;
    private int NumeroDePuertas;
    private String Color;
    private String NumeroDeSerieMotor;
    private String NombrePropietario;

    public Carro(){

    }
    public Carro(String placa, int numeroDePuertas, String color, String numeroDeSerieMotor, String nombrePropiedtario){
        this.Placa = placa;
        this.NumeroDePuertas = numeroDePuertas;
        this.Color = color;
        this.NumeroDeSerieMotor = numeroDeSerieMotor;
        this.NombrePropietario = nombrePropiedtario;
    }


    public String getPlaca(){
        return Placa;
    }
    public void setPlaca(String placa){
        this.Placa = placa;
    }


    public int getNumeroDePuertas(){
        return NumeroDePuertas;
    }
    public void setNumeroDePuertas(int numeroDePuertas){
        this.NumeroDePuertas = numeroDePuertas;
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
