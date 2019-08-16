
import ahza.aplikasi.systemperpustakaan.entity.Kategori;
import ahza.aplikasi.systemperpustakaan.model.BukuModel;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahza
 */
public class TestBukuModel {
    public static void main(String[] args) {
        BukuModel model = new BukuModel();
        List<Kategori> list = model.getListKategori(-1, "Data");
        System.out.println("Jumlah Data: "+list.size());
        if(list.size() > 0){
            System.out.println("Jumlah Data: "+list.size());
            System.out.println("Nama Kategori: "+list.get(0).getNamaKategori());
        }
    }
}
