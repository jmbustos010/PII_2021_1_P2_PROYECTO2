package PropiedadIntelectual.datos.Patentes;

import PropiedadIntelectual.datos.Conexion.Conexion;
import PropiedadIntelectual.recursos.ClasesPatentes.Patentes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatentesDatos {
    public static List<Patentes> leerPatentes(){
        List<Patentes> listaPatentes = new ArrayList<Patentes>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, Descripcion, Propietario, FechaCreacion FROM Patentes";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Patentes patentes = new Patentes();
                patentes.setId(rs.getLong(1));
                patentes.setNombre(rs.getString(2));
                patentes.setDescripcion(rs.getString(3));
                patentes.setPropietario(rs.getString(4));
                patentes.setFechaCreacion(rs.getDate(5));
                listaPatentes.add(patentes);
            }
            cn.close();

        }catch(Exception e){
        }
        return listaPatentes;
    }
    public static String InsertarPatentes(Patentes patentes){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Patentes VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, patentes.getId());
            ps.setString(2, patentes.getNombre());
            ps.setString(3, patentes.getDescripcion());
            ps.setString(4, patentes.getPropietario());
            ps.setDate(5, new Date (patentes.getFechaCreacion().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }
    public static String ActualizarPatentes(Patentes patentes){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Patentes SET Nombre = ?, Descripcion = ?, Propietario = ?, FechaCreacion = ? WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,patentes.getNombre());
            ps.setString(2,patentes.getDescripcion());
            ps.setString(3, patentes.getPropietario());
            ps.setDate(4, new Date(patentes.getFechaCreacion().getTime()));
            ps.setLong(5, patentes.getId());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static String EliminarPatentes(Patentes patentes){
        try{
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Patentes WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,patentes.getId());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error! " + e.getMessage();
        }
        return null;
    }

    public static List<Patentes> BuscarPatentes(Patentes patentes) throws SQLException {
        List<Patentes> listaPatentes = new ArrayList<Patentes>();
        try{
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, Descripcion, Propietario, FechaCreacion FROM Patentes WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,patentes.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                do {
                    Patentes patentesObjetos = new Patentes();
                    patentesObjetos.setId(rs.getLong(1));
                    patentesObjetos.setNombre(rs.getString(2));
                    patentesObjetos.setDescripcion(rs.getString(3));
                    patentesObjetos.setPropietario(rs.getString(4));
                    patentesObjetos.setFechaCreacion(rs.getDate(5));
                    listaPatentes.add(patentesObjetos);
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
        return listaPatentes;
    }
}
