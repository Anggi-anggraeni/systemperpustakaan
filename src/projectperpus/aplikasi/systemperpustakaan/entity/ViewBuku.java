package projectperpus.aplikasi.systemperpustakaan.entity;

public class ViewBuku {
    int id;
    String jenis;
    String kategori;
    String judul;
    String pengarang;
    String penerbit;
    String isbn;
    int tahun;
    int terpinjam;
    int tersedia;
    int jumlah;
    Object object;
    
    public ViewBuku() { }

    public ViewBuku(int id, String jenis, String kategori, String judul, String pengarang,
            String penerbit, String isbn, int tahun, int terpinjam, int tersedia, int jumlah) 
    {
        this.id = id;
        this.jenis = jenis;
        this.kategori = kategori;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.isbn = isbn;
        this.tahun = tahun;
        this.terpinjam = terpinjam;
        this.tersedia = tersedia;
        this.jumlah = jumlah;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return jenis;
            case 2: return kategori;
            case 3: return judul;
            case 4: return pengarang;
            case 5: return penerbit;
            case 6: return isbn;
            case 7: return tahun;
            case 8: return terpinjam;
            case 9: return tersedia;
            case 10: return jumlah;
        default: return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
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

    public int getTerpinjam() {
        return terpinjam;
    }

    public void setTerpinjam(int terpinjam) {
        this.terpinjam = terpinjam;
    }

    public int getTersedia() {
        return tersedia;
    }

    public void setTersedia(int tersedia) {
        this.tersedia = tersedia;
    }

}
