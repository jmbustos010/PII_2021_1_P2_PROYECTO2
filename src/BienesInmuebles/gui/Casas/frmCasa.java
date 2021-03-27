package BienesInmuebles.gui.Casas;

import BienesInmuebles.ClasesConexion.CasaConexion;
import BienesInmuebles.Recursos.Clases.Casa;
import BienesInmuebles.Recursos.Clases.CasaItem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmCasa extends Frame {
    public JPanel jpaPrincipal;
    private JTextField txtTipoDiseño;
    private JTextField txtTamaño;
    private JTextField txtDescripcion;
    private JTextField txtUbicacion;
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLimpiar;
    private JTable tblDatos;
    private JTextField txtPrecio;
    private JPanel jpaIzquierdo;
    private JLabel lblTipoDiseño;
    private JLabel lblPrecio;
    private JLabel lblUbicacion;
    private JLabel lblDescripcion;
    private JLabel lblTamaño;
    private JLabel lblListaEdificios;
    private JComboBox cboCasas;
    private JButton btnLeerCombo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JScrollPane sclDatos;
    DefaultTableModel modelo;


    public frmCasa() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Casa casa = new Casa();
                    casa.setTipoDiseño(txtTipoDiseño.getText());
                    casa.setTamaño(Long.parseLong(txtTamaño.getText()));
                    casa.setDescripcion(txtDescripcion.getText());
                    casa.setUbicacion(txtUbicacion.getText());
                    casa.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    String respuesta = new CasaConexion().Insertar(casa);
                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null , "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboCasa();
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Casa casa = new Casa();
                    casa.setTipoDiseño(txtTipoDiseño.getText());
                    casa.setTamaño(Long.parseLong(txtTamaño.getText()));
                    casa.setDescripcion(txtDescripcion.getText());
                    casa.setUbicacion(txtUbicacion.getText());
                    casa.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new CasaConexion().Eliminar(casa);
                    JOptionPane.showMessageDialog(null, "Eliminado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboCasa();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Casa casa = new Casa();
                    casa.setTipoDiseño(txtTipoDiseño.getText());
                    casa.setTamaño(Long.parseLong(txtTamaño.getText()));
                    casa.setDescripcion(txtDescripcion.getText());
                    casa.setUbicacion(txtUbicacion.getText());
                    casa.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new CasaConexion().Actualizar(casa);
                    JOptionPane.showMessageDialog(null, "Actualizado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboCasa();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Casa casa = new Casa();
                    casa.setTipoDiseño(txtTipoDiseño.getText());
                    List<Casa> listaCasa = new CasaConexion().Buscar(casa);
                    modelo.setRowCount(0);

                    for (Casa cadaCasa: listaCasa) {
                        Object [] registroLeido = {cadaCasa.getTipoDiseño(), cadaCasa.getTamaño(), cadaCasa.getDescripcion(), cadaCasa.getUbicacion(), cadaCasa.getPrecio()};
                        modelo.addRow(registroLeido);
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                leerDatos();
                llenarComboCasa();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtTipoDiseño.setText("");
                txtTamaño.setText("");
                txtDescripcion.setText("");
                txtUbicacion.setText("");
                txtPrecio.setText("");
                llenarComboCasa();
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int filaseleccionada = tblDatos.getSelectedRow();
                txtTipoDiseño.setText(modelo.getValueAt(filaseleccionada,0).toString());
                txtTamaño.setText(modelo.getValueAt(filaseleccionada,1).toString());
                txtDescripcion.setText(modelo.getValueAt(filaseleccionada,2).toString());
                txtUbicacion.setText(modelo.getValueAt(filaseleccionada,3).toString());
                txtPrecio.setText(modelo.getValueAt(filaseleccionada,4).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object objeto = cboCasas.getSelectedItem();
                int itemCasa = ((CasaItem)objeto).getPrecio();
                JOptionPane.showMessageDialog(null,itemCasa);
            }
        });
    }
    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Tipo de Diseño");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Precio");
        leerDatos();
        llenarComboCasa();
    }

    private void llenarComboCasa(){
       try{
           List<Casa> listaCasas = new CasaConexion().Leer();
           DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
           for (Casa casa: listaCasas) {
               CasaItem item = new CasaItem(casa.getTipoDiseño(), casa.getPrecio());
               modeloCombo.addElement(item);
           }
           cboCasas.setModel(modeloCombo);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    private void leerDatos() {
        try{
            List<Casa> listaCasa = new CasaConexion().Leer();
            modelo.setRowCount(0);
            for (Casa casa: listaCasa){
                Object [] registroLeido = {casa.getTipoDiseño(), casa.getTamaño(), casa.getDescripcion(), casa.getUbicacion(), casa.getPrecio()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de Casas");
        frame1.setContentPane(new frmCasa().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

}
