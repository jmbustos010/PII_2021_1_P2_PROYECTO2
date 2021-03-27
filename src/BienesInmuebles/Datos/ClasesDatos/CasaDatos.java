package BienesInmuebles.Datos.ClasesDatos;

import BienesInmuebles.Datos.Conexion.Conexion;
import BienesInmuebles.Recursos.Clases.Casa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CasaDatos {
    public static List<Casa> leerCasas() throws SQLException {
        List<Casa> listaCasa = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT TipoDiseño, Tamaño, Descripcion, Ubicacion, Precio FROM Casa";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setTipoDiseño(rs.getString(1));
                casa.setTamaño(rs.getLong(2));
                casa.setDescripcion(rs.getString(3));
                casa.setUbicacion(rs.getString(4));
                casa.setPrecio(rs.getInt(5));
                listaCasa.add(casa);
            }
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return listaCasa;
    }

    public static String InsertarCasa(Casa casa) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Casa VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, casa.getTipoDiseño());
            ps.setLong(2, casa.getTamaño());
            ps.setString(3, casa.getDescripcion());
            ps.setString(4, casa.getUbicacion());
            ps.setInt(5,casa.getPrecio());
            ps.execute();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String ActualizarCasa(Casa casa) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Casa SET Tamaño = ?, Descripcion = ?, Ubicacion = ?, Precio = ? WHERE TipoDiseño = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, casa.getTamaño());
            ps.setString(2, casa.getDescripcion());
            ps.setString(3,casa.getUbicacion());
            ps.setInt(4, casa.getPrecio());
            ps.setString(5,casa.getTipoDiseño());
            ps.execute();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String EliminarCasa(Casa casa) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Casa WHERE TipoDiseño = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,casa.getTipoDiseño());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static List<Casa> BuscarCasa (Casa casa) throws SQLException{
        List<Casa> listaCasa = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT TipoDiseño, Tamaño, Descripcion, Ubicacion, Precio FROM Casa WHERE UPPER(TipoDiseño) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%" + casa.getTipoDiseño() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Casa casa1 = new Casa();
                    casa1.setTipoDiseño(rs.getString(1));
                    casa1.setTamaño(rs.getLong(2));
                    casa1.setDescripcion(rs.getString(3));
                    casa1.setUbicacion(rs.getString(4));
                    casa1.setPrecio(rs.getInt(5));
                    listaCasa.add(casa1);
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
        return listaCasa;
    }


}
