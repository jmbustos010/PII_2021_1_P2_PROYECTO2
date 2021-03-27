package PropiedadIntelectual.negocio.Marca;

import PropiedadIntelectual.datos.Marca.MarcaDatos;
import PropiedadIntelectual.recursos.ClasesMarca.Marca;

import java.util.ArrayList;
import java.util.List;

public class MarcaNegocios {
    public List<Marca> leer(){
        List<Marca> listaMarcas = new ArrayList<>();
        try{
            listaMarcas = MarcaDatos.leerMarca();
        }catch(Exception e){
        }
        return listaMarcas;
    }

    public String Insertar(Marca marcas){
        String respuesta = "Error";
        try{
            if(marcas.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            if(marcas.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(marcas.getPropietario().isEmpty()){
                throw new Exception("Error! El propietario no puede estar vacio");
            }
            if(marcas.getSede().isEmpty()){
                throw new Exception("Error! La sede no puede estar vacio");
            }
            if(marcas.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
            respuesta = MarcaDatos.InsertarMarca(marcas);
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

    public void Actualizar(Marca marcas){
        try{
            MarcaDatos.ActualizarMarcas(marcas);
            if(marcas.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            if(marcas.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(marcas.getPropietario().isEmpty()){
                throw new Exception("Error! El propietario no puede estar vacio");
            }
            if(marcas.getSede().isEmpty()){
                throw new Exception("Error! La sede no puede estar vacio");
            }
            if(marcas.getFechaCreacion().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
        }catch(Exception e){
        }
    }

    public void Eliminar(Marca marcas){
        try{
            MarcaDatos.EliminarMarcas(marcas);
            if(marcas.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
        }catch (Exception e){
        }
    }

    public List<Marca> Buscar(Marca marcas) throws Exception{
        List<Marca> listaMarcas = new ArrayList<Marca>();
        try{
            if(marcas.getId()<= 0){
                throw new Exception("Error! El Id no puede ser menor o igual a 0");
            }
            listaMarcas = MarcaDatos.BuscarMarcas(marcas);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaMarcas;
    }
}
