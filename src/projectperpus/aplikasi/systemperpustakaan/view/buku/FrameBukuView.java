/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameBukuView.java
 *
 * Created on Feb 1, 2011, 11:34:25 AM
 */

package ahza.aplikasi.systemperpustakaan.view.buku;

import ahza.aplikasi.systemperpustakaan.controller.BukuController;
import ahza.aplikasi.systemperpustakaan.model.BukuModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.BukuTableModel;
import ahza.aplikasi.systemperpustakaan.utility.ReportUtility;
import ahza.aplikasi.systemperpustakaan.utility.UserUtility;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ahza
 */
public class FrameBukuView extends javax.swing.JInternalFrame implements InternalFrameListener, ListSelectionListener{

    int opt=-1;
    int bukuId = -1;

    /** Creates new form FrameBukuView */
    public FrameBukuView(FrameMain frameMain) {
        this.frameMain = frameMain;
        initComponents();
        bukuModel = new BukuModel();
        controller = new BukuController(this, bukuModel);
        tableView.setModel(new BukuTableModel());
        tableView.getSelectionModel().addListSelectionListener(this);
        addInternalFrameListener(this);
        setTableView();
        setCombo();
        setRadio();
    }

    public  final void setTableView(){
        int[] width={70,100,100,300,200,200,150,80,80,80,80,};
        for(int i=0;i<11;i++){
            tableView.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }
        centerCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        rightCellRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tableView.getColumnModel().getColumn(7).setCellRenderer(centerCellRenderer);
        tableView.getColumnModel().getColumn(8).setCellRenderer(rightCellRenderer);
        tableView.getColumnModel().getColumn(9).setCellRenderer(rightCellRenderer);
        tableView.getColumnModel().getColumn(10).setCellRenderer(rightCellRenderer);
    }

     protected final void setCombo(){
        controller.fillComboJenis(comboJenis);
        controller.fillComboKategori(comboKategori);
        comboPenerbit.setModel(new DefaultComboBoxModel(bukuModel.getVectorPenerbit()));
        comboJenis.setSelectedIndex(0);
        comboKategori.setSelectedIndex(0);
        comboPenerbit.setSelectedIndex(0);
     }

     protected final void setRadio() {
        radioSemua.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {opt = PILIH_SEMUA; } });
        radioTersedia.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {opt = PILIH_TERSEDIA; } });
        radioTerpinjam.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {opt = PILIH_TERPINJAM; } });
        radioSemua.setSelected(true);
     }

    public int getBukuId() {
        return bukuId;
    }

    public FrameMain getFrameMain() {
        return frameMain;
    }

    public DialogBukuDetail getBukuDetail() {
        return bukuDetail;
    }

    public BukuTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(BukuTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTableView() {
        return tableView;
    }

    public int getOpt() {
        return opt;
    }

    public void setBukuId(int bukuId) {
        this.bukuId = bukuId;
    }
   
    public JComboBox getComboJenis() {
        return comboJenis;
    }

    public JComboBox getComboKategori() {
        return comboKategori;
    }

    public JComboBox getComboPenerbit() {
        return comboPenerbit;
    }

    public JTextField getTextJudul() {
        return textJudul;
    }

    public JTextField getTextPengarang() {
        return textPengarang;
    }

    public JRadioButton getRadioSemua() {
        return radioSemua;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public void setAction(){
        frameMain.getMenuFileSearch().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()) controller.findListBuku(); }
        });

        frameMain.getMenuFileRefresh().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()){controller.refreshListBuku(); }}
        });

        frameMain.getMenuFileDetail().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(bukuId > -1 && isSelected()){
                    bukuDetail = new DialogBukuDetail(frameMain, true,controller, bukuId);
                    bukuDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileAddNew().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected()){
                    bukuDetail = new DialogBukuDetail(frameMain, true, controller);
                    bukuDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileDelete().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(bukuId > -1 && isSelected()){
                    controller.saveDeleteBuku();
                }
            }
        });

        frameMain.getMenuReportView().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected() && tableView.getRowCount() >0) controller.report(ReportUtility.SHOW);
            }
        });

        frameMain.getMenuReportDownload().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected() && tableView.getRowCount() >0) controller.report(ReportUtility.DOWNLOAD);
            }
        });

        frameMain.getMenuReportPrint().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected() && tableView.getRowCount() >0) controller.report(ReportUtility.PRINT);
            }
        });
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        comboJenis = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboKategori = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        radioTersedia = new javax.swing.JRadioButton();
        radioTerpinjam = new javax.swing.JRadioButton();
        radioSemua = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        textJudul = new javax.swing.JTextField();
        textPengarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboPenerbit = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        myLabel1 = new ahza.aplikasi.systemperpustakaan.component.MyLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        buttonGroup.add(radioTersedia);
        buttonGroup.add(radioTerpinjam);
        buttonGroup.add(radioSemua);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daftar Buku");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Option"));

        comboJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Jenis :");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kategori :");

        comboKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Jumlah "));

        radioTersedia.setText("Tersedia");

        radioTerpinjam.setText("Terpinjam");

        radioSemua.setText("Semua");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioTersedia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioTerpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioSemua)
                    .addComponent(radioTersedia)
                    .addComponent(radioTerpinjam))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Judul : ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Pengarang : ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Penerbit : ");

        comboPenerbit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableView.setAutoCreateRowSorter(true);
        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableView.setRowHeight(22);
        tableView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableView.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableView);

        myLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myLabel1.setIconReflec(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Medium 339.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Daftar Buku Perpustakaan");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Daftar Buku Perpustakaan Yang Tersedia");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText(" dan Terpinjam");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox comboJenis;
    private javax.swing.JComboBox comboKategori;
    private javax.swing.JComboBox comboPenerbit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private ahza.aplikasi.systemperpustakaan.component.MyLabel myLabel1;
    private javax.swing.JRadioButton radioSemua;
    private javax.swing.JRadioButton radioTerpinjam;
    private javax.swing.JRadioButton radioTersedia;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField textJudul;
    private javax.swing.JTextField textPengarang;
    // End of variables declaration//GEN-END:variables

    public static final int PILIH_SEMUA = -1;
    public static final int PILIH_TERPINJAM = 0;
    public static final int PILIH_TERSEDIA = 1;
    

    FrameMain frameMain;
    DialogBukuDetail bukuDetail;
    BukuController controller;
    BukuModel bukuModel;
    BukuTableModel tableModel;
    
    DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();

    public void internalFrameOpened(InternalFrameEvent e) { }

    public void internalFrameClosing(InternalFrameEvent e) {  }

    public void internalFrameClosed(InternalFrameEvent e) {frameMain.getDesktopPane().selectFrame(true); }

    public void internalFrameIconified(InternalFrameEvent e) { }

    public void internalFrameDeiconified(InternalFrameEvent e) { }

    public void internalFrameActivated(InternalFrameEvent e) { setAction(); }

    public void internalFrameDeactivated(InternalFrameEvent e) { }

    public void valueChanged(ListSelectionEvent e) {
        try {
            bukuId=Integer.valueOf(tableView.getValueAt(tableView.getSelectedRow(), 0).toString());
        } catch (Exception ex) { }
    }
    
}
