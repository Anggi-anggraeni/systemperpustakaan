package projectperpus.aplikasi.systemperpustakaan.entity;

public class UserType {
    int id;
    String nama;
    String privilege;
    Object object;

    public UserType() {
    }

    public UserType(int id, String nama, String privilege) {
        this.id = id;
        this.nama = nama;
        this.privilege = privilege;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return id;
            case 1: return nama;
            case 2: return privilege;
            default: return null;
        } 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }


}
