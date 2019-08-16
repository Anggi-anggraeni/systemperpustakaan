package projectperpus.aplikasi.systemperpustakaan.utility;

public class NumberUtility {

    public static boolean isNumberValid(String textNumber){
        try {
            int returnValue = Integer.valueOf(textNumber);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
