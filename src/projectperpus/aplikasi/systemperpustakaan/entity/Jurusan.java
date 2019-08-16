package projectperpus.aplikasi.systemperpustakaan.entity;

public class Jurusan {
    int id;
    String namaJurusan;
    Object object;

    public Jurusan() {
    }

    public Jurusan(int id, String namaJurusan) {
        this.id = id;
        this.namaJurusan = namaJurusan;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return namaJurusan;
            default: return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }


}
