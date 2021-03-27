package BienesMuebles.datos.aviones;


import BienesMuebles.datos.conexion.Conexion;
import BienesMuebles.recursos.clases.Avion;
import BienesMuebles.recursos.clases.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionesDatos {

    public static List<Avion> LeerAviones(){
        List<Avion> listaDeAviones = new ArrayList<Avion>();

        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT  Id, NumeroDeMotores, CapacidadDePeso , NombrePropietario, TipoDeAvion FROM Aviones";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Avion avion1 = new Avion();
                avion1.setId(rs.getInt(1));
                avion1.setNumeroDeMotores(rs.getInt(2));
                avion1.setCapacidadDePeso(rs.getInt(3));
                avion1.setNombrePropietario(rs.getString(4));
                avion1.setTipoDeAvion(rs.getString(5));
                listaDeAviones.add(avion1);
            }
            cn.close();

        }catch (Exception e){
        }
        return listaDeAviones;
        //-----
    }


    public static String InsertarAvion(Avion avion1){
        try {

            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Aviones VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,avion1.getId());
            ps.setInt(2,avion1.getNumeroDeMotores());
            ps.setInt(3, avion1.getCapacidadDePeso());
            ps.setString(4, avion1.getNombrePropietario());
            ps.setString(5, avion1.getTipoDeAvion());

            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
        return null;
        //-----
    }


    public static String ActualizarAvion(Avion avion1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Aviones SET NumeroDeMotores = ?, CapacidadDePeso = ?, TipoDeAvion = ?,  NombrePropietario = ? WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, avion1.getNumeroDeMotores());
            ps.setInt(2, avion1.getCapacidadDePeso());
            ps.setString(3, avion1.getTipoDeAvion());
            ps.setString(4, avion1.getNombrePropietario());
            ps.setInt(5, avion1.getId());

            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error: "+e.getMessage();
        }
        return null;
        //-----
    }


    public static String EliminarAvion(Avion avion1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Aviones WHERE Id  = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, avion1.getId());
            ps.execute();
            ps.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
        return null;
        //-----
    }


    public static List<Avion> BuscarAvion(Avion avion1)throws SQLException {
        List<Avion> listaAviones = new ArrayList<Avion>();
        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, NumeroDeMotores, CapacidadDePeso, NombrePropietario, TipoDeAvion FROM Aviones WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, avion1.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                do {
                    Avion avion2 = new Avion();
                    avion2.setId(rs.getInt(1));
                    avion2.setNumeroDeMotores(rs.getInt(2));
                    avion2.setCapacidadDePeso(rs.getInt(3));
                    avion2.setNombrePropietario(rs.getString(4));
                    avion2.setTipoDeAvion(rs.getString(5));

                    listaAviones.add(avion2);
                }while (rs.next());
            }else{
                throw new SQLException("Error no se encontro coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();

        }catch (SQLException e){
            throw new SQLException(e.getCause());
        }
        return listaAviones;
        //-----
    }

    //------------------------------------------------------------------------------------------------------------------
}
