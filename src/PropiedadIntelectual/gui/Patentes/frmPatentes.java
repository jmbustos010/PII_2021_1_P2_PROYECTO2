package PropiedadIntelectual.gui.Patentes;

import PropiedadIntelectual.negocio.Patentes.PatentesNegocios;
import PropiedadIntelectual.recursos.ClasesPatentes.ItemPatente;
import PropiedadIntelectual.recursos.ClasesPatentes.Patentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmPatentes {
    private JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblPropietario;
    private JLabel lblFechaCreacion;
    private JButton btnInsertar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtPropietario;
    private JTextField txtFechaCreacion;
    private JTable tblDatos;
    private JScrollPane sclDatos;
    private JButton btnLeerCombo;
    private JComboBox cboPatente;
    private JButton btnLimpiarCasillas;
    private JLabel lblListaPatentes;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmPatentes() {
        iniciar();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Patentes patentes = new Patentes();
                    patentes.setId(Long.parseLong(txtId.getText()));
                    patentes.setNombre(txtNombre.getText());
                    patentes.setDescripcion(txtDescripcion.getText());
                    patentes.setPropietario(txtPropietario.getText());
                    patentes.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    String respuesta = new PatentesNegocios().Insertar(patentes);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboSoftware();
                    } else {
                        throw new Exception(respuesta);
                    }
                    }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Patentes patentes = new Patentes();
                    patentes.setId(Long.parseLong(txtId.getText()));
                    patentes.setNombre(txtNombre.getText());
                    patentes.setDescripcion(txtDescripcion.getText());
                    patentes.setPropietario(txtPropietario.getText());
                    patentes.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new PatentesNegocios().Actualizar(patentes);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Patentes patentes = new Patentes();
                    patentes.setId(Long.parseLong(txtId.getText()));
                    patentes.setNombre(txtNombre.getText());
                    patentes.setDescripcion(txtDescripcion.getText());
                    patentes.setPropietario(txtPropietario.getText());
                    patentes.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new PatentesNegocios().Eliminar(patentes);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Patentes patentes = new Patentes();
                    patentes.setId(Long.parseLong(txtId.getText()));
                    List<Patentes> listaPatentes= new PatentesNegocios().Buscar(patentes);
                    modelo.setRowCount(0);
                    for (Patentes cadaPatente: listaPatentes) {
                        Object[] registroLeido = {cadaPatente.getId(),cadaPatente.getNombre(),cadaPatente.getDescripcion(),cadaPatente.getPropietario(),sdf.format(cadaPatente.getFechaCreacion())};
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
                if(!((c >='0') &&(c <='9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresar una fecha correcta");
                    e.consume();
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtId.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtDescripcion.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtPropietario.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtFechaCreacion.setText(modelo.getValueAt(filaSeleccionada,4).toString());
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");
                txtPropietario.setText("");
                txtFechaCreacion.setText("");

            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboPatente.getSelectedItem();
                Long itemPatente = ((ItemPatente)objeto).getId();
                JOptionPane.showMessageDialog(null,itemPatente,"Id:",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    private void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Propietario");
        modelo.addColumn("Fecha de Creacion");
        leerDatos();
        llenarComboSoftware();
    }

    private void leerDatos(){
        try {
            List<Patentes> listaPatentes = new PatentesNegocios().leer();
            modelo.setRowCount(0);
            for (Patentes patentes : listaPatentes) {
                Object[] registroLeido = {patentes.getId(), patentes.getNombre(), patentes.getDescripcion(),patentes.getPropietario(), sdf.format(patentes.getFechaCreacion())};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
        }
    }

        private void llenarComboSoftware() {
            List<Patentes> listaPatentes = new PatentesNegocios().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Patentes patentes: listaPatentes) {
                ItemPatente item = new ItemPatente(patentes.getId(), patentes.getNombre());
                modeloCombo.addElement(item);
            }
            cboPatente.setModel(modeloCombo);
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
        JFrame frame1 = new JFrame("Patentes");
        frame1.setContentPane(new frmPatentes().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
