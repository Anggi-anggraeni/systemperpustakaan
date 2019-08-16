package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.FrameAnggotaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewAnggotaListActionListener implements ActionListener{
    FrameMain main;

    public MenuViewAnggotaListActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getAnggotaView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getAnggotaView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setAnggotaView(new FrameAnggotaView(main));
            main.getDesktopPane().add(main.getAnggotaView());
            try { main.getAnggotaView().setMaximum(true); } catch (PropertyVetoException ex) {  }
            main.getAnggotaView().setVisible(true);
         }
    }
}
