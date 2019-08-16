package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameKategoriView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewBukuKategoriActionListener implements ActionListener{
    FrameMain main;
    FrameKategoriView kategoriView;

    public MenuViewBukuKategoriActionListener(FrameMain main) {
        this.main = main;
        kategoriView = new FrameKategoriView(main);
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getKategoriView())){
                result = true; break;
            }
        }
        return result;
    }
    public void actionPerformed(ActionEvent e) {
        if(isExists()){
            try {
                main.getKategoriView().setSelected(true);
            } catch (PropertyVetoException ex) {
            }
         }else{
            main.setKategoriView(new FrameKategoriView(main));
            main.getDesktopPane().add(main.getKategoriView());
            main.getKategoriView().setVisible(true);
         }
    }

}
