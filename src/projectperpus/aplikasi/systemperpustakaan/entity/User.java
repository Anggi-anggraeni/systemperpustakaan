package projectperpus.aplikasi.systemperpustakaan.entity;

public class User {
    private int id;
    private int type;
    private String userId;
    private String password;
    private String nama;
    Object object;

    public User() {
    }

    public User(int id, int type, String userId, String password, String nama) {
        this.id = id;
        this.type = type;
        this.userId = userId;
        this.password = password;
        this.nama = nama;
    }

    public Object getObject(int index) {
        switch(index){
            case 0: return getId();
            case 1: return getType();
            case 2: return getUserId();
            case 3: return getPassword();
            case 4: return getNama();
            default: return null;
        }
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

}
