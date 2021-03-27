package BienesInmuebles.ClasesConexion;

import BienesInmuebles.Datos.ClasesDatos.LocalesRentaDatos;
import BienesInmuebles.Recursos.Clases.LocalesRenta;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalesRentaConexion {

    public List<LocalesRenta> Leer() throws Exception{
        List<LocalesRenta> listaLocales = new ArrayList<>();
        try{
            listaLocales = LocalesRentaDatos.leerLocales();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaLocales;
    }

    public String Insertar(LocalesRenta local) throws Exception{
        String repsuesta = "Error";
        try{
            if (local.getPrecio()<=0){
                throw new SQLException("Error el precio del local no puede sero menor o igual a 0");
            }
            if (local.getTamaño()<=0){
                throw new SQLException("Error el tamaño del local no puede ser menor o igual a 0");
            }
            if (local.getDescripcion().isEmpty()){
                throw new SQLException("Error la descipcion no debe estar vacia");
            }
            if (local.getUbicacion().isEmpty()){
                throw  new SQLException("Error la ubicacion no debe estar vacia");
            }
            repsuesta = LocalesRentaDatos.InsertatLocal(local);
            if (repsuesta == null){
                repsuesta = "Guardado exitosamente";
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        finally {
            return repsuesta;
        }
    }

    public String Actualizar (LocalesRenta local) throws Exception{
        String respuesta = "Error";
        try{
            if (local.getPrecio()<=0){
                throw new Exception("Error el precio del local no puede ser menor o igual a 0");
            }
            if (local.getTamaño()<=0){
                throw new SQLException("Error el tamaño del local no puede ser menor o igual a 0 ");
            }
            if (local.getDescripcion().isEmpty()){
                throw new SQLException("Error la descipcion no debe estar vacia");
            }
            respuesta = LocalesRentaDatos.ActualizarLocal(local);
            if (respuesta == null){
                respuesta = "Guardado exitosamente";
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
            throw new Exception(e.getMessage());
        }
        finally {
            return respuesta;
        }
    }

    public void Eliminar(LocalesRenta local) throws Exception{
        try{
            LocalesRentaDatos.EliminarLocal(local);
        }catch (SQLException e){
        }
    }

    public List<LocalesRenta> Buscar(LocalesRenta local) throws Exception {
        List<LocalesRenta> listaLocal = new ArrayList<>();
        try {
            if (local.getDescripcion().isEmpty()) {
                throw new Exception("Error la descripcion del local no puede estar vacia");
            }
            listaLocal = LocalesRentaDatos.BuscarLocales(local);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaLocal;
    }

}
