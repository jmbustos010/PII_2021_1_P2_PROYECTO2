package gui.guiGeneral;

import BienesMuebles.gui.autobus.frmAutobus;
import BienesMuebles.gui.avion.frmAvion;
import BienesMuebles.gui.carro.frmCarro;
import BienesMuebles.gui.motocicleta.frmMotocicleta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenuMueble {
    public JPanel jpaPrincipalMenuBien;
    private JMenuItem jmiCarro;
    private JMenuItem jmiMotos;
    private JMenuItem jmiAviones;
    private JMenuItem jmiAutobus;
    private JPanel jpaInferior;
    private JLabel lblMenu;


    public frmMenuMueble() {
        jmiCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Registro Carros");
                frame1.setContentPane(new frmCarro().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }

        });
        jmiAutobus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Registro Autobuses");
                frame1.setContentPane(new frmAutobus().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiMotos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Registro Motocicletas");
                frame1.setContentPane(new frmMotocicleta().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiAviones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame("Registro Aviones");
                frame1.setContentPane(new frmAvion().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de bienes muebles");
        frame1.setContentPane(new frmMenuMueble().jpaPrincipalMenuBien);
        frame1.setResizable(false);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
