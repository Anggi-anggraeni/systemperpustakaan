package projectperpus.aplikasi.systemperpustakaan.model;

import projectperpus.aplikasi.systemperpustakaan.entity.Buku;
import projectperpus.aplikasi.systemperpustakaan.entity.Jenis;
import projectperpus.aplikasi.systemperpustakaan.entity.Kategori;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewBuku;
import projectperpus.aplikasi.systemperpustakaan.entity.Penerbit;
import projectperpus.aplikasi.systemperpustakaan.utility.DbUtility;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class BukuModel {
    Connection connection;
    List<ViewBuku> listBuku;
    Vector  vectorJenis;
    Vector  vectorKategori;
    Vector  vectorPenerbit;
    Buku buku;
    Penerbit penerbit;
    ViewBuku lb;
    List<Jenis> listJenis;
    List<Penerbit> listPenerbit;

    public BukuModel() {
        connection = new DbUtility().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean insertBuku(Buku b){
        String query = "INSERT INTO BUKU "
        + "(jenis_id, kategori_id, judul, pengarang, penerbit_id, isbn, tahun, jumlah_tersedia, jumlah_terpinjam, jumlah_total) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(query);
            for(int i=1;i<=10;i++) statement.setObject(i, b.getObject(i));
            connection.setAutoCommit(false);
            if(statement.executeUpdate()==1) connection.commit();          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when insert data\n Error: "+ex.getMessage());
            try { connection.rollback(); } catch (SQLException exr) {}
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateBuku(Buku b){
        String query = "UPDATE BUKU SET "
        + "jenis_id=?, kategori_id=?, judul=?, pengarang=?, penerbit_id=?, isbn=?, "
        + "tahun=?, jumlah_tersedia=?, jumlah_terpinjam=?, jumlah_total=?  "
        + "WHERE id=?";
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement(query);
            for(int i=1;i<=10;i++) statement.setObject(i, b.getObject(i));
            statement.setInt(11, b.getId());
            connection.setAutoCommit(false);
            if(statement.executeUpdate()==1)
                connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when update data\n Error: "+ex.getMessage());
            try { connection.rollback(); } catch (SQLException exr) {}
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean deleteBuku(int id){
        String query = "DELETE FROM BUKU WHERE id=?";
        PreparedStatement statement=null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            if(statement.executeUpdate()==1) connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when delete data\n Error: "+ex.getMessage());
            try { connection.rollback(); } catch (SQLException exr) {}
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }
    
    public Buku getBuku(int id) {
        String query = "SELECT * FROM buku WHERE id=? ";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                buku = new Buku(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getString(5), 
                        rs.getInt(6), rs.getString(7), rs.getInt(8),rs.getInt(9), rs.getInt(10), rs.getInt(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data buku"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return buku;
    }

    public Penerbit getPenerbit(int id) {
        String query = "SELECT * FROM penerbit WHERE id=? ";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                penerbit = new Penerbit(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data penerbit"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return penerbit;
    }


    public List<ViewBuku> getListBuku() {
        listBuku = new ArrayList<ViewBuku>();
        String query = "SELECT * FROM listbuku ORDER BY `ID Buku`";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                lb = new ViewBuku(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                listBuku.add(lb);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listBuku;
    }

    public ViewBuku getListBuku(int id) {
        String query = "SELECT * FROM listbuku WHERE `ID Buku`=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                lb = new ViewBuku(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return lb;
    }

    public List<ViewBuku> getListBuku(String jenis, String kategori, String judul, String pengarang, String penerbit, int opt) {
        listBuku = new ArrayList<ViewBuku>();
        String query = "CALL ListBukuClaused(?,?,?,?,?,?)";
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(query);
            statement.setString(1, jenis);
            statement.setString(2, kategori);
            statement.setString(3, judul);
            statement.setString(4, pengarang);
            statement.setString(5, penerbit);
            statement.setInt(6, opt);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                lb = new ViewBuku(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                listBuku.add(lb);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listBuku;
    }

    public Vector  getVectorJenis() {
        vectorJenis = new Vector();
        String query = "SELECT nama_jenis from jenisbuku ORDER BY id";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            vectorJenis.add("");
            while(rs.next()){
                vectorJenis.add(rs.getString(1));
            }
        } catch (Exception e) {
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return vectorJenis;
    }

    public Vector getVectorKategori() {
        vectorKategori = new Vector();
        String query = "SELECT nama_kategori from kategoribuku ORDER BY id";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            vectorKategori.add("");
            while(rs.next()){
                vectorKategori.add(rs.getString(1));
            }
        } catch (Exception e) {
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return vectorKategori;
    }

    public List<Kategori> getListKategori(int id, String nama) {
        List<Kategori> listKategories = new ArrayList<Kategori>();
        String query = "CALL ListKategoriClaused(?, ?)";
        CallableStatement statement=null;
        try {
            statement = connection.prepareCall(query);
            statement.setInt(1, id);
            statement.setString(2, nama);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                listKategories.add(new Kategori(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error whene retrieve data \nError: "+e.getLocalizedMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listKategories;
    }

    public Vector getVectorPenerbit() {
        vectorPenerbit = new Vector();
        String query = "SELECT nama_penerbit from penerbit ORDER BY id";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            vectorPenerbit.add("");
            while(rs.next()){
                vectorPenerbit.add(rs.getString(1));
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error when retrieve data"+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return vectorPenerbit;
    }

    public Kategori getKategori(int idKategori) {
        PreparedStatement statement= null;
        Kategori kategori = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM kategoribuku WHERE id=?");
            statement.setInt(1, idKategori);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) kategori = new Kategori(rs.getInt(1), rs.getString(2));
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error when retrieve data"+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return kategori;
    }

    public boolean insertKategori(String kategori) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO kategoribuku (nama_kategori) VALUES(?)");
            statement.setString(1, kategori);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when insert data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateKategori(int id, String kategori) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE kategoribuku SET nama_kategori=? WHERE id=?");
            statement.setString(1, kategori);
            statement.setInt(2, id);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when update data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean deleteKategori(int id) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM kategoribuku  WHERE id=?");
            statement.setInt(1, id);
            if(statement.executeUpdate() == 1) connection.commit();
        }catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when delete data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public List<Jenis> getListJenis(int id, String nama) {
        listJenis = new ArrayList<Jenis>();
        CallableStatement statement = null;
        Jenis jenis;
        try {
            statement = connection.prepareCall("CALL ListJenisClaused(?, ?)");
            statement.setInt(1, id);
            statement.setString(2, nama);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                jenis = new Jenis(rs.getInt(1), rs.getString(2));
                listJenis.add(jenis);
            }
        }catch (Exception e) { JOptionPane.showMessageDialog(null, "Error when retrieve data"+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listJenis;
    }

    public Jenis getJenis(int idJenis) {
        Jenis jenis=null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM jenisbuku WHERE id=?");
            statement.setInt(1, idJenis);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){ jenis = new Jenis(rs.getInt(1), rs.getString(2)); }
        }catch (Exception e) { JOptionPane.showMessageDialog(null, "Error when retrieve data"+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return jenis;
    }

    public boolean insertJenis(String newJenis) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO jenisbuku (nama_jenis) VALUES (?)");
            statement.setString(1, newJenis);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when insert data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateJenis(int id, String newJenis) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE jenisbuku SET nama_jenis=? WHERE id=?");
            statement.setString(1, newJenis);
            statement.setInt(2, id);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when update data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean deleteJenis(int id) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM jenisbuku WHERE id=?");
            statement.setInt(1, id);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when update data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public List<Penerbit> getListPenerbit(int id, String nama, String kota, String email) {
         listPenerbit = new ArrayList<Penerbit>();
         CallableStatement statement = null;
         try {
            statement = connection.prepareCall("CALL ListPenerbitClaused(?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, nama);
            statement.setString(3, kota);
            statement.setString(4, email);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                penerbit = new Penerbit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listPenerbit.add(penerbit);
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Error when delete data"+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
         return listPenerbit;
    }

    public boolean insertPenerbit(Penerbit penerbit) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO penerbit (nama_penerbit, alamat, kota, email, telepon) VALUES (?,?,?,?,?)");
            statement.setInt(1, penerbit.getId());
            for (int i = 1; i < 6; i++) { statement.setString(i, penerbit.getObject(i).toString()); }
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when insert data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updatePenerbit(Penerbit penerbit) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE penerbit SET nama_penerbit=?, alamat=?, kota=?, email=?, telepon=? WHERE id=?");
            for (int i = 1; i < 6; i++) { statement.setString(i, penerbit.getObject(i).toString()); }
            statement.setInt(6, penerbit.getId());
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when update data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean deletePenerbit(int idPenerbit) {
        PreparedStatement statement= null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM penerbit WHERE id=?");
            statement.setInt(1, idPenerbit);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            try { connection.rollback();statement.close();} catch (Exception ex) { }
            JOptionPane.showMessageDialog(null, "Error when delete data"+e.getMessage());
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }


}
