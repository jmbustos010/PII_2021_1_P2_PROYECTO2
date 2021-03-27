package BienesInmuebles.ClasesConexion;

import BienesInmuebles.Datos.ClasesDatos.CasaDatos;
import BienesInmuebles.Recursos.Clases.Casa;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasaConexion {
    public List<Casa> Leer() throws Exception{
        List<Casa> Listacasas = new ArrayList<>();
        try{
            Listacasas = CasaDatos.leerCasas();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return Listacasas;
    }

    public String Insertar(Casa casa) throws Exception{
        String respuesta = "Error";
        try{
            if (casa.getTipoDiseño().isEmpty()){
                throw new SQLException("Error el tipo de diseño no debe estar vacio");
            }
            if (casa.getTamaño()<=0){
                throw new SQLException("Error el tamaño del terreno no puede ser menor o igual a 0");
            }
            if (casa.getDescripcion().isEmpty()){
                throw new SQLException("Error la descripcion no debe estar vacia");
            }
            if (casa.getUbicacion().isEmpty()){
                throw  new SQLException("Error la ubicacion no debe estar vacia");
            }
            if (casa.getPrecio()<=0){
                throw new SQLException("Error el precio no puede ser menor o igual a 0");
            }
            respuesta = CasaDatos.InsertarCasa(casa);
            if (respuesta == null){
                respuesta = "Guardado exitosamente";
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error","Algo salio mal",JOptionPane.ERROR_MESSAGE);
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }

    public String Actualizar (Casa casa) throws Exception{
        String respuesta = "Error";
        try {
            if (casa.getTamaño() <= 0) {
                throw new SQLException("Error el tamaño de la casa no puede ser menor o igual a 0 ");
            }
            if (casa.getDescripcion().isEmpty()) {
                throw new SQLException("Error la descipcion no debe estar vacia");
            }
            if (casa.getUbicacion().isEmpty()){
                throw new SQLException("Error la ubicacion no puede estar vacia");
            }
            if (casa.getPrecio()<=0){
                throw new SQLException("Error el precio no puede ser menor o igual a 0");
            }
            respuesta = CasaDatos.ActualizarCasa(casa);
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

    public void Eliminar(Casa casas) throws Exception{
        try{
            CasaDatos.EliminarCasa(casas);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Casa> Buscar(Casa casa) throws Exception{
        List<Casa> listaCasa = new ArrayList<>();
        try{
            if (casa.getTipoDiseño().isEmpty()){
                throw new Exception("Error el tipo de diseño no puede estar vacia");
            }
            listaCasa = CasaDatos.BuscarCasa(casa);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCasa;
    }
}
