package BienesMuebles.registro.avion;

import BienesMuebles.datos.aviones.AvionesDatos;
import BienesMuebles.recursos.clases.Avion;


import java.util.ArrayList;
import java.util.List;

public class AvionRegistro {


        public List<Avion> Leer(){
            List<Avion> listaAviones = new ArrayList<>();
            try{

                listaAviones = AvionesDatos.LeerAviones();

            }catch (Exception e){
            }
            return listaAviones;
            //-----
        }


    public String Insertar(Avion avion1){
        String respuesta = "Error";
        try {

            if (String.valueOf(avion1.getId()).length() > 9){
                throw new Exception("Error: El ID no puede contener mas de nueve digitos");
            }
            if (avion1.getId() < 0){
                throw new Exception("Error: El ID no puede ser menor a 0");
            }
            if (avion1.getNumeroDeMotores() > 4 || avion1.getNumeroDeMotores() < 2){
                throw new Exception("Error: El numero de motores solo puede ser 2, 3 o 4");
            }
            if (avion1.getCapacidadDePeso() < 0){
                throw new Exception("Error: La capacidad de peso no puede ser menor a 0");
            }
            if (avion1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: El nombre del propietario estar vacio");
            }
            if (avion1.getTipoDeAvion().isEmpty()){
                throw new Exception("Error El tipod e avion esta vacio");
            }
            respuesta = AvionesDatos.InsertarAvion(avion1);

            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }

        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Actualizar(Avion avion1){
        String respuesta = "Error";
        try {

            if (String.valueOf(avion1.getId()).length() > 9){
                throw new Exception("Error: El ID no puede contener mas de nueve digitos");
            }
            if (avion1.getId() < 0){
                throw new Exception("Error: El ID no puede ser menor a 0");
            }
            if (avion1.getNumeroDeMotores() > 4 || avion1.getNumeroDeMotores() < 2){
                throw new Exception("Error: El numero de motores solo puede ser 2, 3 o 4");
            }
            if (avion1.getCapacidadDePeso() < 0){
                throw new Exception("Error: La capacidad de peso no puede ser menor a 0");
            }
            if (String.valueOf(avion1.getCapacidadDePeso()).length() > 6 ){
                throw new Exception("Error: La capacidad de peso no puede tener mas de 6 digitos");
            }
            if (avion1.getNombrePropietario().isEmpty()){
                throw new Exception("Error: El nombre del propietario estar vacio");
            }
            if (avion1.getTipoDeAvion().isEmpty()){
                throw new Exception("Error El tipod e avion esta vacio");
            }

            respuesta = AvionesDatos.ActualizarAvion(avion1);

            if (respuesta == null){
                respuesta = "Actualizado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public String Eliminar(Avion avion1){
        String respuesta = "Error";

        try {
            if (avion1.getId() < 0){
                throw new Exception("Error: no se puedo eliminar del registro, el ID no es valido");
            }

            respuesta = AvionesDatos.EliminarAvion(avion1);

            if (respuesta == null){
                respuesta = "Eliminado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        return respuesta;
        //-----
    }


    public List<Avion> Buscar(Avion avion1) throws Exception{
        List<Avion> listaAviones = new ArrayList<>();

        try {

            listaAviones = AvionesDatos.BuscarAvion(avion1);

            if (avion1.getId() < 0){
                throw new Exception("No se puede buscar, es necesario un ID valido");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaAviones;
    }
    //------------------------------------------------------------------------------------------------------------------
}
