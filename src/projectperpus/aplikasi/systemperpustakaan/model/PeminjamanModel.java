package projectperpus.aplikasi.systemperpustakaan.model;

import projectperpus.aplikasi.systemperpustakaan.entity.DetailPinjam;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewPeminjaman;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewPinjam;
import projectperpus.aplikasi.systemperpustakaan.utility.DateUtility;
import projectperpus.aplikasi.systemperpustakaan.utility.DbUtility;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PeminjamanModel {
    Connection connection;
    ViewPeminjaman vp;
    List<ViewPeminjaman> listPeminjaman;
    ViewPinjam pinjam;
    DetailPinjam detailPinjam;
    List<DetailPinjam> ListDetailPinjam;
    DateUtility du = new DateUtility();


    
    public PeminjamanModel() {
        connection = new DbUtility().getConnection();
    }
/*
 * Methoduntuk mengambil seluruh data peminjaman berdasarkan id, tanggal nim, nama dan option
 * mengguanakan procedure ListpeminjamanClaused
 */
    public List<ViewPeminjaman> getListpPeminjaman(int id, Date tglb, Date tgle, String nim, String nama, int opt) {
        Date date = null;
        listPeminjaman = new ArrayList<ViewPeminjaman>();
        String query = "CALL ListPeminjamanClaused(?,?,?,?,?,?)";
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(query);
            statement.setInt(1, id);
            statement.setString(2, tglb.toString());
            statement.setString(3, tgle.toString());
            statement.setString(4, nim);
            statement.setString(5, nama);
            statement.setInt(6, opt);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                if(rs.getDate(7).toString().equals("1900-01-01"))date=null; else date = rs.getDate(7);
                vp = new ViewPeminjaman(
                        rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), date,
                        rs.getString(8), rs.getString(9));
                listPeminjaman.add(vp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return listPeminjaman;
    }

    public Connection getConnection() {
        return connection;
    }
    
/*
 * Method untuk mengambil seluruh  data peminjama dari listpeminjaman berdasrkan no pinjam
 */
    public ViewPeminjaman getViewPeminjaman(int id) {
        Date date = null;
        String query = "SELECT * FROM listpeminjaman WHERE `No Pinjam`=?";
        PreparedStatement  statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                if(rs.getDate(7).toString().equals("1900-01-01"))date=null; else date = rs.getDate(7);
                vp = new ViewPeminjaman(
                        rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), du.createDate(rs.getString(7)), 
                        rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return vp;
    }

    /*
     * Method untuk mengambil data pinjam dari view listpinjam berdasarkan no pinjam
     */
    public ViewPinjam getPinjam(int id) {
        String query = "SELECT * FROM listpinjam WHERE `No Pinjam`=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                pinjam = new ViewPinjam( rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return pinjam;
    }

    /*
     * Method untuk mengabil seluruh data detailpinjam dari view listdetailpinjam
     * berdasarkan no pinjam
     */
    public List<DetailPinjam> getListDetailPinjam(int id) {
        Date date;
        ListDetailPinjam = new ArrayList<DetailPinjam>();
        String query = "SELECT * FROM ListDetailPinjam WHERE `No Pinjam`=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                if(rs.getDate(5).toString().equals("1900-01-01"))date=null; else date = rs.getDate(5);
                detailPinjam = new DetailPinjam( rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
                        date, rs.getInt(6), rs.getDouble(7));
                ListDetailPinjam.add(detailPinjam);
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return ListDetailPinjam;
    }
    
/*
 * Method untuk mengambil data detailn pinjam dari view listDetailPinjam berdasarkan no detail
 */
    public DetailPinjam getDetailPinjam(int id) {
        String query = "SELECT * FROM ListDetailPinjam WHERE `No Detail`=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                detailPinjam = new DetailPinjam( rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                        du.createDate(rs.getString(5)), rs.getInt(6), rs.getDouble(7));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return detailPinjam;
    }

    /*
     * Methode untuk menginsert data peminjaman baru ke table pinjam,
     * table detail pinjam dan update jumlah pada table buku
     */
    public boolean insertPinjam(int anggotaId, int userId, List<DetailPinjam> list){
        String query = "INSERT INTO pinjam (tanggal, anggota_id, `user`) VALUES(CURDATE(),?,?)";
        String queryDetail = "INSERT INTO pinjamdetail (pinjam_id, buku_id) VALUES ((SELECT id FROM pinjam  ORDER BY id DESC LIMIT 1),?)";
        String queryUpdateBuku = "UPDATE buku SET jumlah_tersedia = jumlah_tersedia-1, jumlah_terpinjam= jumlah_terpinjam+1 WHERE id =?";
        PreparedStatement statement = null;
        PreparedStatement statementDetail = null;
        PreparedStatement statementBuku = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setInt(1, anggotaId);
            statement.setInt(2, userId); 
            statementDetail = connection.prepareStatement(queryDetail);
            statementBuku = connection.prepareStatement(queryUpdateBuku);
            for(int i = 0; i<list.size();i++){
                statementDetail.setInt(1, list.get(i).getIdBuku());
                statementBuku.setInt(1, list.get(i).getIdBuku());
                statementDetail.addBatch();
                statementBuku.addBatch();
            }
            if(statement.executeUpdate()==1 && 
                    statementDetail.executeBatch().length > 0
                    && statementBuku.executeBatch().length > 0){
                connection.commit();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: "+e.getMessage());
            try { connection.rollback(); statement.close(); } catch (Exception ex) { }
            return false;
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return true;
    }

    /*
     * Fungsi untuk update data peminjaman, table yang diupdate table pinjam, table detail pinjam dan update jumlah pada table buku
     * data detailpinjam yang diupdate hanya yang tanggalnya tidak null dan status not complete
     */
    public boolean updatePinjam(int pinjamId, int anggotaId, int userId, List<DetailPinjam> list){ 
        String query = "UPDATE pinjam SET  anggota_id=?, `user`=? WHERE id=?";
        String queryDetail = "UPDATE pinjamdetail SET tanggal_kembali=?, terlambat=?, denda=? WHERE id=?";
        String queryUpdateBuku = "UPDATE buku SET jumlah_tersedia = jumlah_tersedia+1, jumlah_terpinjam= jumlah_terpinjam-1 WHERE id =?";
        PreparedStatement statement = null;
        PreparedStatement statementDetail = null;
        PreparedStatement statementBuku = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            statement.setInt(1, anggotaId); statement.setInt(2, userId); statement.setInt(3, pinjamId);
            statementDetail = connection.prepareStatement(queryDetail);
            statementBuku = connection.prepareStatement(queryUpdateBuku);
            for(int i = 0; i<list.size();i++){
               if(list.get(i).getTanggalKembali() != null &&  !isComplete(list.get(i).getNoDetail())){
                    statementDetail.setDate(1, list.get(i).getTanggalKembali());                        
                    statementDetail.setInt(2, list.get(i).getTerlambat());
                    statementDetail.setDouble(3, list.get(i).getDenda());
                    statementDetail.setInt(4, list.get(i).getNoDetail());
                    statementDetail.addBatch();
                    statementBuku.setInt(1, list.get(i).getIdBuku());
                    statementBuku.addBatch();
               }  
            }
            if(statement.executeUpdate()==1 
                    && statementDetail.executeBatch().length > 0){
                statementBuku.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when Update data \n Error: "+e.getMessage());
            try { connection.rollback(); statement.close(); } catch (Exception ex) {}
            return false;
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return true;
    }
/*
 * Fungsi untuk memeriksa  status peminjaman complete atau not complete, return true jika complete
 */
    public boolean isComplete(int id){
        boolean result = false;
        String status = null ;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT Status from listPeminjaman WHERE `No Detail`="+id);
            if (rs.next()) status = rs.getString(1);
            if(status.equals("Complete")) result = true;
        } catch (SQLException e) {
        }
        return result;
    }

    public int countPeminjamanNotCompleteByAnggota(String nim) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT COUNT(*) FROM listpeminjaman  WHERE `Status`='Not Complete' AND nim=?");
            statement.setString(1, nim);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }finally{if(statement!=null)try { statement.close(); } catch (Exception e) { }}
        return 0;
    }
}
