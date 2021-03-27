package PropiedadIntelectual.datos.Software;

import PropiedadIntelectual.datos.Conexion.Conexion;
import PropiedadIntelectual.recursos.ClasesSoftware.Software;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoftwareDatos {
    public static List<Software> leerSoftware(){
        List<Software> listaSoftware = new ArrayList<Software>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Descripcion, Dispositivo, FechaCreacion FROM Software";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Software software = new Software();
                software.setNombre(rs.getString(1));
                software.setDescripcion(rs.getString(2));
                software.setDispositivo(rs.getString(3));
                software.setFechaCreacion(rs.getDate(4));
                listaSoftware.add(software);
            }
            cn.close();

        }catch(Exception e){
        }
        return listaSoftware;
    }
    public static String InsertarSoftware(Software softwares){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Software VALUES(?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, softwares.getNombre());
            ps.setString(2, softwares.getDescripcion());
            ps.setString(3, softwares.getDispositivo());
            ps.setDate(4, new Date (softwares.getFechaCreacion().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarSoftware(Software softwares){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Software SET Descripcion = ?, Dispositivo = ?, FechaCreacion = ? WHERE Nombre = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,softwares.getDescripcion());
            ps.setString(2,softwares.getDispositivo());
            ps.setDate(3, new Date(softwares.getFechaCreacion().getTime()));
            ps.setString(4, softwares.getNombre());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static String EliminarSoftware(Software softwares){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Software WHERE Nombre = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,softwares.getNombre());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static List<Software> BuscarSoftware(Software softwares) throws SQLException {
        List<Software> listaSoftware = new ArrayList<Software>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Descripcion, Dispositivo, FechaCreacion FROM Software WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+ softwares.getNombre().toUpperCase() +"%");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                do {
                    Software softwareObjetos = new Software();
                    softwareObjetos.setNombre(rs.getString(1));
                    softwareObjetos.setDescripcion(rs.getString(2));
                    softwareObjetos.setDispositivo(rs.getString(3));
                    softwareObjetos.setFechaCreacion(rs.getDate(4));
                    listaSoftware.add(softwareObjetos);
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
        return listaSoftware;
    }
}
