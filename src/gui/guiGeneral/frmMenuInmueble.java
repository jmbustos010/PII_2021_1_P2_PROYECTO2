package gui.guiGeneral;

import BienesInmuebles.gui.Casas.frmCasa;
import BienesInmuebles.gui.Edificios.frmEdificios;
import BienesInmuebles.gui.LocalesRenta.FrmLocalesRenta;
import BienesInmuebles.gui.Terrenos.FrmTerrenos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenuInmueble {

    public  JPanel jpaPrincipal;
    private JMenuItem jmiCasas;
    private JMenuItem jmiEdificios;
    private JMenuItem jmiLocales;
    private JMenuItem jmiTerrenos;
    private JLabel lblOpcion;

    public frmMenuInmueble() {
        jmiCasas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de Casas");
                frame1.setContentPane(new frmCasa().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiEdificios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de Edificios");
                frame1.setContentPane(new frmEdificios().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiLocales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de locales de renta");
                frame1.setContentPane(new FrmLocalesRenta().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiTerrenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de Terrenos");
                frame1.setContentPane(new FrmTerrenos().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Bienes Inmuebles");
        frame1.setContentPane(new frmMenuInmueble().jpaPrincipal);
        frame1.setResizable(false);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
