package projectperpus.aplikasi.systemperpustakaan.component;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyButton extends JButton {

    public void setActionListener(ActionListener actionListener) {
        ActionListener[] al = getActionListeners();
        for(int i=0;i<al.length;i++){
            removeActionListener(al[i]);
        }
        this.addActionListener(actionListener);
    }
    

}
