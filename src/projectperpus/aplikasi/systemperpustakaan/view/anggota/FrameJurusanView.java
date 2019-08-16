/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameJurusanView.java
 *
 * Created on Feb 3, 2011, 7:30:05 PM
 */

package ahza.aplikasi.systemperpustakaan.view.anggota;

import ahza.aplikasi.systemperpustakaan.controller.AnggotaController;
import ahza.aplikasi.systemperpustakaan.entity.Jurusan;
import ahza.aplikasi.systemperpustakaan.model.AnggotaModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.JurusanTableModel;
import ahza.aplikasi.systemperpustakaan.utility.UserUtility;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class FrameJurusanView extends javax.swing.JInternalFrame implements InternalFrameListener, ListSelectionListener {
    FrameMain frameMain;
    AnggotaController controller;
    AnggotaModel model;
    int idJurusan = -1;
    JurusanTableModel tablemodel;

    /** Creates new form FrameJurusanView */
    public FrameJurusanView(FrameMain frameMain) {
        this.frameMain = frameMain;
        model = new AnggotaModel();
        controller = new AnggotaController(this, model);
        initComponents();
        addInternalFrameListener(this);
        tableJurusan.getSelectionModel().addListSelectionListener(this);
        tablemodel = new JurusanTableModel(new ArrayList<Jurusan>());
        tableJurusan.setModel(tablemodel);
        tableJurusan.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    public void setIdJurusan(int idJurusan) {
        this.idJurusan = idJurusan;
    }

    public void setTablemodel(JurusanTableModel tablemodel) {
        this.tablemodel = tablemodel;
    }

    public JurusanTableModel getTablemodel() {
        return tablemodel;
    }

    public void setAction(){
        frameMain.getMenuFileSearch().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()) controller.findListJurusan();   }
        });

        frameMain.getMenuFileRefresh().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { controller.refresh(); }
        });

        frameMain.getMenuFileDetail().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idJurusan > -1 && isSelected()){
                    DialogJurusanDetail jurusanDetail = new DialogJurusanDetail(frameMain, true, controller, idJurusan);
                    jurusanDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileAddNew().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                if(isSelected()){
                    DialogJurusanDetail jurusanDetail = new DialogJurusanDetail(frameMain, true, controller);
                    jurusanDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileDelete().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { controller.saveDeleteJurusan();   }
        });

    }

    public int getIdJurusan() {
        return idJurusan;
    }

    public JTable getTableJurusan() {
        return tableJurusan;
    }

    public JTextField getTextIdJurusan() {
        return textIdJurusan;
    }

    public JTextField getTextNamaJurusan() {
        return textNamaJurusan;
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
        tableJurusan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        myLabel1 = new ahza.aplikasi.systemperpustakaan.component.MyLabel();
        jLabel5 = new javax.swing.JLabel();
        textIdJurusan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textNamaJurusan = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Daftar Jurusan Anggota");

        tableJurusan.setAutoCreateRowSorter(true);
        tableJurusan.setModel(new javax.swing.table.DefaultTableModel(
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
        tableJurusan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableJurusan.setRowHeight(22);
        tableJurusan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableJurusan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableJurusan);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nama Jurusan : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Daftar");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Datar Jurusan");

        myLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myLabel1.setIconReflec(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Medium 161.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Id Jurusan : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Jurusan Anggota");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText(" Anggota Perpustakaan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNamaJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIdJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(textIdJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textNamaJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private ahza.aplikasi.systemperpustakaan.component.MyLabel myLabel1;
    private javax.swing.JTable tableJurusan;
    private javax.swing.JTextField textIdJurusan;
    private javax.swing.JTextField textNamaJurusan;
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
            idJurusan = Integer.valueOf(tableJurusan.getValueAt(tableJurusan.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }



}