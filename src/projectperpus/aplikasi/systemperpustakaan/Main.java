package projectperpus.aplikasi.systemperpustakaan;

import projectperpus.aplikasi.systemperpustakaan.view.FrameLogin;
import projectperpus.aplikasi.systemperpustakaan.view.LaunchProgressBar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LaunchProgressBar pb = new LaunchProgressBar();
        pb.setVisible(true);
        for(int i=0;i<=100;i++){
            try {
                pb.getProgressBar().setValue(i);
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(LaunchProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pb.dispose();
        FrameLogin fl = new FrameLogin(null, true);
        fl.setVisible(true);
    }

}
