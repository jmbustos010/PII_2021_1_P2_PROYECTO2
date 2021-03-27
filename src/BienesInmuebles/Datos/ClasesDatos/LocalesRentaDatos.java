package BienesInmuebles.Datos.ClasesDatos;

import BienesInmuebles.Datos.Conexion.Conexion;
import BienesInmuebles.Recursos.Clases.LocalesRenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalesRentaDatos {

    public static List<LocalesRenta> leerLocales() throws SQLException {
        List<LocalesRenta> listaLocales = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Precio, Tamaño, Descripcion, Ubicacion FROM LocalesRenta ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                LocalesRenta local = new LocalesRenta();
                local.setPrecio(rs.getInt(1));
                local.setTamaño(rs.getLong(2));
                local.setDescripcion(rs.getString(3));
                local.setUbicacion(rs.getString(4));
                listaLocales.add(local);
            }
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return listaLocales;
    }

    public static String InsertatLocal(LocalesRenta localRenta) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO LocalesRenta VALUES (?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, localRenta.getPrecio());
            ps.setLong(2, localRenta.getTamaño());
            ps.setString(3, localRenta.getDescripcion());
            ps.setString(4, localRenta.getUbicacion());
            ps.execute();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String ActualizarLocal(LocalesRenta localRenta) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE LocalesRenta SET Tamaño = ?, Descripcion = ?, Ubicacion = ? WHERE Precio = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, localRenta.getTamaño());
            ps.setString(2, localRenta.getDescripcion());
            ps.setString(3,localRenta.getUbicacion());
            ps.setInt(4,localRenta.getPrecio());
            ps.execute();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String EliminarLocal(LocalesRenta localRenta) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM LocalesRenta WHERE Precio = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,localRenta.getPrecio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static List<LocalesRenta> BuscarLocales (LocalesRenta localRenta) throws SQLException{
        List<LocalesRenta> listaLocales = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Precio, Tamaño, Descripcion, Ubicacion FROM LocalesRenta WHERE UPPER(Descripcion) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%" + localRenta.getDescripcion() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    LocalesRenta localObejto = new LocalesRenta();
                    localObejto.setPrecio(rs.getInt(1));
                    localObejto.setTamaño(rs.getLong(2));
                    localObejto.setDescripcion(rs.getString(3));
                    localObejto.setUbicacion(rs.getString(4));
                    listaLocales.add(localObejto);

                }while (rs.next());

            }else{
                throw new SQLException("Error no se encontro coincidencia");
            }
            cn.close();
            rs.close();
            ps.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaLocales;
    }
}





