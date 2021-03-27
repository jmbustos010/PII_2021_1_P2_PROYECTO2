package PropiedadIntelectual.negocio.Cancion;

import PropiedadIntelectual.datos.Cancion.CancionDatos;
import PropiedadIntelectual.recursos.ClasesCancion.Cancion;

import java.util.ArrayList;
import java.util.List;

public class CancionNegocios {
    public List<Cancion> leer(){
        List<Cancion> listaCanciones = new ArrayList<>();
        try{
            listaCanciones = CancionDatos.leerCanciones();
        }catch(Exception e){
        }
        return listaCanciones;
    }

    public String Insertar(Cancion cancion){
        String respuesta = "Error";
        try{
            if(cancion.getNombre().isEmpty()){
                throw new Exception("Error! El nombre no puede estar vacio");
            }
            if(cancion.getAutor().isEmpty()){
                throw new Exception("Error! El autor no puede estar vacio");
            }
            if(cancion.getGenero().isEmpty()){
                throw new Exception("Error! El genero no puede estar vacio");
            }
            if(cancion.getFechaPublicada().toString().isEmpty()) {
                throw new Exception("Error! La fecha no puede estar vacia");
            }
            respuesta = CancionDatos.InsertarCancion(cancion);
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

    public void Actualizar(Cancion cancion){
        try{
            CancionDatos.ActualizarCancion(cancion);
            if(cancion.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio");
            }
            if(cancion.getAutor().isEmpty()){
                throw new Exception("Error! El autor esta vacio");
            }
            if(cancion.getGenero().isEmpty()){
                throw new Exception("Error! El genero esta vacio");
            }
            if(cancion.getFechaPublicada().toString().isEmpty()) {
                throw new Exception("Error! La fecha esta vacia");
            }
        }catch(Exception e){
        }
    }

    public void Eliminar(Cancion cancion){
        try{
            CancionDatos.EliminarCancion(cancion);
            if(cancion.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio y no se pudo eliminar");
            }
        }catch (Exception e){
        }
    }

    public List<Cancion> Buscar(Cancion cancion) throws Exception{
        List<Cancion> listaCanciones = new ArrayList<Cancion>();
        try{
            if(cancion.getNombre().isEmpty()){
                throw new Exception("Error! El nombre esta vacio y no se pudo buscar");
            }
            listaCanciones = CancionDatos.BuscarCancion(cancion);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return listaCanciones;
    }
}
