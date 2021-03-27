package PropiedadIntelectual.negocio.Software;

import PropiedadIntelectual.datos.Software.SoftwareDatos;
import PropiedadIntelectual.recursos.ClasesSoftware.Software;

import java.util.ArrayList;
import java.util.List;

public class SoftwareNegocios {
    public List<Software> leer(){
        List<Software> listaSoftware = new ArrayList<>();
        try{
            listaSoftware = SoftwareDatos.leerSoftware();
        }catch(Exception e){
        }
        return listaSoftware;
    }

    public String Insertar(Software software){
        String respuesta = "Error";
        try{
            if(software.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(software.getDescripcion().isEmpty()){
                throw new Exception("Error! La descripcion no puede estar vacio");
            }
            if(software.getDispositivo().isEmpty()){
                throw new Exception("Error! El dispositivo no puede estar vacio");
            }
            if(software.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
            respuesta = SoftwareDatos.InsertarSoftware(software);
            if(respuesta == null){
                respuesta = "Guardado exitosamente";
            }
        }catch(Exception e){
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }
    }

    public void Actualizar(Software software){
        try{
            SoftwareDatos.ActualizarSoftware(software);
            if(software.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio");
            }
            if(software.getDescripcion().isEmpty()){
                throw new Exception("Error! La descripcion esta vacia");
            }
            if(software.getDispositivo().isEmpty()){
                throw new Exception("Error! El dispositivo esta vacio");
            }
            if(software.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha esta vacia");
            }
        }catch(Exception e){
        }
    }

    public void Eliminar(Software software){
        try{
            SoftwareDatos.EliminarSoftware(software);
            if(software.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio, no se puede eliminar");
            }
        }catch (Exception e){
        }
    }

    public List<Software> Buscar(Software software) throws Exception{
        List<Software> listaSoftware = new ArrayList<Software>();
        try{
            if(software.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio y no se pudo buscar");
            }
            listaSoftware = SoftwareDatos.BuscarSoftware(software);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaSoftware;
    }
}
