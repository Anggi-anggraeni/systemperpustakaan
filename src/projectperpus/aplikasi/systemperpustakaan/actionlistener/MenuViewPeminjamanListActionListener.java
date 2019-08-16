package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.peminjaman.FramePeminjamanView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewPeminjamanListActionListener implements ActionListener{
    FrameMain main;

    public MenuViewPeminjamanListActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getPeminjamanView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getPeminjamanView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setPeminjamanView(new FramePeminjamanView(main));
            main.getDesktopPane().add(main.getPeminjamanView());
            try { main.getPeminjamanView().setMaximum(true); } catch (PropertyVetoException ex) {  }
            main.getPeminjamanView().setVisible(true);
         }
    }
}
