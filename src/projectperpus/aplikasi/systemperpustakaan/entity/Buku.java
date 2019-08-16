package projectperpus.aplikasi.systemperpustakaan.entity;

public class Buku {
    int id;
    int jenis_id;
    int kategori_id;
    String judul;
    String pengarang;
    int penerbit_id;
    String isbn;
    int tahun;
    int jumlah_tersedia;
    int jumlah_terpinjam;
    int jumlah_total;
    Object object;
    
    public Buku() {
    }

    public Buku(int id,  int jenis_id,int kategori_id, String judul, String pengarang, int penerbit_id,
            String isbn, int tahun, int jumlah_tersedia, int jumlah_terpinjam, int jumlah_total) {
        this.id = id;
        this.jenis_id = jenis_id;
        this.kategori_id = kategori_id; 
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit_id = penerbit_id;
        this.isbn = isbn;
        this.tahun = tahun;
        this.jumlah_tersedia = jumlah_tersedia;
        this.jumlah_terpinjam = jumlah_terpinjam;
        this.jumlah_total = jumlah_total;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return jenis_id;
            case 2: return kategori_id;
            case 3: return judul;
            case 4: return pengarang;
            case 5: return penerbit_id;
            case 6: return isbn;
            case 7: return tahun;
            case 8: return jumlah_tersedia;
            case 9: return jumlah_terpinjam;
            case 10: return jumlah_total;
            default: return null;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIjumlah_total() {
        return jumlah_total;
    }

    public void setIjumlah_total(int ijumlah_total) {
        this.jumlah_total = ijumlah_total;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getJenis_id() {
        return jenis_id;
    }

    public void setJenis_id(int jenis_id) {
        this.jenis_id = jenis_id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getJumlah_terpinjam() {
        return jumlah_terpinjam;
    }

    public void setJumlah_terpinjam(int jumlah_terpinjam) {
        this.jumlah_terpinjam = jumlah_terpinjam;
    }

    public int getJumlah_tersedia() {
        return jumlah_tersedia;
    }

    public void setJumlah_tersedia(int jumlah_tersedia) {
        this.jumlah_tersedia = jumlah_tersedia;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public int getPenerbit_id() {
        return penerbit_id;
    }

    public void setPenerbit_id(int penerbit_id) {
        this.penerbit_id = penerbit_id;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getJumlah_total() {
        return jumlah_total;
    }

    public void setJumlah_total(int jumlah_total) {
        this.jumlah_total = jumlah_total;
    }

}
