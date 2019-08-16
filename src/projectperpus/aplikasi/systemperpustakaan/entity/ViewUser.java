package projectperpus.aplikasi.systemperpustakaan.entity;

public class ViewUser {
    int noUser;
    String userId;
    String password;
    String nama;
    String type;
    Object object;

    public ViewUser() {
    }

    public ViewUser(int noUser, String userId, String password, String nama, String type) {
        this.noUser = noUser;
        this.userId = userId;
        this.password = password;
        this.nama = nama;
        this.type = type;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return noUser;
            case 1: return userId;
            case 2: return password;
            case 3: return nama;
            case 4: return type;
            default:  return null;
        }
        
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String privilege) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
