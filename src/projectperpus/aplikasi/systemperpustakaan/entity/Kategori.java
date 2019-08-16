package projectperpus.aplikasi.systemperpustakaan.entity;

public class Kategori {
    int id;
    String namaKategori;
    Object object;

    public Kategori(int id, String namaKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return namaKategori;
            default:return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }


}
