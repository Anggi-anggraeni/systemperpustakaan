package projectperpus.aplikasi.systemperpustakaan.view;

import projectperpus.aplikasi.systemperpustakaan.actionlistener.*;
import projectperpus.aplikasi.systemperpustakaan.component.MyDesktopPane;
import projectperpus.aplikasi.systemperpustakaan.component.MyMenu;
import projectperpus.aplikasi.systemperpustakaan.utility.UserUtility;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.*;
import projectperpus.aplikasi.systemperpustakaan.view.buku.*;
import projectperpus.aplikasi.systemperpustakaan.view.peminjaman.FramePeminjamanView;
import projectperpus.aplikasi.systemperpustakaan.view.user.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FrameMain extends javax.swing.JFrame {
    int noUser = UserUtility.userNo;
    /** Creates new form FrameMain */
    public FrameMain() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setMenu();
        setButton();
        setPrivilege();

        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        labelDate.setText(df.format(date)+"   ");
        labelUserName.setText("    SYSTEM INFORMASI PERPUSTAKAAN Version 1.0.0   Welcome: "+ UserUtility.name);
        radioNimbus.setSelected(true);
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;   
    }

    public int getNoUser() {
        return noUser;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
    
    public FrameBukuView getBukuView() {
        return bukuView;
    }

    public void setBukuView(FrameBukuView bukuView) {
        this.bukuView = bukuView;
    }

    public FrameKategoriView getKategoriView() {
        return kategoriView;
    }

    public void setKategoriView(FrameKategoriView kategoriView) {
        this.kategoriView = kategoriView;
    }

    public FrameJenisView getJenisView() {
        return jenisView;
    }

    public void setJenisView(FrameJenisView jenisView) {
        this.jenisView = jenisView;
    }

    public FramePenerbitView getPenerbitView() {
        return penerbitView;
    }

    public void setPenerbitView(FramePenerbitView penerbitView) {
        this.penerbitView = penerbitView;
    }

    public FrameAnggotaView getAnggotaView() {
        return anggotaView;
    }

    public void setAnggotaView(FrameAnggotaView anggotaView) {
        this.anggotaView = anggotaView;
    }

    public FrameJurusanView getJurusanView() {
        return jurusanView;
    }

    public void setJurusanView(FrameJurusanView jurusanView) {
        this.jurusanView = jurusanView;
    }

    public FramePeminjamanView getPeminjamanView() {
        return peminjamanView;
    }

    public void setPeminjamanView(FramePeminjamanView peminjamanView) {
        this.peminjamanView = peminjamanView;
    }

    public FrameUserView getUserView() {
        return userView;
    }

    public void setUserView(FrameUserView userView) {
        this.userView = userView;
    }

    public FrameUserTypeView getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(FrameUserTypeView typeUser) {
        this.typeUser = typeUser;
    }

   public final void setMenu(){
       menuFileExit.setActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {dispose(); }});
       menuFileClose.setActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {close(); }});
       menuFileLogout.setActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {logout(); }});
        menuViewBukuList.setActionListener(new MenuViewBukuActionListener(this));
        menuViewBukukategori.setActionListener(new MenuViewBukuKategoriActionListener(this));
        menuViewBukuJenis.setActionListener(new MenuViewBukuJenisActionListener(this));
        menuViewBukuPenerbit.setActionListener(new MenuViewBukuPenerbitActionListener(this));
        menuViewAnggotaList.setActionListener(new MenuViewAnggotaListActionListener(this));
        menuViewAnggotaJurusan.setActionListener(new MenuViewAnggotaJurusanActionListener(this));
        menuViewPeminjamanList.setActionListener(new MenuViewPeminjamanListActionListener(this));
        menuViewUserList.setActionListener(new MenuViewUserListActionListener(this));
        menuViewUserType.setActionListener(new MenuViewUsertypeActionListener(this));

        menuToolsNotepad.setActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {try {Runtime.getRuntime().exec("notepad");} catch (IOException ex) {}}});
        menuToolsCalculator.setActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {try {Runtime.getRuntime().exec("calc");} catch (IOException ex) {}}});
        menuCascade.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {  MyDesktopPane.cascade(desktopPane); }  });
        menuTile.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {  MyDesktopPane.tileVertical(desktopPane); }  });
        menuAbout.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { DialogAbout about = new DialogAbout(null, true);about.setVisible(true); } });
   }

    private void setButton() {
        buttonSearch.setActionListener(menuFileSearch.getActionListener());
        buttonDetail.setActionListener(menuFileDetail.getActionListener());
        buttonAddNew.setActionListener(menuFileAddNew.getActionListener());
        buttonEdit.setActionListener(menuFileDetail.getActionListener());
        buttonDelete.setActionListener(menuFileDelete.getActionListener());
        buttonRefresh.setActionListener(menuFileRefresh.getActionListener());
        buttonLogout.addActionListener(menuFileLogout.getActionListener());
        buttonClose.setActionListener(menuFileClose.getActionListener());
        buttonExit.addActionListener(menuFileExit.getActionListener());

        buttonListBuku.setActionListener(menuViewBukuList.getActionListener());
        buttonListAnggota.setActionListener(menuViewAnggotaList.getActionListener());
        buttonListPeminjaman.setActionListener(menuViewPeminjamanList.getActionListener());

        radioMetal.addActionListener(new MenuLookAndFeelActionListener(this));
        radioNimbus.addActionListener(new MenuLookAndFeelActionListener(this));
        radioWindows.addActionListener(new MenuLookAndFeelActionListener(this));
        radioMotif.addActionListener(new MenuLookAndFeelActionListener(this));

        buttonViewReport.setActionListener(menuReportView.getActionListener());
        buttonDownload.setActionListener(menuReportDownload.getActionListener());
        buttonPrint.setActionListener(menuReportPrint.getActionListener());
    }

    public MyMenu getMenuReportView() {
        return menuReportView;
    }

    public MyMenu getMenuReportDownload() {
        return menuReportDownload;
    }

    public MyMenu getMenuReportPrint() {
        return menuReportPrint;
    }
    
    public MyMenu getMenuFileSearch() {
        return menuFileSearch;
    }

    public MyMenu getMenuFileRefresh() {
        return menuFileRefresh;
    }

    public MyMenu getMenuFileDetail() {
        return menuFileDetail;
    }

    public MyMenu getMenuFileAddNew() {
        return menuFileAddNew;
    }

    public MyMenu getMenuFileDelete() {
        return menuFileDelete;
    }

    public JRadioButtonMenuItem getRadioMetal() {
        return radioMetal;
    }

    public JRadioButtonMenuItem getRadioMotif() {
        return radioMotif;
    }

    public JRadioButtonMenuItem getRadioNimbus() {
        return radioNimbus;
    }

    public JRadioButtonMenuItem getRadioWindows() {
        return radioWindows;
    }
    
    protected void close(){
        if(desktopPane.getSelectedFrame() != null){
            desktopPane.getSelectedFrame().dispose();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        buttonSearch = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonDetail = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonRefresh = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        buttonAddNew = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonEdit = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonDelete = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        buttonListBuku = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonListAnggota = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonListPeminjaman = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        buttonViewReport = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonDownload = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonPrint = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        buttonClose = new ahza.aplikasi.systemperpustakaan.component.MyButton();
        buttonLogout = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        labelUserName = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileSearch = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileAddNew = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileDetail = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileDelete = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileRefresh = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuFileClose = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileLogout = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuFileExit = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuEdit = new javax.swing.JMenu();
        menuEditAdd = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuEditUpdate = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuEditDelete = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuView = new javax.swing.JMenu();
        menuViewBuku = new javax.swing.JMenu();
        menuViewBukuList = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewBukukategori = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewBukuJenis = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewBukuPenerbit = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewAnggota = new javax.swing.JMenu();
        menuViewAnggotaList = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewAnggotaJurusan = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        jMenu3 = new javax.swing.JMenu();
        menuViewPeminjamanList = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuViewUser = new javax.swing.JMenu();
        menuViewUserList = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuViewUserType = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuReport = new javax.swing.JMenu();
        menuReportView = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuReportDownload = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuReportPrint = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuTools = new javax.swing.JMenu();
        menuToolsNotepad = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuToolsCalculator = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuToolsOptions = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        jMenu1 = new javax.swing.JMenu();
        radioNimbus = new javax.swing.JRadioButtonMenuItem();
        radioWindows = new javax.swing.JRadioButtonMenuItem();
        radioMetal = new javax.swing.JRadioButtonMenuItem();
        radioMotif = new javax.swing.JRadioButtonMenuItem();
        menuWindow = new javax.swing.JMenu();
        menuTile = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuCascade = new ahza.aplikasi.systemperpustakaan.component.MyMenu();
        menuAbout = new ahza.aplikasi.systemperpustakaan.component.MyMenu();

        buttonGroup.add(radioNimbus);
        buttonGroup.add(radioWindows);
        buttonGroup.add(radioMetal);
        buttonGroup.add(radioMotif);
        radioNimbus.setSelected(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setOpaque(false);

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Finddata toolbarS.png"))); // NOI18N
        buttonSearch.setToolTipText("Search Data");
        buttonSearch.setFocusable(false);
        buttonSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonSearch);

        buttonDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/detail toolbar.png"))); // NOI18N
        buttonDetail.setToolTipText("Detail Data");
        buttonDetail.setFocusable(false);
        buttonDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonDetail);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Refresh toolbar.png"))); // NOI18N
        buttonRefresh.setToolTipText("Refresh");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonRefresh);
        toolBar.add(jSeparator2);

        buttonAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Addnew toolbar.png"))); // NOI18N
        buttonAddNew.setToolTipText("Add New");
        buttonAddNew.setFocusable(false);
        buttonAddNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAddNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonAddNew);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Edit toolbar.png"))); // NOI18N
        buttonEdit.setToolTipText("Edit ");
        buttonEdit.setFocusable(false);
        buttonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonEdit);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Delete toolbar.png"))); // NOI18N
        buttonDelete.setToolTipText("Delete");
        buttonDelete.setFocusable(false);
        buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonDelete);
        toolBar.add(jSeparator1);

        buttonListBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/buku.png"))); // NOI18N
        buttonListBuku.setToolTipText("List Buku");
        buttonListBuku.setFocusable(false);
        buttonListBuku.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonListBuku.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonListBuku);

        buttonListAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/anggota.png"))); // NOI18N
        buttonListAnggota.setToolTipText("List Anggota");
        buttonListAnggota.setFocusable(false);
        buttonListAnggota.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonListAnggota.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonListAnggota);

        buttonListPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/peminjaman.png"))); // NOI18N
        buttonListPeminjaman.setToolTipText("List Peminjaman");
        buttonListPeminjaman.setFocusable(false);
        buttonListPeminjaman.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonListPeminjaman.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonListPeminjaman);
        toolBar.add(jSeparator3);

        buttonViewReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/viewreport toolbar.png"))); // NOI18N
        buttonViewReport.setToolTipText("View Report");
        buttonViewReport.setFocusable(false);
        buttonViewReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonViewReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonViewReport);

        buttonDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/downloadpdf toolbar.png"))); // NOI18N
        buttonDownload.setToolTipText("Download Report");
        buttonDownload.setFocusable(false);
        buttonDownload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDownload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonDownload);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/print toolbar.png"))); // NOI18N
        buttonPrint.setToolTipText("Print Report");
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonPrint);
        toolBar.add(jSeparator6);

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Close Toolbar.png"))); // NOI18N
        buttonClose.setToolTipText("Close Form");
        buttonClose.setFocusable(false);
        buttonClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonClose);

        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/logout.png"))); // NOI18N
        buttonLogout.setToolTipText("Log Out");
        buttonLogout.setFocusable(false);
        buttonLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonLogout);

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/ExitToolbar.png"))); // NOI18N
        buttonExit.setToolTipText("Exit");
        buttonExit.setFocusable(false);
        buttonExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(buttonExit);

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));
        desktopPane.setToolTipText("System Informasi Perpustakaan");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        labelUserName.setText("    SYSTEM INFORMASI PERPUSTAKAAN Version 1.0.0   Welcome: Muhamad Nur    ");

        labelDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDate.setText("2011-02-15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                    .addComponent(labelDate))
                .addGap(11, 11, 11))
        );

        menuFile.setText("File");

        menuFileSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuFileSearch.setText("Search");
        menuFile.add(menuFileSearch);

        menuFileAddNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuFileAddNew.setText("Add New");
        menuFile.add(menuFileAddNew);

        menuFileDetail.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuFileDetail.setText("Detail");
        menuFile.add(menuFileDetail);

        menuFileDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuFileDelete.setText("Delete");
        menuFile.add(menuFileDelete);

        menuFileRefresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuFileRefresh.setText("Refresh");
        menuFile.add(menuFileRefresh);
        menuFile.add(jSeparator4);

        menuFileClose.setText("Close");
        menuFile.add(menuFileClose);

        menuFileLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuFileLogout.setText("Log Out");
        menuFile.add(menuFileLogout);

        menuFileExit.setText("Exit");
        menuFile.add(menuFileExit);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Edit");

        menuEditAdd.setText("Cut");
        menuEdit.add(menuEditAdd);

        menuEditUpdate.setText("Copy");
        menuEdit.add(menuEditUpdate);

        menuEditDelete.setText("Paste");
        menuEdit.add(menuEditDelete);

        jMenuBar1.add(menuEdit);

        menuView.setText("View");

        menuViewBuku.setText("Buku");

        menuViewBukuList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menuViewBukuList.setText("List Buku");
        menuViewBuku.add(menuViewBukuList);

        menuViewBukukategori.setText("Kategori Buku");
        menuViewBuku.add(menuViewBukukategori);

        menuViewBukuJenis.setText("Jenis Buku");
        menuViewBuku.add(menuViewBukuJenis);

        menuViewBukuPenerbit.setText("Penerbit Buku");
        menuViewBuku.add(menuViewBukuPenerbit);

        menuView.add(menuViewBuku);

        menuViewAnggota.setText("Anggota");

        menuViewAnggotaList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuViewAnggotaList.setText("List Anggota");
        menuViewAnggota.add(menuViewAnggotaList);

        menuViewAnggotaJurusan.setText("Jurusan Anggota");
        menuViewAnggota.add(menuViewAnggotaJurusan);

        menuView.add(menuViewAnggota);

        jMenu3.setText("Peminjaman");

        menuViewPeminjamanList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuViewPeminjamanList.setText("List Peminjaman");
        jMenu3.add(menuViewPeminjamanList);

        menuView.add(jMenu3);
        menuView.add(jSeparator5);

        menuViewUser.setText("User");

        menuViewUserList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuViewUserList.setText("List User");
        menuViewUser.add(menuViewUserList);

        menuViewUserType.setText("Type User");
        menuViewUser.add(menuViewUserType);

        menuView.add(menuViewUser);

        jMenuBar1.add(menuView);

        menuReport.setText("Report");

        menuReportView.setText("View Report");
        menuReport.add(menuReportView);

        menuReportDownload.setText("Download Report");
        menuReport.add(menuReportDownload);

        menuReportPrint.setText("Print Report");
        menuReport.add(menuReportPrint);

        jMenuBar1.add(menuReport);

        menuTools.setText("Tools");

        menuToolsNotepad.setText("Notepad");
        menuTools.add(menuToolsNotepad);

        menuToolsCalculator.setText("Calculator");
        menuTools.add(menuToolsCalculator);

        menuToolsOptions.setText("Options");
        menuTools.add(menuToolsOptions);

        jMenu1.setText("Look And Feel");

        radioNimbus.setSelected(true);
        radioNimbus.setText("Nimbus");
        jMenu1.add(radioNimbus);

        radioWindows.setSelected(true);
        radioWindows.setText("Windows");
        jMenu1.add(radioWindows);

        radioMetal.setSelected(true);
        radioMetal.setText("Metal");
        jMenu1.add(radioMetal);

        radioMotif.setSelected(true);
        radioMotif.setText("Motif");
        jMenu1.add(radioMotif);

        menuTools.add(jMenu1);

        jMenuBar1.add(menuTools);

        menuWindow.setText("Window");

        menuTile.setText("Tile Windows");
        menuWindow.add(menuTile);

        menuCascade.setText("Cascade Windows");
        menuWindow.add(menuCascade);

        menuAbout.setText("About");
        menuWindow.add(menuAbout);

        jMenuBar1.add(menuWindow);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    

    @Override
    public void dispose() {
        if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan keluar?","Keluar Aplikasi",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            System.exit(0);
        }
        //super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonAddNew;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonClose;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonDelete;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonDetail;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonDownload;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.ButtonGroup buttonGroup;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonListAnggota;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonListBuku;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonListPeminjaman;
    private javax.swing.JButton buttonLogout;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonPrint;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonRefresh;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonSearch;
    private ahza.aplikasi.systemperpustakaan.component.MyButton buttonViewReport;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelUserName;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuAbout;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuCascade;
    private javax.swing.JMenu menuEdit;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuEditAdd;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuEditDelete;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuEditUpdate;
    private javax.swing.JMenu menuFile;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileAddNew;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileClose;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileDelete;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileDetail;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileExit;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileLogout;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileRefresh;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuFileSearch;
    private javax.swing.JMenu menuReport;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuReportDownload;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuReportPrint;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuReportView;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuTile;
    private javax.swing.JMenu menuTools;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuToolsCalculator;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuToolsNotepad;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuToolsOptions;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenu menuViewAnggota;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewAnggotaJurusan;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewAnggotaList;
    private javax.swing.JMenu menuViewBuku;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewBukuJenis;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewBukuList;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewBukuPenerbit;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewBukukategori;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewPeminjamanList;
    private javax.swing.JMenu menuViewUser;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewUserList;
    private ahza.aplikasi.systemperpustakaan.component.MyMenu menuViewUserType;
    private javax.swing.JMenu menuWindow;
    private javax.swing.JRadioButtonMenuItem radioMetal;
    private javax.swing.JRadioButtonMenuItem radioMotif;
    private javax.swing.JRadioButtonMenuItem radioNimbus;
    private javax.swing.JRadioButtonMenuItem radioWindows;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    FrameBukuView bukuView;
    FrameKategoriView kategoriView;
    FrameJenisView jenisView;
    FramePenerbitView penerbitView;

    FrameAnggotaView anggotaView;
    FrameJurusanView jurusanView;

    FramePeminjamanView peminjamanView;

    FrameUserView userView;
    FrameUserTypeView typeUser;
    
    static {
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setPrivilege() {
        menuViewBukuList.setEnabled(UserUtility.privilege[UserUtility.BUKU]);
        menuViewBukuJenis.setEnabled(UserUtility.privilege[UserUtility.JENIS_BUKU]);
        menuViewBukukategori.setEnabled(UserUtility.privilege[UserUtility.KATEGORI_BUKU]);
        menuViewBukuPenerbit.setEnabled(UserUtility.privilege[UserUtility.PENERBIT]);
        menuViewAnggotaList.setEnabled(UserUtility.privilege[UserUtility.ANGGOTA]);
        menuViewAnggotaJurusan.setEnabled(UserUtility.privilege[UserUtility.JURUSAN]);
        menuViewPeminjamanList.setEnabled(UserUtility.privilege[UserUtility.PEMINJAMAN]);
        menuViewUserList.setEnabled(UserUtility.privilege[UserUtility.USER]);
        menuViewUserType.setEnabled(UserUtility.privilege[UserUtility.TYPE_USER]);
        menuFileAddNew.setEnabled(UserUtility.privilege[UserUtility.INSERT]);
        menuFileDetail.setEnabled(UserUtility.privilege[UserUtility.UPDATE]);
        menuFileDelete.setEnabled(UserUtility.privilege[UserUtility.DELETE]);

        buttonListBuku.setEnabled(menuViewBukuList.isEnabled());
        buttonListAnggota.setEnabled(menuViewAnggotaList.isEnabled());
        buttonListPeminjaman.setEnabled(menuViewPeminjamanList.isEnabled());
        buttonAddNew.setEnabled(menuFileAddNew.isEnabled());
        buttonEdit.setEnabled(menuFileDetail.isEnabled());
        buttonDetail.setEnabled(menuFileDetail.isEnabled());
        buttonDelete.setEnabled(menuFileDelete.isEnabled());

    }

    public void logout(){
        super.dispose();
        UserUtility.initUser();
        FrameLogin fl = new FrameLogin(null, true);
        fl.setVisible(true);
    }

    
}




