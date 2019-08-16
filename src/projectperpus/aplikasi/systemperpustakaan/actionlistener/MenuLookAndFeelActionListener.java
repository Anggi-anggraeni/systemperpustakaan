
package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MenuLookAndFeelActionListener implements ActionListener{
    FrameMain frameMain;
    String laf = "";
    
    public MenuLookAndFeelActionListener() {
    }

    public MenuLookAndFeelActionListener(FrameMain frameMain) {
        this.frameMain = frameMain;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== frameMain.getRadioNimbus()){
            laf="com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
        }else if(e.getSource()== frameMain.getRadioWindows()){
            laf="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        }else if(e.getSource()== frameMain.getRadioMetal()){
            laf="javax.swing.plaf.metal.MetalLookAndFeel";
        }else if(e.getSource()== frameMain.getRadioMotif()){
            laf="com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(laf);
            SwingUtilities.updateComponentTreeUI(frameMain);
        } catch (Exception ex) {
        }
    }

}
