package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameBukuView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FramePenerbitView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewBukuPenerbitActionListener implements ActionListener{
    FrameMain main;

    public MenuViewBukuPenerbitActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getPenerbitView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getPenerbitView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setPenerbitView(new FramePenerbitView(main));
            main.getDesktopPane().add(main.getPenerbitView());
            main.getPenerbitView().setVisible(true);
         }
    }
}
