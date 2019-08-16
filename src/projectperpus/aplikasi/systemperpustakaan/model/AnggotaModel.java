package projectperpus.aplikasi.systemperpustakaan.model;

import projectperpus.aplikasi.systemperpustakaan.entity.Anggota;
import projectperpus.aplikasi.systemperpustakaan.entity.Jurusan;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewAnggota;
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


public class AnggotaModel {
    Connection connection;
    List<ViewAnggota> listAnggota;
    Vector vectorJurusan;
    ViewAnggota la;
    Anggota anggota;
    List<Jurusan> listJurusan;
    Jurusan jurusan;

    public AnggotaModel() {
        connection = new DbUtility().getConnection();
    }

    public Anggota getAnggota(int id) {
        String query = "SELECT * FROM anggota WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                anggota = new Anggota(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getDate(10), rs.getDate(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data buku"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return anggota;
    }

    public Connection getConnection() {
        return connection;
    }

    public List<ViewAnggota> getListAnggota() {
        listAnggota = new ArrayList<ViewAnggota>();
        String query = "SELECT * FROM listanggota ORDER BY id";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                la = new ViewAnggota(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getDate(11));
                listAnggota.add(la);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listAnggota;
    }

    public ViewAnggota getListAnggota(int id) {
        String query = "SELECT * FROM listanggota WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                la = new ViewAnggota(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getDate(11));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return la;
    }

    public List<ViewAnggota> getListAnggota(String nim, String nama, String jurusan) {
        listAnggota = new ArrayList<ViewAnggota>();
        String query = "CALL ListAnggotaClaused(?,?,?)";
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(query);
            statement.setString(1, nim);
            statement.setString(2, nama);
            statement.setString(3, jurusan);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                la = new ViewAnggota(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getDate(11));
                listAnggota.add(la);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data"+ex.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listAnggota;
    }

    public Vector getVectorJurusan() {
        vectorJurusan = new Vector();
        String query = "SELECT nama_jurusan from jurusan ORDER BY id";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            vectorJurusan.add("");
            while(rs.next()){
                vectorJurusan.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return vectorJurusan;
    }

    public boolean insertAnggota(Anggota a){
        String query = "INSERT INTO anggota (nim, jurusan_id, nama, kota_lahir, tanggal_lahir, "
                                + "alamat, email, telepon, tanggal_register, akhir_register) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            for(int i=1; i<=10;i++)statement.setObject(i, a.getObject(i)); 
            if(statement.executeUpdate()==1) connection.commit();
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: "+e.getMessage());
            try {connection.rollback(); statement.close(); } catch (Exception ex) { }
            return  false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateAnggota(Anggota a){
        boolean result = false;
        String query = "UPDATE anggota  SET nim=?, jurusan_id=?, nama=?, kota_lahir=?, tanggal_lahir=?, "
                                + "alamat=?, email=?, telepon=?, tanggal_register=?, akhir_register=? WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            for(int i=1; i<=10;i++)statement.setObject(i, a.getObject(i));
            statement.setInt(11, a.getId());
            connection.setAutoCommit(false);
            if(statement.executeUpdate()==1){
                result = true;
            }
            connection.commit();
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error when update data \n Error: "+e.getMessage());
            try {connection.rollback(); statement.close(); } catch (Exception ex) { }
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return result;
    }

    public boolean deleteAnggota(int id){
        String query = "DELETE FROM anggota WHERE id=?";
        PreparedStatement statement=null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            connection.setAutoCommit(false);
            if(statement.executeUpdate() == 1) connection.commit();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: "+e.getMessage());
            try {connection.rollback(); statement.close();} catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public List<Jurusan> getListJurusan(int id, String nama) {
        listJurusan = new ArrayList<Jurusan>();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("CALL ListJurusanClaused(?, ?)");
            statement.setInt(1, id);
            statement.setString(2, nama);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                jurusan = new Jurusan(rs.getInt(1), rs.getString(2));
                listJurusan.add(jurusan);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listJurusan;
    }

    public boolean deleteJurusan(int id) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM jurusan WHERE id=? ");
            statement.setInt(1, id);
            if(statement.executeUpdate() == 1){
                connection.commit();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public Jurusan getJurusan(int id) {
        PreparedStatement statement= null;
        try {
            statement = connection.prepareStatement("SELECT * FROM jurusan WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                jurusan = new Jurusan(rs.getInt(1), rs.getString(2));
            }else{jurusan = new Jurusan();}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return jurusan;
    }

    public boolean insertJurusan(String nama) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO jurusan (nama_jurusan) VALUES (?)");
            statement.setString(1, nama);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: "+e.getMessage());
            try {connection.rollback(); statement.close();} catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateJurusan(int id, String nama) {
         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE jurusan SET nama_jurusan=? WHERE id=?");
            statement.setString(1, nama);
            statement.setInt(2, id);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when update data \n Error: "+e.getMessage());
            try {connection.rollback(); statement.close(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }
 

}
