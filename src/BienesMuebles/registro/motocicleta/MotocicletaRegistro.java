package BienesMuebles.registro.motocicleta;

import BienesMuebles.datos.motocicletas.MotocicletasDatos;
import BienesMuebles.recursos.clases.Motocicleta;

import java.util.ArrayList;
import java.util.List;

public class MotocicletaRegistro{


    public List<Motocicleta> Leer(){
        List<Motocicleta> listaMotocicletas = new ArrayList<>();
        try{

            listaMotocicletas = MotocicletasDatos.LeerMotocicletas();

        }catch (Exception e){
        }
        return listaMotocicletas;
        //-----
    }


    public String Insertar(Motocicleta motocicleta1){
        String respuesta = "Error";
        try {

            if (motocicleta1.getPlaca().isEmpty() ){
                throw new Exception("Error: La placa no puede estar vacia");
            }
            if (motocicleta1.getPlaca().length() > 7){
                throw new Exception("Error: La placa no puede tener mas de 7 digitos");
            }
            if (motocicleta1.getColor().isEmpty()){
                throw new Exception("Error: El color no puede estar vacio");
            }
            if (motocicleta1.getKilometraje() < 0){
                throw new Exception("Error: El kilometraje no puede ser menor a 0");
            }
            if (motocicleta1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: Es obligatorio el numero de serie del motor");
            }
            if (motocicleta1.getMarca().isEmpty()){
                throw new Exception("Error: La marca de la motocicleta no puede estar vacia");
            }
            if (motocicleta1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: El nombre del propietario estar vacio");
            }
            respuesta = MotocicletasDatos.InsertarMotocicleta(motocicleta1);

            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Actualizar(Motocicleta motocicleta1){
        String respuesta = "Error";
        try {

            if (motocicleta1.getPlaca().isEmpty()){
                throw new Exception("Error: No puede actualizar la palca a un valor vacio");
            }
            if (motocicleta1.getPlaca().length() > 7){
                throw new Exception("Error: No se puede actualizar, la placa no puede tener mas de 7 digitos");
            }
            if (motocicleta1.getKilometraje() < 0 ){
                throw new Exception("Error: No se puede actualizar, el kilometraje no puede ser menor a 0");
            }
            if (motocicleta1.getColor().isEmpty()){
                throw new Exception("Error: El color esta vacio, no se puede actulizar");
            }
            if (motocicleta1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: No se puede cambiar el numero de serie del motor");
            }
            if (motocicleta1.getMarca().isEmpty()){
                throw new Exception("Error: No se puede actualizar, la marca de la motocicleta no puede estar vacia");
            }
            if (motocicleta1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: No se puede actualizar, el nombre del propietario esta vacio");
            }

            respuesta = MotocicletasDatos.ActualizarMotocicleta(motocicleta1);

            if (respuesta == null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Eliminar(Motocicleta motocicleta1){
        String respuesta = "Error";

        try {
            if (motocicleta1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: no se puedo eliminar del registro, el numero de serie de motor esta vacio");
            }

            respuesta = MotocicletasDatos.EliminarMotocicleta(motocicleta1);

            if (respuesta == null){
                respuesta = "Eliminado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public List<Motocicleta> Buscar(Motocicleta motocicleta1) throws Exception{
        List<Motocicleta> listaMotocicletas = new ArrayList<>();

        try {

            listaMotocicletas = MotocicletasDatos.BuscarMotocicleta(motocicleta1);

            if (motocicleta1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("No se puede buscar, es necesario el numero de serie del motor");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return listaMotocicletas;
    }
    //------------------------------------------------------------------------------------------------------------------
}
