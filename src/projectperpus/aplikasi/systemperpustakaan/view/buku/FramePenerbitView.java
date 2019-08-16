/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameUserView.java
 *
 * Created on Feb 3, 2011, 12:04:53 PM
 */

package ahza.aplikasi.systemperpustakaan.view.buku;

import ahza.aplikasi.systemperpustakaan.controller.BukuController;
import ahza.aplikasi.systemperpustakaan.model.BukuModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.PenerbitTableModel;
import ahza.aplikasi.systemperpustakaan.view.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class FramePenerbitView extends javax.swing.JInternalFrame implements InternalFrameListener, ListSelectionListener {
    private FrameMain frameMain;
    BukuModel model;
    BukuController controller;
    PenerbitTableModel tableModel;
    DialogPenerbitDetail penerbitDetail;
    int idPenerbit= -1;

    /** Creates new form FrameUserView */
    public FramePenerbitView(FrameMain frameMain) {
        this.frameMain = frameMain;
        model = new BukuModel();
        controller = new BukuController(this, model);
        initComponents();
        addInternalFrameListener(this);
        tablePenerbit.getSelectionModel().addListSelectionListener(this);
        tablePenerbit.setModel(new PenerbitTableModel());
        setTableWidth();
    }

    public void setIdPenerbit(int idPenerbit) {
        this.idPenerbit = idPenerbit;
    }

    public int getIdPenerbit() {
        return idPenerbit;
    }
    
    public JTable getTablePenerbit() {
        return tablePenerbit;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JTextField getTextIdPenerbit() {
        return textIdPenerbit;
    }

    public JTextField getTextKota() {
        return textKota;
    }

    public JTextField getTextnama() {
        return textnama;
    }

    public PenerbitTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(PenerbitTableModel tableModel) {
        this.tableModel = tableModel;
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
        tablePenerbit = new javax.swing.JTable();
        myLabel1 = new ahza.aplikasi.systemperpustakaan.component.MyLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textnama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textKota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        textIdPenerbit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Daftar Penerbit Buku");

        tablePenerbit.setAutoCreateRowSorter(true);
        tablePenerbit.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerbit.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablePenerbit.setRowHeight(22);
        tablePenerbit.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablePenerbit.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePenerbit);

        myLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myLabel1.setIconReflec(new javax.swing.ImageIcon(getClass().getResource("/ahza/aplikasi/systemperpustakaan/image/Medium 020.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Daftar Penerbit Buku Perpustakaan");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Daftar Penerbit Koleksi Buku Perpustakaan");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama Penerbit : ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Kota Penerbit : ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Email : ");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Penerbit : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIdPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textEmail))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textnama, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textKota))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textIdPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(textnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void setAction(){
        frameMain.getMenuFileSearch().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()) controller.findListPenerbit();    }
        });

        frameMain.getMenuFileRefresh().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   controller.refreshListPenerbit();   }
        });

        frameMain.getMenuFileDetail().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(idPenerbit > -1 && isSelected()){
                    penerbitDetail = new DialogPenerbitDetail(frameMain, true, controller, idPenerbit);
                    penerbitDetail.setVisible(true);
                }
            }
        });

        frameMain.getMenuFileAddNew().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(isSelected()) new DialogPenerbitDetail(frameMain, true, controller).setVisible(true);     }
        });

        frameMain.getMenuFileDelete().setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { if(idPenerbit > -1 && isSelected()) controller.saveDeletePenerbit();    }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private ahza.aplikasi.systemperpustakaan.component.MyLabel myLabel1;
    private javax.swing.JTable tablePenerbit;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textIdPenerbit;
    private javax.swing.JTextField textKota;
    private javax.swing.JTextField textnama;
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
            idPenerbit = Integer.valueOf(tablePenerbit.getValueAt(tablePenerbit.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }

    public final void setTableWidth() {
        int[] width = {100,200,300,150,150,100};
        for (int i = 0; i < 6; i++) {
            tablePenerbit.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }
    }

}
