package BienesMuebles.gui.carro;


import BienesMuebles.recursos.clases.Carro;
import BienesMuebles.recursos.clases.Item;
import BienesMuebles.registro.carro.CarroRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class frmCarro {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierda;
    private JLabel lblPlaca;
    private JLabel lblNumeroPuertas;
    private JLabel lblColor;
    private JLabel lblNumeroSerieMotor;
    private JLabel lblNombrePropietario;
    private JPanel jpaInferior;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JPanel jpaDerecha;
    private JTextField txtPlaca;
    private JTextField txtNumeroPuertas;
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
    private JLabel lblListaPropietarios;
    private JComboBox cboCarros;
    private JButton btnLeerCombo;
    DefaultTableModel modelo;

    public frmCarro() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro1 = new Carro();
                    carro1.setPlaca(txtPlaca.getText());
                    carro1.setNumeroDePuertas(Integer.parseInt(txtNumeroPuertas.getText()));
                    carro1.setColor(txtColor.getText());
                    carro1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    carro1.setNombrePropietario(txtNombrePropietario.getText());
                    String respuesta = new CarroRegistro().Insertar(carro1);

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
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro1 = new Carro();
                    carro1.setPlaca(txtPlaca.getText());
                    carro1.setNumeroDePuertas(Integer.parseInt(txtNumeroPuertas.getText()));
                    carro1.setColor(txtColor.getText());
                    carro1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    carro1.setNombrePropietario(txtNombrePropietario.getText());

                    String respuesta = new CarroRegistro().Actualizar(carro1);

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
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeerDatos();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro1 = new Carro();
                    carro1.setPlaca(txtPlaca.getText());
                    carro1.setNumeroDePuertas(Integer.parseInt(txtNumeroPuertas.getText()));
                    carro1.setColor(txtColor.getText());
                    carro1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    carro1.setNombrePropietario(txtNombrePropietario.getText());

                    String respuesta = new CarroRegistro().Eliminar(carro1);

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

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();

                txtPlaca.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtColor.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtNumeroPuertas.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtNumeroDeSerieMotor.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtNombrePropietario.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                //-----
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtColor.setText("");
                txtNumeroPuertas.setText("");
                txtNumeroDeSerieMotor.setText("");
                txtNombrePropietario.setText("");
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro1 = new Carro();
                    carro1.setNumeroDeSerieMotor(txtNumeroDeSerieMotor.getText());
                    List<Carro> listaCarros = new CarroRegistro().Buscar(carro1);
                    modelo.setRowCount(0);

                    for (Carro carro2 : listaCarros) {
                        Object[] registroLeido = {carro2.getPlaca(), carro2.getColor(), carro2.getNumeroDePuertas(), carro2.getNumeroDeSerieMotor(), carro2.getNombrePropietario()};
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
                Object objeto = cboCarros.getSelectedItem();
                String  itemCarro = ((Item)objeto).getNumeroDeSerieMotor();
                JOptionPane.showMessageDialog(null, "El numero de serie de motor del carro de "+
                        ((Item) objeto).getNombrePropietario()+" es: "+itemCarro);
            }
        });
    }

    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Placa");
        modelo.addColumn("Color");
        modelo.addColumn("Numero de puertas");
        modelo.addColumn("Numero de serie de motor");
        modelo.addColumn("Nombre Propietario");
        LeerDatos();
        LlenarComboCarros();
        //-----
    }

    private void LlenarComboCarros() {
        List<Carro> listaCarros = new CarroRegistro().Leer();

        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        for (Carro carro1: listaCarros) {
            Item item1 = new Item(carro1.getNombrePropietario(), carro1.getNumeroDeSerieMotor());
            modeloCombo.addElement(item1);
        }
        cboCarros.setModel(modeloCombo);
    }

    private void LeerDatos() {
        try {
            List<Carro> listaCarros = new CarroRegistro().Leer();

            modelo.setRowCount(0);
            for (Carro carro1: listaCarros){
                Object[] registrLeido = {carro1.getPlaca(), carro1.getColor(), carro1.getNumeroDePuertas(), carro1.getNumeroDeSerieMotor(), carro1.getNombrePropietario()};
                modelo.addRow(registrLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
        //------
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Registro Carros");
        frame1.setContentPane(new frmCarro().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
