package gui.guiGeneral;

import PropiedadIntelectual.gui.Cancion.frmCancion;
import PropiedadIntelectual.gui.Marca.frmMarca;
import PropiedadIntelectual.gui.Patentes.frmPatentes;
import PropiedadIntelectual.gui.Software.frmSoftware;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmIntelectual {
    private JPanel jpaCentral;
    private JMenuItem jmiCancion;
    private JMenuItem jmiMarca;
    private JMenuItem jmiSoftware;
    private JMenuItem jmiPatentes;
    private JLabel lblOpcion;
    public JPanel jpaPrincipal;

    public frmIntelectual() {
        jmiCancion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    JFrame frame1 = new JFrame("Cancion");
                    frame1.setContentPane(new frmCancion().jpaPrincipal);
                    frame1.setResizable(false);
                    frame1.pack();
                    frame1.setLocationRelativeTo(null);
                    frame1.setVisible(true);
            }
        });
        jmiMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Marca");
                frame1.setContentPane(new frmMarca().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiSoftware.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Software");
                frame1.setContentPane(new frmSoftware().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiPatentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Patentes");
                frame1.setContentPane(new frmPatentes().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de propiedad intelectual");
        frame1.setContentPane(new frmIntelectual().jpaPrincipal);
        frame1.setResizable(false);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
