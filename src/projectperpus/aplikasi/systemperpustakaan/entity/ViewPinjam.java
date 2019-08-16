package projectperpus.aplikasi.systemperpustakaan.entity;

import java.sql.Date;

public class ViewPinjam {
    int noPinjam;
    Date tanggal;
    int idAnggota;
    String nim;
    String nama;
    String user;
    Object object;

    public ViewPinjam() {
    }

    public ViewPinjam(int noPinjam, Date tanggal, int idAnggota, String nim, String nama, String user) {
        this.noPinjam = noPinjam;
        this.tanggal = tanggal;
        this.idAnggota = idAnggota;
        this.nim = nim;
        this.nama = nama;
        this.user = user;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return noPinjam;
            case 1: return tanggal;
            case 2: return idAnggota;
            case 3: return nim;
            case 4: return nama;
            case 5: return user;
            default: return null;
        }
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
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

    public int getNoPinjam() {
        return noPinjam;
    }

    public void setNoPinjam(int noPinjam) {
        this.noPinjam = noPinjam;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
