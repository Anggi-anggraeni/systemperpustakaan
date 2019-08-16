package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameBukuView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameJenisView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewBukuJenisActionListener implements ActionListener{
    FrameMain main;

    public MenuViewBukuJenisActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getJenisView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getJenisView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setJenisView(new FrameJenisView(main));
            main.getDesktopPane().add(main.getJenisView());
            main.getJenisView().setVisible(true);
         }
    }
}
