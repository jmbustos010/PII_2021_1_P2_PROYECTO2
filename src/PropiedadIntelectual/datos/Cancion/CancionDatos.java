package PropiedadIntelectual.datos.Cancion;

import PropiedadIntelectual.datos.Conexion.Conexion;
import PropiedadIntelectual.recursos.ClasesCancion.Cancion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancionDatos {
    public static List<Cancion> leerCanciones(){
        List<Cancion> listaCanciones = new ArrayList<Cancion>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Autor, Genero, FechaPublicada FROM Cancion";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Cancion canciones = new Cancion();
                canciones.setNombre(rs.getString(1));
                canciones.setAutor(rs.getString(2));
                canciones.setGenero(rs.getString(3));
                canciones.setFechaPublicada(rs.getDate(4));
                listaCanciones.add(canciones);
            }
            cn.close();

        }catch(Exception e){
        }
        return listaCanciones;
    }
    public static String InsertarCancion(Cancion canciones){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Cancion VALUES(?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, canciones.getNombre());
            ps.setString(2, canciones.getAutor());
            ps.setString(3, canciones.getGenero());
            ps.setDate(4, new Date (canciones.getFechaPublicada().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarCancion(Cancion canciones){
        try{
        Connection cn = Conexion.ObtenerConexion();
        String sql = "UPDATE Cancion SET Autor = ?, Genero = ?, FechaPublicada = ? WHERE Nombre = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1,canciones.getAutor());
        ps.setString(2,canciones.getGenero());
        ps.setDate(3, new Date(canciones.getFechaPublicada().getTime()));
        ps.setString(4, canciones.getNombre());
        ps.execute();
        ps.close();
        cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static String EliminarCancion(Cancion canciones){
        try{
        Connection cn = Conexion.ObtenerConexion();
        String sql = "DELETE FROM Cancion WHERE Nombre = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1,canciones.getNombre());
        ps.execute();
        ps.close();
        cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static List<Cancion> BuscarCancion(Cancion canciones) throws SQLException {
        List<Cancion> listaCanciones = new ArrayList<Cancion>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Autor, Genero, FechaPublicada FROM Cancion WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+ canciones.getNombre().toUpperCase() +"%");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                do {
                    Cancion cancionesObjetos = new Cancion();
                    cancionesObjetos.setNombre(rs.getString(1));
                    cancionesObjetos.setAutor(rs.getString(2));
                    cancionesObjetos.setGenero(rs.getString(3));
                    cancionesObjetos.setFechaPublicada(rs.getDate(4));
                    listaCanciones.add(cancionesObjetos);
                }while (rs.next());
            }
            else {
                throw new SQLException("Error no se encontro coincidencia");
            }
            cn.close();
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaCanciones;
    }
}
