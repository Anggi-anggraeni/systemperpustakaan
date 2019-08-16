
import ahza.aplikasi.systemperpustakaan.entity.DetailPinjam;
import ahza.aplikasi.systemperpustakaan.model.PeminjamanModel;
import ahza.aplikasi.systemperpustakaan.utility.DateUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahza
 */
public class TestTanggal {
//    public static void main(String[] args) {
//        String tgl = "2011-02-15";
//        System.out.println("Tahun: "+tgl.substring(0, 4));
//        int y = Integer.valueOf(tgl.substring(0, 4));
//        System.out.println("Bulan: "+tgl.substring(5, 7));
//        int m = Integer.valueOf(tgl.substring(5, 7));
//        System.out.println("Hari: "+tgl.substring(8, 10));
//        int d = Integer.valueOf(tgl.substring(8, 10));


//        Date date = new Date(y-1900, m, d);
//
//        java.util.Date  dateu = new java.util.Date();
//        date = new Date(dateu.getTime());
//        System.out.println("Tanggal: "+date.toString());
//        System.out.println("Tanggal Modif: ");
//    }

        public static void main(String[] args) {
            DateUtility du = new DateUtility();
            System.out.println("Curdate: "+du.getCurDate());
            System.out.println("Next Year date: "+du.getNextYearDate());
            System.out.println("Begin date: "+du.getBeginOfMonthDate());
            System.out.println("End date: "+du.getEndOfMonthDate());
            System.out.println("Create Date: "+du.createDate("2011-02-09"));
            System.out.println("Selisih hari: "+du.getDiffrentDate(du.createDate("2011-02-09"), du.createDate("2011-02-01")));

            SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM yyyy");
            Date date = new Date("2011/01/01");
            System.out.println("Date: "+df.format(date));
            System.out.println("Is Date valid: "+du.isDateValid("20010101"));
        }
//        PeminjamanModel model = new PeminjamanModel();
//        List<DetailPinjam> listp = model.getListDetailPinjam(2);
//        System.out.println("Jumlah data: "+listp.size());
//    }
}
