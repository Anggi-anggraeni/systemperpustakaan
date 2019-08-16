package projectperpus.aplikasi.systemperpustakaan.entity;

public class Jenis {
    int id;
    String nama_jenis;

    public Jenis() {
    }

    public Jenis(int id, String nama_jenis) {
        this.id = id;
        this.nama_jenis = nama_jenis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_jenis() {
        return nama_jenis;
    }

    public void setNama_jenis(String nama_jenis) {
        this.nama_jenis = nama_jenis;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return  nama_jenis;
            default:return null;
        }
    }

}
