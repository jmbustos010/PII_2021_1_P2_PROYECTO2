package BienesMuebles.gui.motocicleta;



import BienesMuebles.recursos.clases.Item;
import BienesMuebles.recursos.clases.Motocicleta;
import BienesMuebles.registro.motocicleta.MotocicletaRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmMotocicleta {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierda;
    private JLabel lblPlaca;
    private JLabel lblKilometraje;
    private JLabel lblColor;
    private JLabel lblNumeroSerieMotor;
    private JLabel lblNombrePropietario;
    private JPanel jpaInferior;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JPanel jpaDerecha;
    private JTextField txtPlaca;
    private JTextField txtKilometraje;
    private JTextField txtColor;
    private JTextField txtNombrePropietario;
    private JTextField txtNumeroDeSerieMotor;
    private JPanel jpaSuperior;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLimpiarCasillas;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblListaPropietarios;
    private JComboBox cboMotocicletas;
    private JButton btnLeerCombo;

    DefaultTableModel modelo;

    public frmMotocicleta() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Motocicleta motocicleta1 = new Motocicleta();
                    motocicleta1.setPlaca(txtPlaca.getText());
                    motocicleta1.setColor(txtColor.getText());
                    motocicleta1.setKilometraje(Integer.parseInt(txtKilometraje.getText()));
                    motocicleta1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    motocicleta1.setMarca(txtMarca.getText());
                    motocicleta1.setNombrePropietario(txtNombrePropietario.getText());
                    String respuesta = new MotocicletaRegistro().Insertar(motocicleta1);

                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null, "Guardado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw new Exception(respuesta);
                    }

                    LeerDatos();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                //-----
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeerDatos();
                //-----
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();

                txtPlaca.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtColor.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtKilometraje.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtNumeroDeSerieMotor.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtMarca.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtNombrePropietario.setText(modelo.getValueAt(filaSeleccionada, 5).toString());

            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtKilometraje.setText("");
                txtColor.setText("");
                txtNumeroDeSerieMotor.setText("");
                txtMarca.setText("");
                txtNombrePropietario.setText("");

            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Motocicleta motocicleta1 = new Motocicleta();
                    motocicleta1.setPlaca(txtPlaca.getText());
                    motocicleta1.setColor(txtColor.getText());
                    motocicleta1.setKilometraje(Integer.parseInt(txtKilometraje.getText()));
                    motocicleta1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    motocicleta1.setMarca(txtMarca.getText());
                    motocicleta1.setNombrePropietario(txtNombrePropietario.getText());


                    String respuesta = new MotocicletaRegistro().Actualizar(motocicleta1);

                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null, "Actualizado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw new Exception(respuesta);
                    }

                    LeerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                //-----
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Motocicleta motocicleta1 = new Motocicleta();
                    motocicleta1.setPlaca(txtPlaca.getText());
                    motocicleta1.setColor(txtColor.getText());
                    motocicleta1.setKilometraje(Integer.parseInt(txtKilometraje.getText()));
                    motocicleta1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    motocicleta1.setMarca(txtMarca.getText());
                    motocicleta1.setNombrePropietario(txtNombrePropietario.getText());

                    String respuesta = new MotocicletaRegistro().Eliminar(motocicleta1);

                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null, "Eliminado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw new Exception(respuesta);
                    }

                    LeerDatos();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                //-----
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Motocicleta motocicleta1 = new Motocicleta();
                    motocicleta1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());

                    List<Motocicleta> listaMotocicletas = new MotocicletaRegistro().Buscar(motocicleta1);
                    modelo.setRowCount(0);

                    for (Motocicleta motocicleta2 : listaMotocicletas) {
                        Object[] registroLeido = {motocicleta2.getPlaca(), motocicleta2.getColor(), motocicleta2.getKilometraje(), motocicleta2.getNumeroDeSerieMotor(), motocicleta2.getMarca(), motocicleta2.getNombrePropietario()};
                        modelo.addRow(registroLeido);
                    }

                    tblDatos.setModel(modelo);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                //-----
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboMotocicletas.getSelectedItem();
                String  itemMotocicleta = ((Item)objeto).getNumeroDeSerieMotor();
                JOptionPane.showMessageDialog(null, "El numero de serie de motor de la motocicleta de "+
                        ((Item) objeto).getNombrePropietario()+" es: "+itemMotocicleta);
            }
        });
    }

    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Placa");
        modelo.addColumn("Color");
        modelo.addColumn("Kilometraje (Km)");
        modelo.addColumn("Numero de serie de motor");
        modelo.addColumn("Marca");
        modelo.addColumn("Nombre Propietario");
        LeerDatos();
        LlenarComboMotocicletas();
        //-----
    }

    private void LlenarComboMotocicletas() {
        List<Motocicleta> listaCarros = new MotocicletaRegistro().Leer();

        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        for (Motocicleta motocicleta1: listaCarros) {
            Item item1 = new Item(motocicleta1.getNombrePropietario(), motocicleta1.getNumeroDeSerieMotor());
            modeloCombo.addElement(item1);
        }
        cboMotocicletas.setModel(modeloCombo);
    }

    private void LeerDatos() {
        try {
            List<Motocicleta> listaMotocicletas = new MotocicletaRegistro().Leer();

            modelo.setRowCount(0);
            for (Motocicleta motocicleta1: listaMotocicletas){
                Object[] registrLeido = {motocicleta1.getPlaca(), motocicleta1.getColor(), motocicleta1.getKilometraje(), motocicleta1.getNumeroDeSerieMotor(), motocicleta1.getMarca(), motocicleta1.getNombrePropietario()};
                modelo.addRow(registrLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
        //------
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Registro Motocicletas");
        frame1.setContentPane(new frmMotocicleta().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
