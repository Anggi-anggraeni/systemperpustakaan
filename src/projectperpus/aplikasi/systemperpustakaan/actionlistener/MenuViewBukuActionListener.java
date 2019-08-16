package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameBukuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewBukuActionListener implements ActionListener{
    FrameMain main;

    public MenuViewBukuActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getBukuView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getBukuView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setBukuView(new FrameBukuView(main));
            main.getDesktopPane().add(main.getBukuView());
            try { main.getBukuView().setMaximum(true); } catch (PropertyVetoException ex) {  } 
            main.getBukuView().setVisible(true);
         }
    }
}
