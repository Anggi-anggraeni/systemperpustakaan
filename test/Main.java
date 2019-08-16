
import ahza.aplikasi.systemperpustakaan.controller.PeminjamanController;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import ahza.aplikasi.systemperpustakaan.view.peminjaman.DialogPeminjamanDetail;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahza
 */
public class Main {
    public static void main(String[] args) {
        DialogPeminjamanDetail detail = new DialogPeminjamanDetail(new JFrame(), true, new PeminjamanController());
        detail.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {   }
            public void windowClosing(WindowEvent e) {   }
            public void windowClosed(WindowEvent e) { System.exit(0); }
            public void windowIconified(WindowEvent e) {  }
            public void windowDeiconified(WindowEvent e) {  }
            public void windowActivated(WindowEvent e) {   }
            public void windowDeactivated(WindowEvent e) {   }
        });
        detail.setVisible(true);
    }
static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
