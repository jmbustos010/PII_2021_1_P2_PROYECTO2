package BienesInmuebles.ClasesConexion;

import BienesInmuebles.Datos.ClasesDatos.TerrenosDatos;
import BienesInmuebles.Recursos.Clases.Terrenos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerrenosConexion {

    public List<Terrenos> Leer() throws Exception{
        List<Terrenos> listaTerreno = new ArrayList<>();
        try{
            listaTerreno = TerrenosDatos.leerTerrenos();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaTerreno;
    }

    public String Insertar(Terrenos terreno) throws Exception{
        String respuesta = "Error";
        try{
            if (terreno.getTipoSuelo().isEmpty()){
                throw new SQLException("Error el tipo de suelo no debe estar vacio");
            }
            if (terreno.getTamaño()<=0){
                throw new SQLException("Error el tamaño del terreno no puede ser menor o igual a 0");
            }
            if (terreno.getDescripcion().isEmpty()){
                throw new SQLException("Error la descripcion no debe estar vacia");
            }
            if (terreno.getUbicacion().isEmpty()){
                throw  new SQLException("Error la ubicacion no debe estar vacia");
            }
            if (terreno.getPrecio()<=0){
                throw new SQLException("Error el precio del terreno no puede ser menor o igual a 0");
            }
            respuesta = TerrenosDatos.InsertarTerreno(terreno);
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

    public String Actualizar (Terrenos terreno) throws Exception{
        String respuesta = "Error";
        try {
            if (terreno.getTamaño() <= 0) {
                throw new SQLException("Error el tamaño de la casa no puede ser menor o igual a 0 ");
            }
            if (terreno.getDescripcion().isEmpty()) {
                throw new SQLException("Error la descipcion no debe estar vacia");
            }
            if (terreno.getPrecio()<=0){
                throw new SQLException("Error el precio del terreno no puede ser menor o igual a 0");
            }
            respuesta = TerrenosDatos.ActualizarTerrenos(terreno);
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

    public void Eliminar(Terrenos terreno) throws Exception{
        try{
            TerrenosDatos.EliminarTerreno(terreno);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Terrenos> Buscar(Terrenos terreno) throws Exception{
        List<Terrenos> listaTerreno = new ArrayList<>();
        try{
            if (terreno.getTipoSuelo().isEmpty()){
                throw new Exception("Error el tipo de suelo no puede estar vacia");
            }
            listaTerreno = TerrenosDatos.BuscarTerrenos(terreno);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaTerreno;
    }
}
