/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FramePeminjamanView.java
 *
 * Created on Feb 3, 2011, 11:01:47 AM
 */

package ahza.aplikasi.systemperpustakaan.view.peminjaman;

import ahza.aplikasi.systemperpustakaan.controller.PeminjamanController;
import ahza.aplikasi.systemperpustakaan.model.PeminjamanModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.PeminjamanTableModel;
import ahza.aplikasi.systemperpustakaan.utility.DateUtility;
import ahza.aplikasi.systemperpustakaan.utility.ReportUtility;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ahza
 */
public class FramePeminjamanView extends javax.swing.JInternalFrame implements InternalFrameListener, ListSelectionListener{
    FrameMain frameMain;
    PeminjamanModel model;
    PeminjamanController controller;
    PeminjamanTableModel tableModel;
    DateUtility du = new DateUtility();
    int noPinjam = -1;
    int opt = -1;;

    /** Creates new form FramePeminjamanView */
    public FramePeminjamanView(FrameMain frameMain) {
        this.frameMain = frameMain;
        model = new PeminjamanModel();
        controller = new PeminjamanController(this, model);
        initComponents();

        addInternalFrameListener(this);
        tableView.getSelectionModel().addListSelectionListener(this);
        tableView.setModel(new PeminjamanTableModel());
        setRadio();
        setTableWidth();
    }

    public FrameMain getFrameMain() {
        return frameMain;
    }

    public void setNoPinjam(int noPinjam) {
        this.noPinjam = noPinjam;
    }

    public int getNoPinjam() {
        return noPinjam;
    }

    public final void setTableWidth(){
        int[] width = {100,100,200,250,100,300,150,150,150};
        for(int i=0;i<9;i++) tableView.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
    }

    public PeminjamanTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(PeminjamanTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTableView() {
        return tableView;
    }

    public JRadioButton getRadioAll() {
        return radioAll;
    }

    public JRadioButton getRadioComplete() {
        return radioComplete;
    }

    public JRadioButton getRadioUnComplete() {
        return radioUnComplete;
    }

    public JTextField getTextNama() {
        return textNama;
    }

    public JTextField getTextNim() {
        return textNim;
    }

    public JTextField getTextNo() {
        return textNo;
    }

    public JTextField getTextTanggalBegin() {
        return textTanggalBegin;
    }

    public JTextField getTextTanggalEnd() {
        return textTanggalEnd;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public final void setRadio(){
        radioAll.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { opt = -1;  }  });
        radioUnComplete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { opt = 0;  }  });
        radioComplete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { opt = 1;  }  });
    }

    public final void setAction(){
        frameMain.getMenuFileSearch().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()) controller.findDataPeminjaman(); }
        });

        frameMain.getMenuFileRefresh().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()){controller.clear();controller.findDataPeminjaman(); }}
        });

        frameMain.getMenuFileDetail().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(noPinjam > -1 && isSelected()){
                    DialogPeminjamanDetail peminjamanDetail = new DialogPeminjamanDetail(frameMain, true, controller, noPinjam);
                    peminjamanDetail.setVisible(true);
                }
              }
        });

        frameMain.getMenuFileAddNew().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected()){
                    DialogPeminjamanDetail peminjamanDetail = new DialogPeminjamanDetail(frameMain, true, controller);
                    peminjamanDetail.setVisible(true);
                }
              }
        });

        frameMain.getMenuFileDelete().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noPinjam > -1 && isSelected()){
                    controller.saveDeletePeminjaman();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        myLabel1 = new ahza.aplikasi.systemperpustakaan.component.MyLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textNo = new javax.swing.JTextField();
        textTanggalBegin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textNim = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        radioAll = new javax.swing.JRadioButton();
        radioComplete = new javax.swing.JRadioButton();
        radioUnComplete = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        textTanggalEnd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        buttonGroup.add(radioAll);
        buttonGroup.add(radioComplete);
        buttonGroup.add(radioUnComplete);
        radioAll.setSelected(true);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daftar Peminjaman");

        tableView.setAutoCreateRowSorter(true);
        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tableView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableView.setRowHeight(22);
        tableView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableView.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableView);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Daftar Tansaksi Peminjmana Buku dan Lainnya");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Daftar Peminjman Buku Perpustakaan");

        myLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myLabel1.setIconReflec(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Medium 404.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("No Peminjaman : ");

        jLabel1.setText("    ( YYYY-MM-DD )                ( YYYY-MM-DD )");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("NIM : ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Option Status"));

        radioAll.setText("All");

        radioComplete.setText("Complete");

        radioUnComplete.setText("Not Complete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioUnComplete)
                    .addComponent(radioComplete)
                    .addComponent(radioAll))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(radioAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioUnComplete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup.add(radioAll);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nama : ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("~");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tanggal Pinjam : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(textTanggalBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textTanggalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(textNo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNama, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTanggalBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(textTanggalEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textTanggalBegin.setText(du.getBeginOfMonthDate().toString());
        textTanggalEnd.setText(du.getEndOfMonthDate().toString());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Baik Status Complete Maupun Belum Complete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(15, 15, 15)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addComponent(myLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private ahza.aplikasi.systemperpustakaan.component.MyLabel myLabel1;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioComplete;
    private javax.swing.JRadioButton radioUnComplete;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNim;
    private javax.swing.JTextField textNo;
    private javax.swing.JTextField textTanggalBegin;
    private javax.swing.JTextField textTanggalEnd;
    // End of variables declaration//GEN-END:variables

    public void internalFrameOpened(InternalFrameEvent e) {
    }

    public void internalFrameClosing(InternalFrameEvent e) {
    }

    public void internalFrameClosed(InternalFrameEvent e) {
        frameMain.getDesktopPane().selectFrame(true);
    }

    public void internalFrameIconified(InternalFrameEvent e) {
    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    public void internalFrameActivated(InternalFrameEvent e) {
        setAction();
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
        try {
            noPinjam = Integer.valueOf(tableView.getValueAt(tableView.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }



}
