package BienesMuebles.datos.carros;

import BienesMuebles.datos.conexion.Conexion;
import BienesMuebles.recursos.clases.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrosDatos {


    public static List<Carro> LeerCarros(){
        List<Carro> listaDeCarros = new ArrayList<Carro>();

        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, NumeroPuertas , Color, NumeroDeSerieMotor, NombrePropietario FROM Carros";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Carro carro1 = new Carro();
                carro1.setPlaca(rs.getString(1));
                carro1.setNumeroDePuertas(rs.getInt(2));
                carro1.setColor(rs.getString(3));
                carro1.setNumeroDeSerieMotor(rs.getString(4));
                carro1.setNombrePropietario(rs.getString(5));
                listaDeCarros.add(carro1);
            }
            cn.close();

        }catch (Exception e){
        }
        return listaDeCarros;
        //-----
    }


    public static String InsertarCarro(Carro carro1){
        try {

            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Carros VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,carro1.getPlaca());
            ps.setInt(2,carro1.getNumeroDePuertas());
            ps.setString(3, carro1.getColor());
            ps.setString(4, carro1.getNumeroDeSerieMotor());
            ps.setString(5, carro1.getNombrePropietario());

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


    public static String ActualizarCarro(Carro carro1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Carros SET Placa = ?, NumeroPuertas = ?, Color = ?, NombrePropietario = ? WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, carro1.getPlaca());
            ps.setInt(2, carro1.getNumeroDePuertas());
            ps.setString(3, carro1.getColor());
            ps.setString(4, carro1.getNombrePropietario());
            ps.setString(5, carro1.getNumeroDeSerieMotor());

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


    public static String EliminarCarro(Carro carro1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Carros WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, carro1.getNumeroDeSerieMotor());
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


    public static List<Carro> BuscarCarro(Carro carro1)throws SQLException {
        List<Carro> listaCarros = new ArrayList<Carro>();
        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, NumeroPuertas, Color, NumeroDeSerieMotor, NombrePropietario FROM Carros WHERE NumeroDeSerieMotor LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%"+carro1.getNumeroDeSerieMotor()+"%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                do {
                    Carro carro2 = new Carro();
                    carro2.setPlaca(rs.getString(1));
                    carro2.setNumeroDePuertas(rs.getInt(2));
                    carro2.setColor(rs.getString(3));
                    carro2.setNumeroDeSerieMotor(rs.getString(4));
                    carro2.setNombrePropietario(rs.getString(5));

                    listaCarros.add(carro2);
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
        return listaCarros;
        //-----
    }


    //------------------------------------------------------------------------------------------------------------------
}
