package BienesMuebles.registro.autobus;

import BienesMuebles.datos.autobus.AutobusesDatos;
import BienesMuebles.recursos.clases.Autobus;

import java.util.ArrayList;
import java.util.List;

public class AutobusRegistro {


    public List<Autobus> Leer(){
        List<Autobus> listaAutobuses = new  ArrayList<>();
     try{

         listaAutobuses = AutobusesDatos.LeerAutobuses();

     }catch (Exception e){
     }
     return listaAutobuses;
     //-----
    }


    public String Insertar(Autobus autobus1){
        String respuesta = "Error";
        try {

            if (autobus1.getPlaca().isEmpty() ){
                throw new Exception("Error: La placa no puede estar vacia");
            }
            if (autobus1.getPlaca().length() > 7){
                throw new Exception("Error: La placa no puede tener mas de 7 digitos");
            }
            if (autobus1.getColor().isEmpty()){
                throw new Exception("Error: El color no puede estar vacio");
            }
            if (autobus1.getNumeroAsientos() <= 6 || autobus1.getNumeroAsientos() > 30){
                throw new Exception("Error: Numero de asientos no valido para un autobus");
            }
            /*if (String.valueOf(autobus1.getNumeroAsientos()).isEmpty()){
                throw new Exception("Error: Numero de asientos no puede estar vacio");
            }*/
            if (autobus1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: Es obligatorio el numero de serie del motor");
            }
            if (autobus1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: El nombre del propietario esta vacio");
            }
            respuesta = AutobusesDatos.InsertarAutobus(autobus1);

            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Actualizar(Autobus autobus1){
        String respuesta = "Error";
        try {

            if (autobus1.getPlaca().isEmpty()){
                throw new Exception("Error: No puede actualizar la palca a un valor vacio");
            }
            if (autobus1.getPlaca().length() > 7){
                throw new Exception("Error: La placa no puede tener mas de 7 digitos");
            }
            if (autobus1.getNumeroAsientos() <= 6 || autobus1.getNumeroAsientos() > 30 ){
                throw new Exception("Error: Numero de asientos no valido");
            }
            if (autobus1.getColor().isEmpty()){
                throw new Exception("Error: El color esta vacio, no se puede actulizar");
            }
            if (autobus1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: No se puede cambiar el numero de serie del motor");
            }
            if (autobus1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: No se puede actualizar el nombre del propietario esta vacio");
            }

            respuesta = AutobusesDatos.ActualizarAutobus(autobus1);

            if (respuesta == null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Eliminar(Autobus autobus1){
        String respuesta = "Error";

        try {
            if (autobus1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: no se puedo eliminar del registro, el numero de serie de motor esta vacio");
            }

            respuesta = AutobusesDatos.EliminarAutobus(autobus1);

            if (respuesta == null){
                respuesta = "Eliminado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public List<Autobus> Buscar(Autobus autobus1) throws Exception{
        List<Autobus> listaAutobuses = new ArrayList<>();

        try {

            listaAutobuses = AutobusesDatos.BuscarAutobus(autobus1);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaAutobuses;
    }


    //------------------------------------------------------------------------------------------------------------------
}
