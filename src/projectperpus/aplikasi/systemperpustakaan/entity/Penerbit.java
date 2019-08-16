package projectperpus.aplikasi.systemperpustakaan.entity;

public class Penerbit {
    int id;
    String namaPenerbit;
    String alamat;
    String kota;
    String email;
    String telepon;
    Object object;

    public Penerbit() {
    }

    public Penerbit(int id, String namaPenerbit, String alamat,
    				String kota, String email, String telepon) 
    {
        this.id = id;
        this.namaPenerbit = namaPenerbit;
        this.alamat = alamat;
        this.kota = kota;
        this.email = email;
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNamaPenerbit() {
        return namaPenerbit;
    }

    public void setNamaPenerbit(String namaPenerbit) {
        this.namaPenerbit = namaPenerbit;
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
            case 1: return namaPenerbit;
            case 2: return alamat;
            case 3: return kota;
            case 4: return email;
            case 5: return telepon;
            default: return null;
        }

    }
    
}
