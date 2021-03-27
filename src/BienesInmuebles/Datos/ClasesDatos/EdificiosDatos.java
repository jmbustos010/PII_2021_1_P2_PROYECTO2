package BienesInmuebles.Datos.ClasesDatos;

import BienesInmuebles.Datos.Conexion.Conexion;
import BienesInmuebles.Recursos.Clases.Edificios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EdificiosDatos {

    public static List<Edificios> leerEdificios() throws SQLException{
        List<Edificios> listaEdificios = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT TipoConstruccion, Tamaño, Descripcion, Ubicacion, Altura, Precio FROM Edificios";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Edificios edificios = new Edificios();
                edificios.setTipoConstruccion(rs.getString(1));
                edificios.setTamaño(rs.getLong(2));
                edificios.setDescripcion(rs.getString(3));
                edificios.setUbicacion(rs.getString(4));
                edificios.setAltura(rs.getInt(5));
                edificios.setPrecio(rs.getInt(6));
                listaEdificios.add(edificios);
            }
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaEdificios;
    }

    public static String InsertarEdificio(Edificios edificios) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Edificios VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,edificios.getTipoConstruccion());
            ps.setLong(2,edificios.getTamaño());
            ps.setString(3,edificios.getDescripcion());
            ps.setString(4,edificios.getUbicacion());
            ps.setInt(5,edificios.getAltura());
            ps.setInt(6,edificios.getPrecio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return  null;
    }

    public static String ActualizarEdificios(Edificios edificios) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Edificios SET Tamaño = ?, Descripcion = ?, Ubicacion = ?, Altura = ?, Precio = ? WHERE TipoConstruccion = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,edificios.getTamaño());
            ps.setString(2,edificios.getDescripcion());
            ps.setString(3,edificios.getUbicacion());
            ps.setInt(4,edificios.getAltura());
            ps.setInt(5,edificios.getPrecio());
            ps.setString(6,edificios.getTipoConstruccion());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String EliminarEdificio (Edificios edificios) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Edificios WHERE TipoConstruccion = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,edificios.getTipoConstruccion());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static List<Edificios> BuscarEdificio (Edificios edificios) throws SQLException{
        List<Edificios> listaEdificio = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql  = "SELECT TipoConstruccion, Tamaño, Descripcion, Ubicacion, Altura, Precio FROM Edificios WHERE UPPER(TipoConstruccion) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%" + edificios.getTipoConstruccion() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Edificios edificioObjeto = new Edificios();
                    edificioObjeto.setTipoConstruccion(rs.getString(1));
                    edificioObjeto.setTamaño(rs.getLong(2));
                    edificioObjeto.setDescripcion(rs.getString(3));
                    edificioObjeto.setUbicacion(rs.getString(4));
                    edificioObjeto.setAltura(rs.getInt(5));
                    edificioObjeto.setPrecio(rs.getInt(6));
                    listaEdificio.add(edificioObjeto);

                }while(rs.next());
            }else{
                throw new SQLException("Error no se encontro coincidencia");
            }
            cn.close();
            rs.close();
            ps.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaEdificio;
    }
}

