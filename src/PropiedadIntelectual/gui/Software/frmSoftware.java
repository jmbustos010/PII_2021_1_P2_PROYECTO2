package PropiedadIntelectual.gui.Software;

import PropiedadIntelectual.negocio.Software.SoftwareNegocios;
import PropiedadIntelectual.recursos.ClasesSoftware.ItemSoftware;
import PropiedadIntelectual.recursos.ClasesSoftware.Software;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmSoftware {
    public JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblFechaCreacion;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblDispositivo;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtDispositivo;
    private JTextField txtFechaCreacion;
    private JButton btnInsertar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable tblDatos;
    private JScrollPane sclDatos;
    private JButton btnLeerCombo;
    private JComboBox cboSoftware;
    private JButton btnLimpiarCasillas;
    private JLabel lblListaSoftware;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmSoftware() {
        iniciar();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Software software = new Software();
                    software.setNombre(txtNombre.getText());
                    software.setDescripcion(txtDescripcion.getText());
                    software.setDispositivo(txtDispositivo.getText());
                    software.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    String respuesta = new SoftwareNegocios().Insertar(software);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboSoftware();
                    } else {
                        throw new Exception(respuesta);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Software software = new Software();
                    software.setNombre(txtNombre.getText());
                    software.setDescripcion(txtDescripcion.getText());
                    software.setDispositivo(txtDispositivo.getText());
                    software.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new SoftwareNegocios().Actualizar(software);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Software software = new Software();
                    software.setNombre(txtNombre.getText());
                    software.setDescripcion(txtDescripcion.getText());
                    software.setDispositivo(txtDispositivo.getText());
                    software.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new SoftwareNegocios().Eliminar(software);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Software software = new Software();
                    software.setNombre(txtNombre.getText());
                    List<Software> listaSoftware = new SoftwareNegocios().Buscar(software);
                    modelo.setRowCount(0);
                    for (Software cadaSoftware: listaSoftware) {
                        Object[] registroLeido = {cadaSoftware.getNombre(),cadaSoftware.getDescripcion(),cadaSoftware.getDispositivo(),sdf.format(cadaSoftware.getFechaCreacion())};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        txtFechaCreacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!((c >='0') &&(c <='9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null, "Por favor, ingresar una fecha correcta");
                    e.consume();
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtDescripcion.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtDispositivo.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtFechaCreacion.setText(modelo.getValueAt(filaSeleccionada,3).toString());
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtDispositivo.setText("");
                txtFechaCreacion.setText("");
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboSoftware.getSelectedItem();
                String itemSoftware = ((ItemSoftware)objeto).getDispositivo();
                JOptionPane.showMessageDialog(null,itemSoftware,"Autor:",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

        private void iniciar(){
            modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Dispositivo");
            modelo.addColumn("Fecha de Creacion");
            leerDatos();
            llenarComboSoftware();
        }

        private void leerDatos(){
            try {
                List<Software> listaSoftware = new SoftwareNegocios().leer();
                modelo.setRowCount(0);
                for (Software software : listaSoftware) {
                    Object[] registroLeido = {software.getNombre(), software.getDescripcion(), software.getDispositivo(), sdf.format(software.getFechaCreacion())};
                    modelo.addRow(registroLeido);
                }
                tblDatos.setModel(modelo);
            } catch (Exception e) {
            }
    }

    private void llenarComboSoftware() {
        List<Software> listaSoftware = new SoftwareNegocios().leer();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (Software software: listaSoftware) {
            ItemSoftware item = new ItemSoftware(software.getNombre(), software.getDispositivo());
            modeloCombo.addElement(item);
        }
        cboSoftware.setModel(modeloCombo);
    }

    private Date ConvertirFormatoTextoFecha (String textoFecha){
        Date fecha = null;
        try {
            fecha = sdf.parse(textoFecha);
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(null, pe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Software");
        frame1.setContentPane(new frmSoftware().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}


