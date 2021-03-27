package BienesMuebles.gui.avion;

import BienesMuebles.recursos.clases.Avion;
import BienesMuebles.recursos.clases.ItemAvion;
import BienesMuebles.registro.avion.AvionRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmAvion {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierda;
    private JLabel lblId;
    private JLabel lblNumeroDeMototres;
    private JLabel lblCapacidadDePeso;
    private JLabel lblTipoDeAvion;
    private JLabel lblNombrePropietario;
    private JPanel jpaInferior;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JPanel jpaDerecha;
    private JTextField txtId;
    private JTextField txtNumeroDeMotores;
    private JTextField txtCapacidadDePeso;
    private JTextField txtTipoDeAvion;
    private JTextField txtNombreDelPropietario;
    private JPanel jpaSuperior;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLimpiarCasillas;
    private JLabel lblListaPropietarios;
    private JComboBox cboAviones;
    private JButton btnLeerCombo;
    private JButton btnModoOscuro;

    DefaultTableModel modelo;

    public frmAvion() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Avion avion1 = new Avion();
                    avion1.setId(Integer.parseInt(txtId.getText()));
                    avion1.setNumeroDeMotores(Integer.parseInt(txtNumeroDeMotores.getText()));
                    avion1.setCapacidadDePeso(Integer.parseInt(txtCapacidadDePeso.getText()));
                    avion1.setNombrePropietario(txtNombreDelPropietario.getText());
                    avion1.setTipoDeAvion(txtTipoDeAvion.getText());
                    String respuesta = new AvionRegistro().Insertar(avion1);

                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null, "Guardado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        throw new Exception(respuesta);
                    }

                    LeerDatos();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Avion avion1 = new Avion();
                    avion1.setId(Integer.parseInt(txtId.getText()));
                    avion1.setNumeroDeMotores(Integer.parseInt(txtNumeroDeMotores.getText()));
                    avion1.setCapacidadDePeso(Integer.parseInt(txtCapacidadDePeso.getText()));
                    avion1.setNombrePropietario(txtNombreDelPropietario.getText());
                    avion1.setTipoDeAvion(txtTipoDeAvion.getText());


                    String respuesta = new AvionRegistro().Actualizar(avion1);

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
                    Avion avion1 = new Avion();
                    avion1.setId(Integer.parseInt(txtId.getText()));
                    avion1.setNumeroDeMotores(Integer.parseInt(txtNumeroDeMotores.getText()));
                    avion1.setCapacidadDePeso(Integer.parseInt(txtCapacidadDePeso.getText()));
                    avion1.setNombrePropietario(txtNombreDelPropietario.getText());
                    avion1.setTipoDeAvion(txtTipoDeAvion.getText());


                    String respuesta = new AvionRegistro().Eliminar(avion1);

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
                    Avion avion1 = new Avion();
                    avion1.setId(Integer.parseInt(txtId.getText()));
                    List<Avion> listaAviones = new AvionRegistro().Buscar(avion1);
                    modelo.setRowCount(0);

                    for (Avion avion2 : listaAviones) {
                        Object[] registroLeido = {avion2.getId(), avion2.getNumeroDeMotores(), avion2.getCapacidadDePeso(), avion2.getNombrePropietario(), avion2.getTipoDeAvion()};
                        modelo.addRow(registroLeido);
                    }

                    tblDatos.setModel(modelo);
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
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtNumeroDeMotores.setText("");
                txtCapacidadDePeso.setText("");
                txtNombreDelPropietario.setText("");
                txtTipoDeAvion.setText("");
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();

                txtId.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtNumeroDeMotores.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtCapacidadDePeso.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtNombreDelPropietario.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtTipoDeAvion.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                //-----
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboAviones.getSelectedItem();
                int  itemAvion = ((ItemAvion)objeto).getId();
                JOptionPane.showMessageDialog(null, "El ID del avion de "+
                        ((ItemAvion) objeto).getNombrePropietario()+" es: "+itemAvion);
            }
        });
    }

    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Id");
        modelo.addColumn("Numero de motores");
        modelo.addColumn("Capacidad de peso Kg");
        modelo.addColumn("Nombre del propietario");
        modelo.addColumn("Tipo de avion");
        LeerDatos();
        LlenarComboAviones();
        //-----
    }

    private void LlenarComboAviones(){
        List<Avion> listaAviones = new AvionRegistro().Leer();

        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        for (Avion avion1: listaAviones) {
            ItemAvion itemAvion1 = new ItemAvion(avion1.getNombrePropietario(),avion1.getId());
            modeloCombo.addElement(itemAvion1);
        }
        cboAviones.setModel(modeloCombo);
        //-----
    }

    private void LeerDatos() {
        try {
            List<Avion> listaAviones = new AvionRegistro().Leer();

            modelo.setRowCount(0);
            for (Avion avion1: listaAviones){
                Object[] registrLeido = {avion1.getId(), avion1.getNumeroDeMotores(), avion1.getCapacidadDePeso(), avion1.getNombrePropietario(), avion1.getTipoDeAvion()};
                modelo.addRow(registrLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
        //------
    }


    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Registro Aviones");
        frame1.setContentPane(new frmAvion().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
