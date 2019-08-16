package projectperpus.aplikasi.systemperpustakaan.controller;

import projectperpus.aplikasi.systemperpustakaan.entity.User;
import projectperpus.aplikasi.systemperpustakaan.entity.UserType;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewUser;
import projectperpus.aplikasi.systemperpustakaan.model.UserModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.UserTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.UserTypeTableModel;
import projectperpus.aplikasi.systemperpustakaan.view.FrameLogin;
import projectperpus.aplikasi.systemperpustakaan.view.user.DialogDetailUser;
import projectperpus.aplikasi.systemperpustakaan.view.user.DialogDetailUserType;
import projectperpus.aplikasi.systemperpustakaan.view.user.FrameUserTypeView;
import projectperpus.aplikasi.systemperpustakaan.view.user.FrameUserView;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UserController {
    FrameUserView userView;
    UserModel model;
    FrameUserTypeView typeUserView;
    DialogDetailUserType detailUserType;
    DialogDetailUser detailUser;
    ViewUser vUser;
    User user;
    FrameLogin frameLogin;

    public UserController(FrameUserView userView) {
         this.userView = userView;
    }

    public UserController(FrameUserView userView, UserModel model) {
        this.userView = userView;
        this.model = model;
    }

    public UserController(FrameUserTypeView typeUserView, UserModel model) {
        this.typeUserView = typeUserView;
        this.model = model;
    }

    public UserController() {
    }

    public UserModel getModel() {
        return model;
    }

    public void setDetailUser(DialogDetailUser detailUser) {
        this.detailUser = detailUser;
    }

    public FrameUserTypeView getTypeUserView() {
        return typeUserView;
    }

    public void setModel(UserModel model) {
        this.model = model;
    }

    public FrameUserView getUserView() {
        return userView;
    }

    public void fillComboType() {
        Vector vectorType = model.getVectorType();
        userView.getComboType().setModel(new DefaultComboBoxModel(vectorType));
    }

    public void findListUser() {
        userView.setTableModel(new UserTableModel());
        userView.getTableModel().setList(model.getListUser(
                userView.getTextUserId().getText(),
                userView.getTextNama().getText(),
                userView.getComboType().getSelectedItem().toString()));
        userView.getTableUser().setModel(userView.getTableModel());
        userView.setTableWidth();
        userView.setUserNo(-1);
    }

    public void refresh() {
        userView.getTextUserId().setText("");
        userView.getTextNama().setText("");
        userView.getComboType().setSelectedIndex(0);
        findListUser();
    }

    public void findListUserType() {
        int idUserType = -1;
        if(!typeUserView.getTextId().getText().equals("")){
            try {
                idUserType = Integer.valueOf(typeUserView.getTextId().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(typeUserView, "Field ini harus diisi dengan angka");
                typeUserView.getTextId().setText("");
            }
        }
        typeUserView.setTableModel(new UserTypeTableModel());
        typeUserView.getTableModel().setList(model.getListUserType(idUserType, typeUserView.getTextNama().getText()));
        typeUserView.getTableType().setModel(typeUserView.getTableModel());
        typeUserView.getTableType().getColumnModel().getColumn(1).setPreferredWidth(120);
        typeUserView.getTableType().getColumnModel().getColumn(2).setPreferredWidth(500);
    }

    public void refreshUserType() {
        typeUserView.getTextId().setText("");
        typeUserView.getTextNama().setText("");
        findListUserType();
    }

    public void saveDeleteUserType() {
        if(JOptionPane.showConfirmDialog(typeUserView, "Apakah anda yakin akan menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deleteUserType(typeUserView.getIdType())){
                JOptionPane.showMessageDialog(typeUserView, "Hapus data sukses");
                findListUserType();
            }else{
                JOptionPane.showMessageDialog(typeUserView, "Hapus data gagal");
            }
        }
    }

    public void setDetailUserType(DialogDetailUserType detailUserType) {
        this.detailUserType = detailUserType;
    }

    public void showDetailUserType(int idType) {
        UserType userType = model.getUserType(idType);
        detailUserType.getTextId().setText(userType.getId()+"");
        detailUserType.getTextNama().setText(userType.getNama());
        String privilege = userType.getPrivilege().substring(63, 75);
        for(int i=0; i<12; i++){ detailUserType.getTablePrivilege().setValueAt(isTrue(privilege.substring(i, i+1)), i, 1); }
    }

    public boolean isTrue(String p){ if(p.equals("1")) return true; else return false; }

    public void saveNewUserType() {
        if(detailUserType.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(detailUserType, "Nama Type User masih kosong");
            detailUserType.getTextNama().requestFocus();
        }else{
            String privilege = createPrivilge();
            if(model.insertTypeUser(detailUserType.getTextNama().getText(), privilege)){
                JOptionPane.showMessageDialog(detailUserType, "Simpan type baru sukses");
                findListUserType();
                detailUserType.dispose();
            }else{
                JOptionPane.showMessageDialog(detailUserType, "Simpan type baru gagal");
            }
        }
    }

    public void saveUpdateUserType() {
        if(detailUserType.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(detailUserType, "Nama Type User masih kosong");
            detailUserType.getTextNama().requestFocus();
        }else{
            String privilege = createPrivilge();
            int id = Integer.valueOf(detailUserType.getTextId().getText());
            if(model.updateTypeUser(id,detailUserType.getTextNama().getText(), privilege)){
                JOptionPane.showMessageDialog(detailUserType, "Update type baru sukses");
                findListUserType();
                detailUserType.dispose();
            }else{
                JOptionPane.showMessageDialog(detailUserType, "Update type baru gagal");
            }
        }
    }

    private String createPrivilge() {
         String priv="";
         for(int i=0; i <12; i++){
             if(Boolean.valueOf(detailUserType.getTablePrivilege().getValueAt(i, 1).toString()))priv += "1";else priv +="0"; 
        }
         return priv;
    }

    public void showDetailUser(int id) {
        user = model.getUser(id);
        detailUser.getTextUserNo().setText(user.getId()+"");
        detailUser.getTextUserId().setText(user.getUserId());
        detailUser.getTextNamaUser().setText(user.getNama());
        setSelectedType(user.getType());
    }

    public void saveNewUser() {
        if(detailUser.getTextUserId().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "User Id Masih kosong");
        }else if(detailUser.getTextNamaUser().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Nama user Masih kosong");
        }if(detailUser.getTextTypeId().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Type User Masih kosong");
        }else if(detailUser.getTextPassword().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Password Masih kosong");
        }else{
            user = new User(0,
                    Integer.valueOf(detailUser.getTextTypeId().getText()),
                    detailUser.getTextUserId().getText(),
                    detailUser.getTextPassword().getText(),
                    detailUser.getTextNamaUser().getText());
            if(model.insertUser(user)){
                JOptionPane.showMessageDialog(detailUser, "Simpan user baru sukses");
                findListUser();
                userView.setTableWidth();
                detailUser.dispose();
            }else{
                JOptionPane.showMessageDialog(detailUser, "Simpan user baru gagal");
            }
        }
    }

    public void setSelectedType(int id) {
        UserType ut = model.getUserType(id);
        detailUser.getTextTypeId().setText(ut.getId()+"");
        detailUser.getTextNamaType().setText(ut.getNama());
    }

    public void saveUpdateUser() {
        if(detailUser.getTextUserId().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "User Id Masih kosong");
        }else if(detailUser.getTextNamaUser().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Nama user Masih kosong");
        }if(detailUser.getTextTypeId().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Type User Masih kosong");
        }else if(detailUser.getTextPassword().getText().equals("")){
            JOptionPane.showMessageDialog(detailUser, "Password Masih kosong");
        }else{
            user = new User(
                    Integer.valueOf(detailUser.getTextUserNo().getText()),
                    Integer.valueOf(detailUser.getTextTypeId().getText()),
                    detailUser.getTextUserId().getText(),
                    detailUser.getTextPassword().getText(),
                    detailUser.getTextNamaUser().getText());
            if(model.updateUser(user)){
                JOptionPane.showMessageDialog(detailUser, "Update data user  sukses");
                findListUser();
                userView.setTableWidth();
                detailUser.dispose();
            }else{
                JOptionPane.showMessageDialog(detailUser, "Update data user  gagal");
            }
        }
    }

    public void saveDeleteUser() {
        if(JOptionPane.showConfirmDialog(userView, "Apakah anda yakin akan menghapus data ini?","Hapus user",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deleteUser(userView.getUserNo())){
                JOptionPane.showMessageDialog(detailUser, "Delete user user  sukses");
                findListUser();
            }else{
                JOptionPane.showMessageDialog(detailUser, "Delete user user  gagal");
            }
        }
    }

    public boolean login() {
        if(frameLogin.getTextUserName().getText().equals("")){
            JOptionPane.showMessageDialog(frameLogin, "Masukan userName Anda");
            frameLogin.getTextUserName().requestFocus();
        }else if(frameLogin.getTextPassword().getText().equals("")){
            JOptionPane.showMessageDialog(frameLogin, "Masukan Password Anda");
            frameLogin.getTextPassword().requestFocus();
        }else {
            String userName = frameLogin.getTextUserName().getText();
            String password = frameLogin.getTextPassword().getText();
            if(model.isRegistered(userName, password)){
                return true;
            }else{
                JOptionPane.showMessageDialog(frameLogin, "Username atau Password anda salah, \n "
                        + "pastikan anda ketik username dan password dengan benar ");
            }
        }
        return false;
    }

    public void setFrameLogin(FrameLogin frameLogin) {
        this.frameLogin = frameLogin;
    }

}
