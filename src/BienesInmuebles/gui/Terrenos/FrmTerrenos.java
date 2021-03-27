package BienesInmuebles.gui.Terrenos;


import BienesInmuebles.ClasesConexion.TerrenosConexion;
import BienesInmuebles.Recursos.Clases.TerrenoItem;
import BienesInmuebles.Recursos.Clases.Terrenos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FrmTerrenos {
    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JPanel jpaDerecho;
    private JPanel jpaIzquierdo;
    private JTextField txtTipoSuelo;
    private JTextField txtTamanio;
    private JTextField txtDescripcion;
    private JTextField txtUbicacion;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable tblDatos;
    private JButton btnLimpiar;
    private JTextField txtPrecio;
    private JButton btnLeerCombo;
    private JScrollPane sclDatos;
    private JLabel lblTipoSuelo;
    private JLabel lblTamanio;
    private JLabel lblPrecio;
    private JLabel lblDescripcion;
    private JLabel lblUbicacion;
    private JComboBox cboTerrenos;
    private JLabel lblCombo;
    DefaultTableModel modelo;

    public FrmTerrenos() {
        Iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Terrenos terrenos = new Terrenos();
                    terrenos.setTipoSuelo(txtTipoSuelo.getText());
                    terrenos.setTamaño(Long.parseLong(txtTamanio.getText()));
                    terrenos.setDescripcion(txtDescripcion.getText());
                    terrenos.setUbicacion(txtUbicacion.getText());
                    terrenos.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    String respuesta = new TerrenosConexion().Insertar(terrenos);
                    JOptionPane.showMessageDialog(null, "Guardado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboTerreno();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Terrenos terrenos = new Terrenos();
                    terrenos.setTipoSuelo(txtTipoSuelo.getText());
                    terrenos.setTamaño(Long.parseLong(txtTamanio.getText()));
                    terrenos.setDescripcion(txtDescripcion.getText());
                    terrenos.setUbicacion(txtUbicacion.getText());
                    terrenos.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new TerrenosConexion().Actualizar(terrenos);
                    JOptionPane.showMessageDialog(null, "Actualizado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboTerreno();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Terrenos terrenos = new Terrenos();
                    terrenos.setTipoSuelo(txtTipoSuelo.getText());
                    terrenos.setTamaño(Long.parseLong(txtTamanio.getText()));
                    terrenos.setDescripcion(txtDescripcion.getText());
                    terrenos.setUbicacion(txtUbicacion.getText());
                    terrenos.setPrecio(Integer.parseInt(txtPrecio.getText()));
                    new TerrenosConexion().Eliminar(terrenos);
                    JOptionPane.showMessageDialog(null, "Eliminado", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    leerDatos();
                    llenarComboTerreno();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Terrenos terrenos = new Terrenos();
                    terrenos.setTipoSuelo(txtTipoSuelo.getText());
                    List<Terrenos> listaTerrenos = new TerrenosConexion().Buscar(terrenos);
                    modelo.setRowCount(0);

                    for (Terrenos cadaTerreno: listaTerrenos) {
                        Object [] registroLeido = {cadaTerreno.getTipoSuelo(), cadaTerreno.getTamaño(), cadaTerreno.getDescripcion(), cadaTerreno.getUbicacion(), cadaTerreno.getPrecio()};
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
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtTipoSuelo.setText("");
                txtTamanio.setText("");
                txtDescripcion.setText("");
                txtUbicacion.setText("");
                txtPrecio.setText("");
            }
        });

        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object objeto = cboTerrenos.getSelectedItem();
                int  itemTerreno = ((TerrenoItem)objeto).getPrecio();
                JOptionPane.showMessageDialog(null,itemTerreno);
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int filaseleccionada = tblDatos.getSelectedRow();
                txtTipoSuelo.setText(modelo.getValueAt(filaseleccionada,0).toString());
                txtTamanio.setText(modelo.getValueAt(filaseleccionada,1).toString());
                txtDescripcion.setText(modelo.getValueAt(filaseleccionada,2).toString());
                txtUbicacion.setText(modelo.getValueAt(filaseleccionada,3).toString());
                txtPrecio.setText(modelo.getValueAt(filaseleccionada,4).toString());
            }
        });
    }

    private void leerDatos() {
        try{
            List<Terrenos> listaTerrenos = new TerrenosConexion().Leer();
            modelo.setRowCount(0);
            for (Terrenos terrenos: listaTerrenos){
                Object [] registroLeido = {terrenos.getTipoSuelo(), terrenos.getTamaño(), terrenos.getDescripcion(), terrenos.getUbicacion(), terrenos.getPrecio()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){
        }
    }
    private void Iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Tipo Suelo");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Precio");
        llenarComboTerreno();
        leerDatos();
    }
    private void llenarComboTerreno(){
        try{
            List<Terrenos> ListaTerrenos = new TerrenosConexion().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Terrenos terrenos: ListaTerrenos) {
                TerrenoItem item = new TerrenoItem(terrenos.getTipoSuelo(),terrenos.getPrecio());
                modeloCombo.addElement(item);
            }
            cboTerrenos.setModel(modeloCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de Terrenos");
        frame1.setContentPane(new FrmTerrenos().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }


}
