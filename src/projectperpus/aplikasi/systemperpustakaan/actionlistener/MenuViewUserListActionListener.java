package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.user.FrameUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class MenuViewUserListActionListener implements ActionListener{
    FrameMain main;

    public MenuViewUserListActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getUserView())){
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
            main.setUserView(new FrameUserView(main));
            main.getDesktopPane().add(main.getUserView());
            main.getUserView().setVisible(true);
         }
    }
}
