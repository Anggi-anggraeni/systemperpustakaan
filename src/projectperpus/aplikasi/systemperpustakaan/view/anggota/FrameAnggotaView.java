/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameAnggotaView.java
 *
 * Created on Feb 3, 2011, 6:20:38 AM
 */

package ahza.aplikasi.systemperpustakaan.view.anggota;

import ahza.aplikasi.systemperpustakaan.controller.AnggotaController;
import ahza.aplikasi.systemperpustakaan.model.AnggotaModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.AnggotaTableModel;
import ahza.aplikasi.systemperpustakaan.utility.ReportUtility;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
public class FrameAnggotaView extends javax.swing.JInternalFrame implements InternalFrameListener, ListSelectionListener{
    public FrameMain frameMain;
    AnggotaModel model;
    AnggotaController controller;
    AnggotaTableModel tableModel;
    DialogAnggotaDetail anggotaDetail;
    int anggotaId = -1;

    /** Creates new form FrameAnggotaView */
    public FrameAnggotaView(FrameMain frameMain) {
        this.frameMain = frameMain;
        model = new AnggotaModel();
        controller = new AnggotaController(this, model);
        initComponents();
        tableView.setModel(new AnggotaTableModel());
        tableView.getSelectionModel().addListSelectionListener(this);
        addInternalFrameListener(this);     
        setTableView();
    }

    public FrameMain getFrameMain() {
        return frameMain;
    }
    
    public final void setTableView() {
        int[] width={80,150,250,200,150,100,300,150,150,120,120,};
        for(int i=0;i<11;i++){
            tableView.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }
        centerCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        rightCellRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tableView.getColumnModel().getColumn(5).setCellRenderer(centerCellRenderer);
        tableView.getColumnModel().getColumn(9).setCellRenderer(centerCellRenderer);
        tableView.getColumnModel().getColumn(10).setCellRenderer(centerCellRenderer);
    }

    public int getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(int anggotaId) {
        this.anggotaId = anggotaId;
    }

    public JComboBox getComboJurusan() {
        return comboJurusan;
    }

    public JTextField getTextNama() {
        return textNama;
    }

    public JTextField getTextNim() {
        return textNim;
    }

    public JTable getTableView() {
        return tableView;
    }

    public AnggotaTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(AnggotaTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setAction(){
        frameMain.getMenuFileSearch().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                if(isSelected()) controller.findListAnggota();
            }
        });

        frameMain.getMenuFileRefresh().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected()){controller.clear();controller.findListAnggota();}
            }
        });

        frameMain.getMenuFileDetail().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(anggotaId > -1 && isSelected()){
                     anggotaDetail = new DialogAnggotaDetail(frameMain, true, controller, anggotaId);
                    anggotaDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileAddNew().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isSelected()){
                     anggotaDetail = new DialogAnggotaDetail(frameMain, true, controller);
                    anggotaDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileDelete().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(anggotaId > -1 && isSelected()){
                    controller.saveDeleteAnggota(anggotaId);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        textNim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboJurusan = new javax.swing.JComboBox();
        myLabel1 = new ahza.aplikasi.systemperpustakaan.component.MyLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daftar Anggota Perpustakaan");

        tableView.setAutoCreateRowSorter(true);
        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NIM : ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nama : ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Jurusan : ");

        comboJurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        myLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myLabel1.setIconReflec(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/medium 130.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Daftar Anggota Perpustakaan");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Anggota Perpustakaan yang telah teregister dan masih aktif");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        comboJurusan.setModel(new DefaultComboBoxModel(model.getVectorJurusan()));
        comboJurusan.setSelectedIndex(0);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboJurusan;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private ahza.aplikasi.systemperpustakaan.component.MyLabel myLabel1;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNim;
    // End of variables declaration//GEN-END:variables
    DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();

    public void internalFrameOpened(InternalFrameEvent e) { }

    public void internalFrameClosing(InternalFrameEvent e) { }

    public void internalFrameClosed(InternalFrameEvent e) {frameMain.getDesktopPane().selectFrame(true); }

    public void internalFrameIconified(InternalFrameEvent e) { }

    public void internalFrameDeiconified(InternalFrameEvent e) { }

    public void internalFrameActivated(InternalFrameEvent e) {setAction(); }

    public void internalFrameDeactivated(InternalFrameEvent e) { }

    public void valueChanged(ListSelectionEvent e) {
        try {
            anggotaId = Integer.valueOf(tableView.getValueAt(tableView.getSelectedRow(), 0).toString());
        } catch (Exception ex) {}
    }



}
