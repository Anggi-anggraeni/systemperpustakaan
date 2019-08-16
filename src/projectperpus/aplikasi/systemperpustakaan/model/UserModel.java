package projectperpus.aplikasi.systemperpustakaan.model;

import projectperpus.aplikasi.systemperpustakaan.entity.User;
import projectperpus.aplikasi.systemperpustakaan.entity.UserType;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewUser;
import projectperpus.aplikasi.systemperpustakaan.utility.DbUtility;
import projectperpus.aplikasi.systemperpustakaan.utility.UserUtility;
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


public class UserModel {
    Connection connection;
    ViewUser viewUser;
    Vector vectorType;
    List<ViewUser> listUser;
    List<UserType> listUserType;
    UserType userType;
    User user;

    public UserModel() {
        this.connection = new DbUtility().getConnection();
    }

    public ViewUser getViewUser(int id) {
        String query = "SELECT * FROM listuser WHERE `No User`=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                viewUser = new ViewUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return viewUser;
    }

    public List<ViewUser> getListUser(String userId, String nama, String privilege) {
        listUser = new ArrayList<ViewUser>();
        String query = "CALL ListUserClaused(?,?,?)";
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(query);
            statement.setString(1, userId);
            statement.setString(2, nama);
            statement.setString(3, privilege);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                viewUser = new ViewUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listUser.add(viewUser);
            }
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when insert data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return listUser;
    }
 public Vector getVectorType(){
     vectorType = new Vector();
     Statement statement = null;
     try {
         statement = connection.createStatement();
         ResultSet rs =  statement.executeQuery("SELECT nama FROM typeuser");
         vectorType.add("");
         while(rs.next()){
             vectorType.add(rs.getString(1));
         }
     }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
     return vectorType;
 }

    public List<UserType> getListUserType(int id, String nama) {
        listUserType = new ArrayList<UserType>();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("CALL ListUserTypeClaused(?, ?) ");
            statement.setInt(1, id);
            statement.setString(2, nama);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                userType = new UserType(rs.getInt(1), rs.getString(2), rs.getString(3));
                listUserType.add(userType);
            }
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return  listUserType;
    }

    public boolean deleteUserType(int idType) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM typeuser WHERE id=?");
            statement.setInt(1, idType);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: "+e.getMessage());
            try{connection.rollback(); }catch(SQLException ex){}
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public UserType getUserType(int idType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM typeuser WHERE id=?");
            statement.setInt(1, idType);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                userType = new UserType(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return userType;
    }

    public boolean insertTypeUser(String nama, String priv) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO typeuser (nama, privilege) VALUES"
                    + "(?,CONCAT('POWERED BY MUHAMAD NUR',PASSWORD(?), ?))");
            statement.setString(1, nama);
            statement.setString(2, priv);
            statement.setString(3, priv);
            if(statement.executeUpdate()==1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when insert  data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateTypeUser(int id, String nama, String priv) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("UPDATE typeuser SET nama=?, "
                    + "privilege=CONCAT('POWERED BY MUHAMAD NUR',PASSWORD(?), ?) WHERE id=?");
            statement.setString(1, nama);
            statement.setString(2, priv);
            statement.setString(3, priv);
            statement.setInt(4, id);
            if(statement.executeUpdate()==1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when update  data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public User getUser(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when retrieve  data \n Error: "+e.getMessage());
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return  user;
    }

    public boolean insertUser(User user) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("INSERT INTO users (type, user_id, password, nama) VALUES (?,?,PASSWORD(?),?)");
            statement.setInt(1, user.getType());
            statement.setString(2, user.getUserId());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getNama());
            if(statement.executeUpdate()==1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when insert  data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean updateUser(User user) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            if(user.getPassword().equals("password")){
                statement = connection.prepareStatement("UPDATE users SET type=?, user_id=?, nama=? WHERE id=?");
                statement.setInt(1, user.getType());
                statement.setString(2, user.getUserId());
                statement.setString(3, user.getNama());
                statement.setInt(4, user.getId());
            }else{
                statement = connection.prepareStatement("UPDATE users SET type=?, user_id=?, password=PASSWORD(?), nama=? WHERE id=?");
                statement.setInt(1, user.getType());
                statement.setString(2, user.getUserId());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getNama());
                statement.setInt(5, user.getId());
            } 
            if(statement.executeUpdate()==1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when update  data \n Error: "+e.getMessage());
            try {connection.rollback(); } catch (Exception ex) { }
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean deleteUser(int id) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            statement.setInt(1, id);
            if(statement.executeUpdate() == 1) connection.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error when delete data \n Error: "+e.getMessage());
            try{connection.rollback(); }catch(SQLException ex){}
            return false;
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return true;
    }

    public boolean isRegistered(String userName, String password) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * from users WHERE user_id=? AND `password`=PASSWORD(?)");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                UserUtility uu = new UserUtility(getUserType(rs.getInt(2)).getPrivilege());
                UserUtility.userNo = rs.getInt(1);
                UserUtility.name = rs.getString(5);
                return true;
            }
        } catch (Exception e) {
        }finally{try {if(statement != null)statement.close(); } catch (Exception e) { }}
        return false;
    }

}
