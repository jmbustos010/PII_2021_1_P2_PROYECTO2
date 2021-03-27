package PropiedadIntelectual.negocio.Patentes;

import PropiedadIntelectual.datos.Patentes.PatentesDatos;
import PropiedadIntelectual.recursos.ClasesPatentes.Patentes;

import java.util.ArrayList;
import java.util.List;

public class PatentesNegocios {
    public List<Patentes> leer(){
        List<Patentes> listaPatentes = new ArrayList<>();
        try{
            listaPatentes = PatentesDatos.leerPatentes();
        }catch(Exception e){
        }
        return listaPatentes;
    }

    public String Insertar(Patentes patentes){
        String respuesta = "Error";
        try{
            if(patentes.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            if(patentes.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(patentes.getDescripcion().isEmpty()){
                throw new Exception("Error! La descripcion no puede estar vacio");
            }
            if(patentes.getPropietario().isEmpty()){
                throw new Exception("Error! El propietario no puede estar vacio");
            }
            if(patentes.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
            respuesta = PatentesDatos.InsertarPatentes(patentes);
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

    public void Actualizar(Patentes patentes){
        try{
            PatentesDatos.ActualizarPatentes(patentes);
            if(patentes.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            if(patentes.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(patentes.getDescripcion().isEmpty()){
                throw new Exception("Error! La descripcion no puede estar vacio");
            }
            if(patentes.getPropietario().isEmpty()){
                throw new Exception("Error! El propietario no puede estar vacio");
            }
            if(patentes.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
        }catch(Exception e){
        }
    }

    public void Eliminar(Patentes patentes){
        try{
            PatentesDatos.EliminarPatentes(patentes);
            if(patentes.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
        }catch (Exception e){
        }
    }

    public List<Patentes> Buscar(Patentes patentes) throws Exception{
        List<Patentes> listaPatentes = new ArrayList<Patentes>();
        try{
            if(patentes.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            listaPatentes = PatentesDatos.BuscarPatentes(patentes);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaPatentes;
    }
}
