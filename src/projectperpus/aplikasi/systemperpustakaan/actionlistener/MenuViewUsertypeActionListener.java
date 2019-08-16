package projectperpus.aplikasi.systemperpustakaan.actionlistener;

import projectperpus.aplikasi.systemperpustakaan.view.FrameMain;
import projectperpus.aplikasi.systemperpustakaan.view.user.FrameUserTypeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;


public class MenuViewUsertypeActionListener implements ActionListener{
    FrameMain main;

    public MenuViewUsertypeActionListener(FrameMain main) {
        this.main = main;
    }

    public boolean isExists(){
        boolean result = false;
        JInternalFrame[] iFrame = main.getDesktopPane().getAllFrames();
        for(int i=0;i < iFrame.length; i++){
            if(iFrame[i].equals(main.getTypeUser())){
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
            main.setTypeUser(new FrameUserTypeView(main));
            main.getDesktopPane().add(main.getTypeUser());
            main.getTypeUser().setVisible(true);
         }
    }
}
