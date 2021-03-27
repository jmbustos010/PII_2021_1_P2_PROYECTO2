package BienesMuebles.registro.carro;

import BienesMuebles.datos.carros.CarrosDatos;
import BienesMuebles.recursos.clases.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRegistro {

    public List<Carro> Leer(){
        List<Carro> listaCarros = new ArrayList<>();
        try{

            listaCarros = CarrosDatos.LeerCarros();

        }catch (Exception e){
        }
        return listaCarros;
        //-----
    }


    public String Insertar(Carro carro1){
        String respuesta = "Error";
        try {

            if (carro1.getPlaca().isEmpty() ){
                throw new Exception("Error: La placa no puede estar vacia");
            }
            if (carro1.getPlaca().length() > 7){
                throw new Exception("Error: La placa no puede tener mas de 7 digitos");
            }
            if (carro1.getColor().isEmpty()){
                throw new Exception("Error: El color no puede estar vacio");
            }
            if (carro1.getNumeroDePuertas() < 2 || carro1.getNumeroDePuertas() > 4){
                throw new Exception("Error: Numero de puertas no valido para un carro");
            }
            if (carro1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: Es obligatorio el numero de serie del motor");
            }
            if (carro1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: El nombre del propietario estar vacio");
            }
            respuesta = CarrosDatos.InsertarCarro(carro1);

            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Actualizar(Carro carro1){
        String respuesta = "Error";
        try {

            if (carro1.getPlaca().length() > 7){
                throw new Exception("Error: No se puede actualizar, la placa no puede tener mas de 7 digitos");
            }
            if (carro1.getPlaca().isEmpty()){
                throw new Exception("Error: No puede actualizar la palca a un valor vacio");
            }
            if (carro1.getNumeroDePuertas() < 2 || carro1.getNumeroDePuertas() > 4 ){
                throw new Exception("Error: No se puede actualizar, numero de puertas no valido para un carro");
            }
            if (carro1.getColor().isEmpty()){
                throw new Exception("Error: El color esta vacio, no se puede actulizar");
            }
            if (carro1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: No se puede cambiar el numero de serie del motor");
            }
            if (carro1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: No se puede actualizar, el nombre del propietario esta vacio");
            }

            respuesta = CarrosDatos.ActualizarCarro(carro1);

            if (respuesta == null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Eliminar(Carro carro1){
        String respuesta = "Error";

        try {
            if (carro1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("Error: no se puedo eliminar del registro, el numero de serie de motor esta vacio");
            }

            respuesta = CarrosDatos.EliminarCarro(carro1);

            if (respuesta == null){
                respuesta = "Eliminado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public List<Carro> Buscar(Carro carro1) throws Exception{
        List<Carro> listaCarros = new ArrayList<>();

        try {

            listaCarros = CarrosDatos.BuscarCarro(carro1);

            if (carro1.getNumeroDeSerieMotor().isEmpty()){
                throw new Exception("No se puede buscar, es necesario el numero de serie del motor");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCarros;
    }
    //------------------------------------------------------------------------------------------------------------------
}
