package BienesInmuebles.ClasesConexion;

import BienesInmuebles.Datos.ClasesDatos.EdificiosDatos;
import BienesInmuebles.Recursos.Clases.Edificios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EdificioConexion {

    public List<Edificios> Leer() throws Exception{
        List<Edificios> listaEdificio = new ArrayList<>();
        try{
            listaEdificio = EdificiosDatos.leerEdificios();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaEdificio;
    }

    public String Insertar(Edificios edificios) throws Exception{
        String respuesta = "Error";
        try{
            if (edificios.getTipoConstruccion().isEmpty()){
                throw new SQLException("Error el tipo de construccion no debe estar vacio");
            }
            if (edificios.getTamaño()<=0){
                throw new SQLException("Error el tamaño del terreno no puede ser menor o igual a 0");
            }
            if (edificios.getDescripcion().isEmpty()){
                throw new SQLException("Error la descripcion no debe estar vacia");
            }
            if (edificios.getUbicacion().isEmpty()){
                throw  new SQLException("Error la ubicacion no debe estar vacia");
            }
            if (edificios.getAltura()<=0){
                throw new SQLException("Error la altura del edificio no puede ser menor o igual a 0");
            }
            if (edificios.getPrecio()<=0){
                throw new SQLException("Error el precio del edificio no puede ser menor o igual a 0");
            }

            respuesta = EdificiosDatos.InsertarEdificio(edificios);
            if (respuesta == null){
                respuesta = "Guardado exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }

    public String Actualizar (Edificios edificios) throws Exception{
        String respuesta = "Error";
        try {
            if (edificios.getTamaño() <= 0) {
                throw new SQLException("Error el tamaño de la casa no puede ser menor o igual a 0 ");
            }
            if (edificios.getDescripcion().isEmpty()) {
                throw new SQLException("Error la descipcion no debe estar vacia");
            }
            if (edificios.getAltura()<=0){
                throw new SQLException("Error la altura del edificio no puede ser menor o igual a 0");
            }
            if (edificios.getPrecio()<=0){
                throw new SQLException("Error el precio del edificio no puede ser menor o igual a 0");
            }
            respuesta = EdificiosDatos.ActualizarEdificios(edificios);
            if (respuesta == null) {
                respuesta = "Guardado exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }

    public void Eliminar(Edificios edificios) throws Exception{
        try{
            EdificiosDatos.EliminarEdificio(edificios);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Edificios> Buscar(Edificios edificios) throws Exception{
        List<Edificios> listaEdificio = new ArrayList<>();
        try{
            if (edificios.getTipoConstruccion().isEmpty()){
                throw new Exception("Error el tipo de construccion no puede estar vacia");
            }
            listaEdificio = EdificiosDatos.BuscarEdificio(edificios);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaEdificio;
    }
}
