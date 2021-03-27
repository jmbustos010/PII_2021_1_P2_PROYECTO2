package BienesInmuebles.Datos.ClasesDatos;

import BienesInmuebles.Datos.Conexion.Conexion;
import BienesInmuebles.Recursos.Clases.Terrenos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrenosDatos {


    public static List<Terrenos> leerTerrenos() throws SQLException{
        List<Terrenos> listaTerrenos = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT TipoSuelo, Tamaño, Descripcion, Ubicacion, Precio FROM Terrenos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Terrenos terreno = new Terrenos();
                terreno.setTipoSuelo(rs.getString(1));
                terreno.setTamaño(rs.getLong(2));
                terreno.setDescripcion(rs.getString(3));
                terreno.setUbicacion(rs.getString(4));
                terreno.setPrecio(rs.getInt(5));
                listaTerrenos.add(terreno);
            }
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaTerrenos;
    }

    public static String InsertarTerreno(Terrenos terreno) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Terrenos VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,terreno.getTipoSuelo());
            ps.setLong(2,terreno.getTamaño());
            ps.setString(3,terreno.getDescripcion());
            ps.setString(4,terreno.getUbicacion());
            ps.setInt(5,terreno.getPrecio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return  null;
    }

    public static String ActualizarTerrenos(Terrenos terreno) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Terrenos SET Tamaño = ?, Descripcion = ?, Ubicacion = ?, Precio = ? WHERE TipoSuelo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,terreno.getTamaño());
            ps.setString(2,terreno.getDescripcion());
            ps.setString(3,terreno.getUbicacion());
            ps.setInt(4,terreno.getPrecio());
            ps.setString(5,terreno.getTipoSuelo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static String EliminarTerreno (Terrenos terreno) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Terrenos WHERE Tiposuelo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,terreno.getTipoSuelo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }

    public static List<Terrenos> BuscarTerrenos (Terrenos terreno) throws SQLException{
        List<Terrenos> listaTerrenos = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql  = "SELECT Tiposuelo, Tamaño, Descripcion, Ubicacion, Precio FROM Terrenos WHERE UPPER(TipoSuelo) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%" + terreno.getTipoSuelo().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Terrenos terrenoObjeto = new Terrenos();
                    terrenoObjeto.setTipoSuelo(rs.getString(1));
                    terrenoObjeto.setTamaño(rs.getLong(2));
                    terrenoObjeto.setDescripcion(rs.getString(3));
                    terrenoObjeto.setUbicacion(rs.getString(4));
                    terrenoObjeto.setPrecio(rs.getInt(5));
                    listaTerrenos.add(terrenoObjeto);

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
        return listaTerrenos;
    }
}
