package BienesMuebles.gui.autobus;

import BienesMuebles.recursos.clases.Autobus;
import BienesMuebles.recursos.clases.Item;
import BienesMuebles.registro.autobus.AutobusRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmAutobus {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierda;
    private JPanel jpaInferior;
    private JPanel jpaDerecha;
    private JPanel jpaSuperior;
    private JLabel lblPlaca;
    private JLabel lblNumeroAsientos;
    private JLabel lblColor;
    private JLabel lblNumeroSerieMotor;
    private JLabel lblNombrePropietario;
    private JTextField txtPlaca;
    private JTextField txtNumeroAsientos;
    private JTextField txtColor;
    private JTextField txtNumeroDeSerieMotor;
    private JTextField txtNombrePropietario;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable tblDatos;
    private JScrollPane sclPanDatos;
    private JButton btnLimpiarCasillas;
    private JComboBox cboAutobus;
    private JLabel lblListaPropietarios;
    private JButton btnLeerCombo;
    DefaultTableModel modelo;

    public frmAutobus() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autobus autobus1 = new Autobus();
                    autobus1.setPlaca(txtPlaca.getText());
                    autobus1.setNumeroAsientos(Integer.parseInt(txtNumeroAsientos.getText()));
                    autobus1.setColor(txtColor.getText());
                    autobus1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    autobus1.setNombrePropietario(txtNombrePropietario.getText());
                    String respuesta = new AutobusRegistro().Insertar(autobus1);

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
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autobus autobus1 = new Autobus();
                    autobus1.setPlaca(txtPlaca.getText());
                    autobus1.setNumeroAsientos(Integer.parseInt(txtNumeroAsientos.getText()));
                    autobus1.setColor(txtColor.getText());
                    autobus1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    autobus1.setNombrePropietario(txtNombrePropietario.getText());

                     String respuesta = new AutobusRegistro().Actualizar(autobus1);

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
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();

                txtPlaca.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtColor.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtNumeroAsientos.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtNumeroDeSerieMotor.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtNombrePropietario.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                //-----
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autobus autobus1 = new Autobus();
                    autobus1.setPlaca(txtPlaca.getText());
                    autobus1.setNumeroAsientos(Integer.parseInt(txtNumeroAsientos.getText()));
                    autobus1.setColor(txtColor.getText());
                    autobus1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    autobus1.setNombrePropietario(txtNombrePropietario.getText());

                    String respuesta = new AutobusRegistro().Eliminar(autobus1);

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
                    Autobus autobus1 = new Autobus();
                    autobus1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    List<Autobus> listaAutobuses = new  AutobusRegistro().Buscar(autobus1);
                    modelo.setRowCount(0);

                    for (Autobus autobus2 : listaAutobuses) {
                        Object[] registroLeido = {autobus2.getPlaca(), autobus2.getColor(), autobus2.getNumeroAsientos(), autobus2.getNumeroDeSerieMotor(), autobus2.getNombrePropietario()};
                        modelo.addRow(registroLeido);
                    }

                    tblDatos.setModel(modelo);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                //-----
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtColor.setText("");
                txtNumeroAsientos.setText("");
                txtNumeroDeSerieMotor.setText("");
                txtNombrePropietario.setText("");

            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboAutobus.getSelectedItem();
                String  itemAutobus = ((Item)objeto).getNumeroDeSerieMotor();
                JOptionPane.showMessageDialog(null, "El numero de serie de motor del autobus de "+
                        ((Item) objeto).getNombrePropietario()+" es: "+itemAutobus);
            }
        });
    }

    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Placa");
        modelo.addColumn("Color");
        modelo.addColumn("Numero de asientos");
        modelo.addColumn("Numero de serie de motor");
        modelo.addColumn("Nombre Propietario");
        LeerDatos();
        LlenarComboAutobuses();
        //-----
    }

    private void LlenarComboAutobuses() {
        List<Autobus> listaAutobuses = new AutobusRegistro().Leer();

        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        for (Autobus autobus1: listaAutobuses) {
            Item item1 = new Item(autobus1.getNombrePropietario(), autobus1.getNumeroDeSerieMotor());
            modeloCombo.addElement(item1);
        }
        cboAutobus.setModel(modeloCombo);
    }

    private void LeerDatos() {
        try {
            List<Autobus> listaAutobuses = new AutobusRegistro().Leer();

            modelo.setRowCount(0);
            for (Autobus autobus1: listaAutobuses){
                Object[] registrLeido = {autobus1.getPlaca(), autobus1.getColor(), autobus1.getNumeroAsientos(), autobus1.getNumeroDeSerieMotor(), autobus1.getNombrePropietario()};
                modelo.addRow(registrLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
        //------
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Registro Autobuses");
        frame1.setContentPane(new frmAutobus().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        //-----
    }
}
