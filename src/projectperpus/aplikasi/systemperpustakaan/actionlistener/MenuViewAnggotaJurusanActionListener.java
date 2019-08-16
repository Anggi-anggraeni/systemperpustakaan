package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.FrameAnggotaView;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.FrameJurusanView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameBukuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;


public class MenuViewAnggotaJurusanActionListener implements ActionListener{
    FrameMain main;

    public MenuViewAnggotaJurusanActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getJurusanView())){
                result = true; break;
            }
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getJurusanView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setJurusanView(new FrameJurusanView(main));
            main.getDesktopPane().add(main.getJurusanView());
            main.getJurusanView().setVisible(true);
         }
    }
}
