package BienesInmuebles.Recursos.Clases;

public class Edificios extends RegistroInmueble {
    private String TipoConstruccion;
    private int Altura;
    private int Precio;

    public Edificios(){
        super();
    }
    public Edificios(String TipoConstruccion, long Tamaño, String Ubicacion, String Descripcion, int Precio, int Altura){
        super(Tamaño,Ubicacion,Descripcion);
        this.TipoConstruccion = TipoConstruccion;
        this.Altura = Altura;
        this.Precio = Precio;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.TipoConstruccion = tipoConstruccion;
    }

    public String getTipoConstruccion() {
        return TipoConstruccion;
    }


    public void setPrecio(int precio) {
        this.Precio = precio;
    }
    public int getPrecio() {
        return Precio;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int altura) {
        this.Altura = altura;
    }
}
