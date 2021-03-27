package gui.guiGeneral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGeneral {
    private JMenuItem jmiIntelectual;
    private JPanel jpaPrincipal;
    private JPanel jpaDerecho;
    private JMenuItem jmiInmuebles;
    private JMenuItem jmiMueble;
    private JLabel lblMenus;


    public frmGeneral() {
        jmiIntelectual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de propiedad intelectual");
                frame1.setContentPane(new frmIntelectual().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiMueble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registro de bienes muebles");
                frame1.setContentPane(new frmMenuMueble().jpaPrincipalMenuBien);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
        jmiInmuebles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Bienes Inmuebles");
                frame1.setContentPane(new frmMenuInmueble().jpaPrincipal);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("Registro de bienes");
        frame1.setContentPane(new frmGeneral().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

}
