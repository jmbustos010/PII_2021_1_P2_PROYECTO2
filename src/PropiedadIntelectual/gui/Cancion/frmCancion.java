package PropiedadIntelectual.gui.Cancion;

import PropiedadIntelectual.negocio.Cancion.CancionNegocios;
import PropiedadIntelectual.recursos.ClasesCancion.Cancion;
import PropiedadIntelectual.recursos.ClasesCancion.ItemCancion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmCancion {
    public JPanel jpaPrincipal;
    private JPanel jpaIzquierdo;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JPanel jpaInferior;
    private JLabel lblNombre;
    private JLabel lblAutor;
    private JLabel lblGenero;
    private JLabel lblFechaPublicacion;
    private JTextField txtNombre;
    private JTextField txtAutor;
    private JTextField txtGenero;
    private JTextField txtFechaPublicacion;
    private JButton btnInsertar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JTable tblDatos;
    private JScrollPane sclDatos;
    private JComboBox cboCancion;
    private JButton btnLeerCombo;
    private JButton btnLimpiarCasillas;
    private JLabel llbListaCanciones;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmCancion() {
        iniciar();
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cancion cancion = new Cancion();
                    cancion.setNombre(txtNombre.getText());
                    cancion.setAutor(txtAutor.getText());
                    cancion.setGenero(txtGenero.getText());
                    cancion.setFechaPublicada(ConvertirFormatoTextoFecha(txtFechaPublicacion.getText()));
                    String respuesta = new CancionNegocios().Insertar(cancion);
                    if(!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboCancion();
                    }else{
                        throw new Exception(respuesta);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtFechaPublicacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!((c >='0') &&(c <='9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))){
                    JOptionPane.showMessageDialog(null, "Por favor, ingresar una fecha correcta");
                    e.consume();
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtAutor.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtGenero.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtFechaPublicacion.setText(modelo.getValueAt(filaSeleccionada,3).toString());
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cancion cancion = new Cancion();
                    cancion.setNombre(txtNombre.getText());
                    cancion.setAutor(txtAutor.getText());
                    cancion.setGenero(txtGenero.getText());
                    cancion.setFechaPublicada(ConvertirFormatoTextoFecha(txtFechaPublicacion.getText()));
                    new CancionNegocios().Eliminar(cancion);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cancion cancion = new Cancion();
                    cancion.setNombre(txtNombre.getText());
                    cancion.setAutor(txtAutor.getText());
                    cancion.setGenero(txtGenero.getText());
                    cancion.setFechaPublicada(ConvertirFormatoTextoFecha(txtFechaPublicacion.getText()));
                    new CancionNegocios().Actualizar(cancion);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cancion cancion = new Cancion();
                    cancion.setNombre(txtNombre.getText());
                    List<Cancion> listaCanciones = new CancionNegocios().Buscar(cancion);
                    modelo.setRowCount(0);
                    for (Cancion cadaCancion: listaCanciones) {
                        Object[] registroLeido = {cadaCancion.getNombre(),cadaCancion.getAutor(),cadaCancion.getGenero(),sdf.format(cadaCancion.getFechaPublicada())};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLimpiarCasillas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtAutor.setText("");
                txtGenero.setText("");
                txtFechaPublicacion.setText("");
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboCancion.getSelectedItem();
                String itemCancion = ((ItemCancion)objeto).getAutor();
                JOptionPane.showMessageDialog(null,itemCancion,"Autor:",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Autor");
        modelo.addColumn("Genero");
        modelo.addColumn("Fecha de Publicacion");
        leerDatos();
        llenarComboCancion();
    }

    private void llenarComboCancion() {
        List<Cancion> listaCancion = new CancionNegocios().leer();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (Cancion cancion: listaCancion) {
            ItemCancion item = new ItemCancion(cancion.getNombre(), cancion.getAutor());
            modeloCombo.addElement(item);
        }
        cboCancion.setModel(modeloCombo);
    }

    private void leerDatos() {
        try{
            List<Cancion> listaCanciones = new CancionNegocios().leer();
            modelo.setRowCount(0);
            for (Cancion cancion: listaCanciones){
                Object [] registroLeido = {cancion.getNombre(),cancion.getAutor(),cancion.getGenero(),sdf.format(cancion.getFechaPublicada())};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch(Exception e){
        }
    }

    private Date ConvertirFormatoTextoFecha(String textoFecha) {
        Date fecha = null;
        try{
            fecha = sdf.parse(textoFecha);
        }catch(ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Cancion");
        frame1.setContentPane(new frmCancion().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
