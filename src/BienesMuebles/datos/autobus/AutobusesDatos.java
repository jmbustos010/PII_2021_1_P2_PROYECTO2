package BienesMuebles.datos.autobus;

import BienesMuebles.datos.conexion.Conexion;
import BienesMuebles.recursos.clases.Autobus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutobusesDatos {


    public static List<Autobus> LeerAutobuses(){
        List<Autobus> listaDeAutobuses = new ArrayList<Autobus>();

        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, NumeroAsientos, Color, NumeroDeSerieMotor, NombrePropietario FROM AutoBuses";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Autobus autobus1 = new Autobus();
                autobus1.setPlaca(rs.getString(1));
                autobus1.setNumeroAsientos(rs.getInt(2));
                autobus1.setColor(rs.getString(3));
                autobus1.setNumeroDeSerieMotor(rs.getString(4));
                autobus1.setNombrePropietario(rs.getString(5));
                listaDeAutobuses.add(autobus1);
            }
            cn.close();

        }catch (Exception e){
        }
        return listaDeAutobuses;
        //-----
    }


    public static String InsertarAutobus(Autobus autobus1){
        try {

            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Autobuses VALUES(?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,autobus1.getPlaca());
            ps.setInt(2,autobus1.getNumeroAsientos());
            ps.setString(3, autobus1.getColor());
            ps.setString(4, autobus1.getNumeroDeSerieMotor());
            ps.setString(5, autobus1.getNombrePropietario());

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


    public static String ActualizarAutobus(Autobus autobus1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Autobuses SET Placa = ?, NumeroAsientos = ?, Color = ?, NombrePropietario = ? WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, autobus1.getPlaca());
            ps.setInt(2, autobus1.getNumeroAsientos());
            ps.setString(3, autobus1.getColor());
            ps.setString(4, autobus1.getNombrePropietario());
            ps.setString(5, autobus1.getNumeroDeSerieMotor());

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


    public static String EliminarAutobus(Autobus autobus1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Autobuses WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, autobus1.getNumeroDeSerieMotor());
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


    public static List<Autobus> BuscarAutobus(Autobus autobus1)throws SQLException{
        List<Autobus> listaAutobuses = new ArrayList<Autobus>();
        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, NumeroAsientos, Color, NumeroDeSerieMotor, NombrePropietario FROM Autobuses WHERE NumeroDeSerieMotor LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%"+autobus1.getNumeroDeSerieMotor()+"%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                do {
                    Autobus autobus2 = new Autobus();
                    autobus2.setPlaca(rs.getString(1));
                    autobus2.setNumeroAsientos(rs.getInt(2));
                    autobus2.setColor(rs.getString(3));
                    autobus2.setNumeroDeSerieMotor(rs.getString(4));
                    autobus2.setNombrePropietario(rs.getString(5));

                    listaAutobuses.add(autobus2);
                }while (rs.next());
            }else{
                throw new  SQLException("Error no se encontro coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();

        }catch (SQLException e){
            throw new SQLException(e.getCause());
        }
        return listaAutobuses;
        //-----
    }


//----------------------------------------------------------------------------------------------------------------------
}
