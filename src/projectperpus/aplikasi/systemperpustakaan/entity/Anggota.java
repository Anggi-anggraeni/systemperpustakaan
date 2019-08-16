package projectperpus.aplikasi.systemperpustakaan.entity;

import java.sql.Date;


public class Anggota {
    int id;
    String nim;
    int jurusanId;
    String nama;
    String kotaLahir;
    Date tanggalLahir;
    String alamat;
    String email;
    String telepon;
    Date tanggalReg;
    Date akhirReg;
    Object object;

    public Anggota() {
    }

    public Anggota(int id, String nim, int jurusanId, String nama, String kotaLahir, Date tanggalLahir,
    				String alamat, String email, String telepon, Date tanggalReg, Date akhirReg) {
        this.id = id;
        this.nim = nim;
        this.jurusanId = jurusanId;
        this.nama = nama;
        this.kotaLahir = kotaLahir;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.email = email;
        this.telepon = telepon;
        this.tanggalReg = tanggalReg;
        this.akhirReg = akhirReg;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getAkhirReg() {
        return akhirReg;
    }

    public void setAkhirReg(Date akhirReg) {
        this.akhirReg = akhirReg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJurusanId() {
        return jurusanId;
    }

    public void setJurusanId(int jurusanId) {
        this.jurusanId = jurusanId;
    }

    public String getKotaLahir() {
        return kotaLahir;
    }

    public void setKotaLahir(String kotaLahir) {
        this.kotaLahir = kotaLahir;
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

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalReg() {
        return tanggalReg;
    }

    public void setTanggalReg(Date tanggalReg) {
        this.tanggalReg = tanggalReg;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return nim;
            case 2: return jurusanId;
            case 3: return nama;
            case 4: return kotaLahir;
            case 5: return tanggalLahir;
            case 6: return alamat;
            case 7: return email;
            case 8: return telepon;
            case 9: return tanggalReg;
            case 10: return akhirReg;
            default: return null;
        }
    }

}
