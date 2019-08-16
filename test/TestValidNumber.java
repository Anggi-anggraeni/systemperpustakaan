
import ahza.aplikasi.systemperpustakaan.utility.NumberUtility;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahza
 */
public class TestValidNumber {
    public static void main(String[] args) {
        if(NumberUtility.isNumberValid("123c")){
            JOptionPane.showMessageDialog(null, "Angka Valid");
        }else{
            JOptionPane.showMessageDialog(null, "Angka tidak Valid");
        }
    }
}
