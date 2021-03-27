package BienesMuebles.datos.motocicletas;

import BienesMuebles.datos.conexion.Conexion;
import BienesMuebles.recursos.clases.Motocicleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotocicletasDatos {

    public static List<Motocicleta> LeerMotocicletas(){
        List<Motocicleta> listaDeMotocicletas = new ArrayList<Motocicleta>();

        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, Color, Kilometraje, NumeroDeSerieMotor, Marca, NombrePropietario FROM Motocicletas";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Motocicleta motocicleta1 = new Motocicleta();
                motocicleta1.setPlaca(rs.getString(1));
                motocicleta1.setColor(rs.getString(2));
                motocicleta1.setKilometraje(rs.getInt(3));
                motocicleta1.setNumeroDeSerieMotor(rs.getString(4));
                motocicleta1.setMarca(rs.getString(5));
                motocicleta1.setNombrePropietario(rs.getString(6));
                listaDeMotocicletas.add(motocicleta1);
            }
            cn.close();

        }catch (Exception e){
        }
        return listaDeMotocicletas;
        //-----
    }


    public static String InsertarMotocicleta(Motocicleta motocicleta1){
        try {

            Connection cn = Conexion.ObtenerConexion();
            String sql = "INSERT INTO Motocicletas VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,motocicleta1.getPlaca());
            ps.setString(2, motocicleta1.getColor());
            ps.setInt(3,motocicleta1.getKilometraje());
            ps.setString(4, motocicleta1.getNumeroDeSerieMotor());
            ps.setString(5, motocicleta1.getMarca());
            ps.setString(6, motocicleta1.getNombrePropietario());

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


    public static String ActualizarMotocicleta(Motocicleta motocicleta1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "UPDATE Motocicletas SET Placa = ?, Color  = ?, Kilometraje = ?, Marca = ?, NombrePropietario = ? WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, motocicleta1.getPlaca());
            ps.setString(2, motocicleta1.getColor());
            ps.setInt(3, motocicleta1.getKilometraje());
            ps.setString(4, motocicleta1.getMarca());
            ps.setString(5, motocicleta1.getNombrePropietario());
            ps.setString(6, motocicleta1.getNumeroDeSerieMotor());

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


    public static String EliminarMotocicleta(Motocicleta motocicleta1){
        try {
            Connection cn = Conexion.ObtenerConexion();
            String sql = "DELETE FROM Motocicletas WHERE NumeroDeSerieMotor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, motocicleta1.getNumeroDeSerieMotor());
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


    public static List<Motocicleta> BuscarMotocicleta(Motocicleta motocicleta1)throws SQLException {
        List<Motocicleta> listaMotocicletas = new ArrayList<Motocicleta>();
        try {
            Connection cn = Conexion.ObtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Placa, Color, Kilometraje, NumeroDeSerieMotor, Marca, NombrePropietario FROM Motocicletas WHERE NumeroDeSerieMotor LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%"+motocicleta1.getNumeroDeSerieMotor()+"%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                do {
                    Motocicleta motocicleta2 = new Motocicleta();
                    motocicleta2.setPlaca(rs.getString(1));
                    motocicleta2.setColor(rs.getString(2));
                    motocicleta2.setKilometraje(rs.getInt(3));
                    motocicleta2.setNumeroDeSerieMotor(rs.getString(4));
                    motocicleta2.setMarca(rs.getString(5));
                    motocicleta2.setNombrePropietario(rs.getString(6));

                    listaMotocicletas.add(motocicleta2);
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
        return listaMotocicletas;
        //-----
    }
    //------------------------------------------------------------------------------------------------------------------
}
