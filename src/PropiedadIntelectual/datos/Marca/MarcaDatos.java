package PropiedadIntelectual.datos.Marca;

import PropiedadIntelectual.datos.Conexion.Conexion;
import PropiedadIntelectual.recursos.ClasesMarca.Marca;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDatos {
    public static List<Marca> leerMarca(){
        List<Marca> listaMarca = new ArrayList<Marca>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, Propietario, Sede, FechaCreacion FROM Marca";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Marca marcas = new Marca();
                marcas.setId(rs.getLong(1));
                marcas.setNombre(rs.getString(2));
                marcas.setPropietario(rs.getString(3));
                marcas.setSede(rs.getString(4));
                marcas.setFechaCreacion(rs.getDate(5));
                listaMarca.add(marcas);
            }
            cn.close();

        }catch(Exception e){
        }
        return listaMarca;
    }
    public static String InsertarMarca(Marca marcas){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Marca VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, marcas.getId());
            ps.setString(2, marcas.getNombre());
            ps.setString(3, marcas.getPropietario());
            ps.setString(4, marcas.getSede());
            ps.setDate(5, new Date (marcas.getFechaCreacion().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarMarcas(Marca marcas){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Marca SET Nombre = ?, Propietario = ?, Sede = ?, FechaCreacion = ? WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, marcas.getNombre());
            ps.setString(2, marcas.getPropietario());
            ps.setString(3, marcas.getSede());
            ps.setDate(4, new Date (marcas.getFechaCreacion().getTime()));
            ps.setLong(5, marcas.getId());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static String EliminarMarcas(Marca marcas){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Marca WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,marcas.getId());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static List<Marca> BuscarMarcas(Marca marcas) throws SQLException {
        List<Marca> listaMarcas = new ArrayList<Marca>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, Propietario, Sede, FechaCreacion FROM Marca WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,marcas.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                do {
                    Marca marcasObjetos = new Marca();
                    marcasObjetos.setId(rs.getLong(1));
                    marcasObjetos.setNombre(rs.getString(2));
                    marcasObjetos.setPropietario(rs.getString(3));
                    marcasObjetos.setSede(rs.getString(4));
                    marcasObjetos.setFechaCreacion(rs.getDate(5));
                    listaMarcas.add(marcasObjetos);
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
        return listaMarcas;
    }
}
