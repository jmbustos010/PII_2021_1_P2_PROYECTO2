package BienesMuebles.recursos.clases;

public class Motocicleta {
    private String Placa;
    private String Color;
    private int Kilometraje;
    private String NumeroDeSerieMotor;
    private String Marca;
    private String NombrePropietario;

    public Motocicleta(){

    }

    public Motocicleta(String placa, String color, String numeroDeSerieMotor, String marca, String nombrePropietario, int kilometraje){
        this.Placa = placa;
        this.Color = color;
        this.NumeroDeSerieMotor = numeroDeSerieMotor;
        this.Marca = marca;
        this.NombrePropietario = nombrePropietario;
        this.Kilometraje = kilometraje;
    }


    public String getPlaca(){
        return Placa;
    }
    public void setPlaca(String placa){
        this.Placa = placa;
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


    public String getMarca(){
        return Marca;
    }
    public void setMarca(String marca){
        this.Marca = marca;
    }


    public String getNombrePropietario(){
        return NombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario){
        this.NombrePropietario = nombrePropietario;
    }


    public int getKilometraje(){
        return Kilometraje;
    }
    public void setKilometraje(int kilometraje){
        this.Kilometraje = kilometraje;
    }
    //------------------------------------------------------------------------------------------------------------------
}
