package projectperpus.aplikasi.systemperpustakaan.entity;

import java.sql.Date;

public class DetailPinjam {
    int noPinjam;
    int noDetail;
    int idBuku;
    String judul;
    Date tanggalKembali;
    int terlambat;
    Double denda;
    Object object;
    public DetailPinjam() {
    }

    public DetailPinjam(int noPinjam, int noDetail, int idBuku, String judul, Date tanggalKembali, int terlambat, Double denda) {
        this.noPinjam = noPinjam;
        this.noDetail = noDetail;
        this.idBuku = idBuku;
        this.judul = judul;
        this.tanggalKembali = tanggalKembali;
        this.terlambat = terlambat;
        this.denda = denda;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return noPinjam;
            case 1: return noDetail;
            case 2: return idBuku;
            case 3: return judul;
            case 4: return tanggalKembali;
            case 5: return terlambat;
            case 6: return denda;
            default: return null;
        }
    }

    public Double getDenda() {
        return denda;
    }

    public void setDenda(Double denda) {
        this.denda = denda;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }



}
