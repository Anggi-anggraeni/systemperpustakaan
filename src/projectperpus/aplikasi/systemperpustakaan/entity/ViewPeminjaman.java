package projectperpus.aplikasi.systemperpustakaan.entity;

import java.sql.Date;

public class ViewPeminjaman {
    int noPinjam;
    Date tanggal;
    String nim;
    String nama;
    int noDetail;
    String judulBuku;
    Date tanggalKembali;
    String status;
    String User;
    Object object;

    public ViewPeminjaman() {
    }

    public ViewPeminjaman(int noPinjam, Date tanggal, String nim, String nama, int noDetail, String judulBuku,
            Date tanggalKembali, String status, String User) {
        this.noPinjam = noPinjam;
        this.tanggal = tanggal;
        this.nim = nim;
        this.nama = nama;
        this.noDetail = noDetail;
        this.judulBuku = judulBuku;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
        this.User = User;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return noPinjam;
            case 1: return tanggal;
            case 2: return nim;
            case 3: return nama;
            case 4: return noDetail;
            case 5: return judulBuku;
            case 6: return tanggalKembali;
            case 7: return status;
            case 8: return User;
            default: return null;
        }
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getNoDetail() {
        return noDetail;
    }

    public void setNoDetail(int noDetail) {
        this.noDetail = noDetail;
    }

    public int getNoPinjam() {
        return noPinjam;
    }

    public void setNoPinjam(int noPinjam) {
        this.noPinjam = noPinjam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

}
