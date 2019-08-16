package projectperpus.aplikasi.systemperpustakaan.component;

import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuItem {
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    public void setActionListener(ActionListener actionListener) {
        ActionListener[] al = getActionListeners();
        for(int i=0;i<al.length;i++){
            removeActionListener(al[i]);
        }
        this.addActionListener(actionListener);
    }

    public ActionListener getActionListener() {
        return actionListener;
    }


}
