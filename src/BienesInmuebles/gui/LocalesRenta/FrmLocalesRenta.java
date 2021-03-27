package BienesInmuebles.gui.LocalesRenta;

import BienesInmuebles.ClasesConexion.LocalesRentaConexion;
import BienesInmuebles.Recursos.Clases.LocalRentaItem;
import BienesInmuebles.Recursos.Clases.LocalesRenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FrmLocalesRenta {
    public JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JPanel jpaSuperior;
    private JLabel lblPrecio;
    private JLabel lblTamanio;
    private JLabel lblDesripcion;
    private JLabel lblUbicacion;
    private JTextField txtTamanio;
    private JTextField txtDescripcion;
    private JTextField txtUbicacion;
    private JTextField txtPrecio;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable tblDatos;
    private JButton btnLimpiar;
    private JComboBox cboLocales;
    private JButton btnLeerCombo;
    private JScrollPane sclDatos;
    DefaultTableModel modelo;


    public FrmLocalesRenta() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    LocalesRenta localesRenta = new LocalesRenta();
                    localesRenta.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    localesRenta.setTamaño(Long.parseLong(txtTamanio.getText()));
                    localesRenta.setDescripcion(txtDescripcion.getText());
                    localesRenta.setUbicacion(txtUbicacion.getText());
                    String respuesta = new LocalesRentaConexion().Insertar(localesRenta);
                    JOptionPane.showMessageDialog(null, "Guardado","Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboLocal();
                }catch (Exception e){
                }
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    LocalesRenta localesRenta = new LocalesRenta();
                    localesRenta.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    localesRenta.setTamaño(Long.parseLong(txtTamanio.getText()));
                    localesRenta.setDescripcion(txtDescripcion.getText());
                    localesRenta.setUbicacion(txtUbicacion.getText());
                    new LocalesRentaConexion().Actualizar(localesRenta);
                    JOptionPane.showMessageDialog(null, "Actualizado","Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboLocal();
                }catch (Exception e){

                }
            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    LocalesRenta localesRenta = new LocalesRenta();
                    localesRenta.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    localesRenta.setTamaño(Long.parseLong(txtTamanio.getText()));
                    localesRenta.setDescripcion(txtDescripcion.getText());
                    localesRenta.setUbicacion(txtUbicacion.getText());
                    new LocalesRentaConexion().Eliminar(localesRenta);
                    JOptionPane.showMessageDialog(null, "Eliminado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboLocal();
                }catch (Exception e){

                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    LocalesRenta localesRenta = new LocalesRenta();
                    localesRenta.setDescripcion(txtDescripcion.getText());
                    List<LocalesRenta> listaLocales = new LocalesRentaConexion().Buscar(localesRenta);
                    modelo.setRowCount(0);

                    for (LocalesRenta cadaLocal: listaLocales) {
                        Object [] registroLeido = {cadaLocal.getPrecio(), cadaLocal.getTamaño(), cadaLocal.getDescripcion(), cadaLocal.getUbicacion()};
                        modelo.addRow(registroLeido);
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int filaseleccionada = tblDatos.getSelectedRow();
                txtPrecio.setText(modelo.getValueAt(filaseleccionada,0).toString());
                txtTamanio.setText(modelo.getValueAt(filaseleccionada,1).toString());
                txtDescripcion.setText(modelo.getValueAt(filaseleccionada,2).toString());
                txtUbicacion.setText(modelo.getValueAt(filaseleccionada,3).toString());
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPrecio.setText("");
                txtTamanio.setText("");
                txtDescripcion.setText("");
                txtUbicacion.setText("");
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object objeto = cboLocales.getSelectedItem();
                int  itemLocal = ((LocalRentaItem)objeto).getPrecio();
                JOptionPane.showMessageDialog(null,itemLocal);
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                leerDatos();
            }
        });
    }

    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Precio");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        llenarComboLocal();
        leerDatos();
    }
    private void llenarComboLocal(){
        try{
            List<LocalesRenta> ListaLocales = new LocalesRentaConexion().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (LocalesRenta local: ListaLocales) {
                LocalRentaItem item = new LocalRentaItem(local.getPrecio(),local.getDescripcion());
                modeloCombo.addElement(item);
            }
            cboLocales.setModel(modeloCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void leerDatos() {
        try{
            List<LocalesRenta> listaEdificio = new LocalesRentaConexion().Leer();
            modelo.setRowCount(0);
            for (LocalesRenta localesRenta: listaEdificio){
                Object [] registroLeido = {localesRenta.getPrecio(), localesRenta.getTamaño(), localesRenta.getDescripcion(), localesRenta.getUbicacion()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de locales de renta");
        frame1.setContentPane(new FrmLocalesRenta().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
