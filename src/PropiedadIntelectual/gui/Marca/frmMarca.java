package PropiedadIntelectual.gui.Marca;

import PropiedadIntelectual.negocio.Marca.MarcaNegocios;
import PropiedadIntelectual.recursos.ClasesMarca.ItemMarca;
import PropiedadIntelectual.recursos.ClasesMarca.Marca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmMarca {
    public JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblPropietario;
    private JLabel lblSede;
    private JLabel lblFechaCreacion;
    private JButton btnInsertar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JComboBox cboMarca;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPropietario;
    private JTextField txtSede;
    private JTextField txtFechaCreacion;
    private JPanel jpaInferior;
    private JScrollPane sclDatos;
    private JTable tblDatos;
    private JButton btnLeerCombo;
    private JButton btnLimpiarCasillas;
    private JLabel lblListaMarca;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmMarca() {
        iniciar();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Marca marcas = new Marca();
                    marcas.setId(Long.parseLong(txtId.getText()));
                    marcas.setNombre(txtNombre.getText());
                    marcas.setPropietario(txtPropietario.getText());
                    marcas.setSede(txtSede.getText());
                    marcas.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    String respuesta = new MarcaNegocios().Insertar(marcas);
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
                    Marca marcas = new Marca();
                    marcas.setId(Long.parseLong(txtId.getText()));
                    marcas.setNombre(txtNombre.getText());
                    marcas.setPropietario(txtPropietario.getText());
                    marcas.setSede(txtSede.getText());
                    marcas.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new MarcaNegocios().Actualizar(marcas);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Marca marcas = new Marca();
                    marcas.setId(Long.parseLong(txtId.getText()));
                    marcas.setNombre(txtNombre.getText());
                    marcas.setPropietario(txtPropietario.getText());
                    marcas.setSede(txtSede.getText());
                    marcas.setFechaCreacion(ConvertirFormatoTextoFecha(txtFechaCreacion.getText()));
                    new MarcaNegocios().Eliminar(marcas);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Marca marcas = new Marca();
                    marcas.setId(Long.parseLong(txtId.getText()));
                    List<Marca> listaMarcas= new MarcaNegocios().Buscar(marcas);
                    modelo.setRowCount(0);
                    for (Marca cadaMarca: listaMarcas) {
                        Object[] registroLeido = {cadaMarca.getId(),cadaMarca.getNombre(),cadaMarca.getPropietario(),cadaMarca.getSede(),sdf.format(cadaMarca.getFechaCreacion())};
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
                txtPropietario.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtSede.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtFechaCreacion.setText(modelo.getValueAt(filaSeleccionada,4).toString());
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtNombre.setText("");
                txtPropietario.setText("");
                txtSede.setText("");
                txtFechaCreacion.setText("");

            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboMarca.getSelectedItem();
                Long itemMarca = ((ItemMarca)objeto).getId();
                JOptionPane.showMessageDialog(null,itemMarca,"Id:",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    private void iniciar(){
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Propietario");
        modelo.addColumn("Sede");
        modelo.addColumn("Fecha de Creacion");
        leerDatos();
        llenarComboSoftware();
    }

    private void leerDatos(){
        try {
            List<Marca> listaMarcas = new MarcaNegocios().leer();
            modelo.setRowCount(0);
            for (Marca marcas : listaMarcas) {
                Object[] registroLeido = {marcas.getId(), marcas.getNombre(), marcas.getPropietario(), marcas.getSede(), sdf.format(marcas.getFechaCreacion())};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
        }
    }

    private void llenarComboSoftware() {
        List<Marca> listaMarcas = new MarcaNegocios().leer();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (Marca marcas: listaMarcas) {
            ItemMarca item = new ItemMarca(marcas.getId(), marcas.getNombre());
            modeloCombo.addElement(item);
        }
        cboMarca.setModel(modeloCombo);
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
        JFrame frame1 = new JFrame("Marca");
        frame1.setContentPane(new frmMarca().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
