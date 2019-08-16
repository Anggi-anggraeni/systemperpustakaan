package projectperpus.aplikasi.systemperpustakaan.utility;

public class UserUtility {
    public static final int BUKU = 0;
    public static final int JENIS_BUKU = 1;
    public static final int KATEGORI_BUKU = 2;
    public static final int PENERBIT = 3;
    public static final int ANGGOTA = 4;
    public static final int JURUSAN = 5;
    public static final int PEMINJAMAN = 6;
    public static final int USER = 7;
    public static final int TYPE_USER = 8;
    public static final int INSERT = 9;
    public static final int UPDATE = 10;
    public static final int DELETE = 11;

    public static boolean[] privilege = new boolean[12];
    public static int userNo = -1;
    public static String name = "";
    public UserUtility(String priv) {
        setPrivilege(priv);
    }

    private void setPrivilege(String text){
        String priv = text.substring(63, 75);
        for(int i=0; i < 12; i++){ if(priv.substring(i, i+1).equals("1")) privilege[i] = true; else privilege[i]=false;}
    }

    public static void initUser() { for(int i=0; i < 12; i++)privilege[i] = false; }

}
