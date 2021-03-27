package BienesInmuebles.gui.Edificios;

import BienesInmuebles.ClasesConexion.EdificioConexion;
import BienesInmuebles.Recursos.Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmEdificios {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblTipoConstruccion;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLimpiar;
    private JTextField txtTipoConstruccion;
    private JLabel lblTamaño;
    private JLabel lblPrecio;
    private JLabel lblAltura;
    private JLabel lblDescripcion;
    private JLabel lblUbicacion;
    private JTextField txtDescripcion;
    private JTextField txtUbicacion;
    private JTable tblDatos;
    private JTextField txtAltura;
    private JTextField txtPrecio;
    private JTextField txtTamaño;
    private JComboBox cboEdificios;
    private JButton btnLeerCombo;
    private JScrollPane sclDatos;
    private JLabel lblListaEdificios;
    DefaultTableModel modelo;


    public frmEdificios() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Edificios edificios = new Edificios();
                    edificios.setTipoConstruccion(txtTipoConstruccion.getText());
                    edificios.setTamaño(Long.parseLong(txtTamaño.getText()));
                    edificios.setDescripcion(txtDescripcion.getText());
                    edificios.setUbicacion(txtUbicacion.getText());
                    edificios.setAltura(Integer.parseInt(txtAltura.getText()));
                    edificios.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    String respuesta = new EdificioConexion().Insertar(edificios);
                    JOptionPane.showMessageDialog(null, "Guardado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboEdificio();
                }catch (Exception e){
                }
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Edificios edificios = new Edificios();
                    edificios.setTipoConstruccion(txtTipoConstruccion.getText());
                    edificios.setTamaño(Long.parseLong(txtTamaño.getText()));
                    edificios.setDescripcion(txtDescripcion.getText());
                    edificios.setUbicacion(txtUbicacion.getText());
                    edificios.setAltura(Integer.parseInt(txtAltura.getText()));
                    edificios.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new EdificioConexion().Actualizar(edificios);
                    JOptionPane.showMessageDialog(null, "Actualizado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboEdificio();
                }catch (Exception e){
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Edificios edificios = new Edificios();
                    edificios.setTipoConstruccion(txtTipoConstruccion.getText());
                    edificios.setTamaño(Long.parseLong(txtTamaño.getText()));
                    edificios.setDescripcion(txtDescripcion.getText());
                    edificios.setUbicacion(txtUbicacion.getText());
                    edificios.setAltura(Integer.parseInt(txtAltura.getText()));
                    edificios.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new EdificioConexion().Eliminar(edificios);
                    JOptionPane.showMessageDialog(null, "Eliminado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboEdificio();
                }catch (Exception e) {
                }
            }
        });


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Edificios edificios = new Edificios();
                    edificios.setTipoConstruccion(txtTipoConstruccion.getText());
                    List<Edificios> listaTerrenos = new EdificioConexion().Buscar(edificios);
                    modelo.setRowCount(0);
                    for (Edificios cadaEdificio: listaTerrenos) {
                        Object [] registroLeido = {cadaEdificio.getTipoConstruccion(), cadaEdificio.getTamaño(), cadaEdificio.getDescripcion(), cadaEdificio.getUbicacion(), cadaEdificio.getAltura(), cadaEdificio.getPrecio()};
                        modelo.addRow(registroLeido);
                    }
                }catch (Exception e){
                }
            }
        });


        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                leerDatos();
            }
        });


        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtTipoConstruccion.setText("");
                txtTamaño.setText("");
                txtDescripcion.setText("");
                txtUbicacion.setText("");
                txtAltura.setText("");
                txtPrecio.setText("");
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int filaseleccionada = tblDatos.getSelectedRow();
                txtTipoConstruccion.setText(modelo.getValueAt(filaseleccionada,0).toString());
                txtTamaño.setText(modelo.getValueAt(filaseleccionada,1).toString());
                txtDescripcion.setText(modelo.getValueAt(filaseleccionada,2).toString());
                txtUbicacion.setText(modelo.getValueAt(filaseleccionada,3).toString());
                txtAltura.setText(modelo.getValueAt(filaseleccionada,4).toString());
                txtPrecio.setText(modelo.getValueAt(filaseleccionada,5).toString());

            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object objeto = cboEdificios.getSelectedItem();
                int itemEdificio = ((EdificioItem)objeto).getAltura();
                JOptionPane.showMessageDialog(null,itemEdificio);
            }
        });
    }
    private void leerDatos() {
        try{
            List<Edificios> listaEdificios = new EdificioConexion().Leer();
            modelo.setRowCount(0);
            for (Edificios edificios: listaEdificios){
                Object [] registroLeido = {edificios.getTipoConstruccion(), edificios.getTamaño(), edificios.getDescripcion(), edificios.getUbicacion(), edificios.getAltura(), edificios.getPrecio()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
    }
    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Tipo Construccion");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Altura");
        modelo.addColumn("Precio");
        llenarComboEdificio();
        leerDatos();
    }
    private void llenarComboEdificio(){
        try{
            List<Edificios> ListaEdificio = new EdificioConexion().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Edificios edificio: ListaEdificio) {
                EdificioItem item = new EdificioItem(edificio.getTipoConstruccion(),edificio.getAltura());
                modeloCombo.addElement(item);
            }
            cboEdificios.setModel(modeloCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de Edificios");
        frame1.setContentPane(new frmEdificios().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
