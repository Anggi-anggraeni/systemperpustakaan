/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectJenisBuku.java
 *
 * Created on Feb 12, 2011, 10:56:38 AM
 */

package ahza.aplikasi.systemperpustakaan.view.buku;

import ahza.aplikasi.systemperpustakaan.controller.BukuController;
import ahza.aplikasi.systemperpustakaan.entity.Jenis;
import ahza.aplikasi.systemperpustakaan.model.BukuModel;
import ahza.aplikasi.systemperpustakaan.tablemodel.JenisTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ahza
 */
public class SelectJenisBuku extends javax.swing.JDialog implements ListSelectionListener {
    BukuController controller;
    private Integer idJenis = -1;
    /** Creates new form SelectJenisBuku */
    public SelectJenisBuku(java.awt.Frame parent, boolean modal, BukuController controller) {
        super(parent, modal);
        this.controller = controller;
        initComponents();
        tabelJenis.getSelectionModel().addListSelectionListener(this);
        setButton();
        findJenis();
    }

    private void setButton() {
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectJenis();
                dispose();
            }
        });

        buttonFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findJenis();
            }
        });
    }

    public final void findJenis(){
        List<Jenis> list =controller.getModel().getListJenis(-1, textFind.getText());
        JenisTableModel tableModel = new JenisTableModel(list);
        tabelJenis.setModel(tableModel);
        tabelJenis.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    public void selectJenis(){
        if(idJenis > -1){
            controller.setSelectedJenis(idJenis);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelJenis = new javax.swing.JTable();
        buttonSelect = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        textFind = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelJenis.setAutoCreateRowSorter(true);
        tabelJenis.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelJenis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelJenis.setRowHeight(22);
        tabelJenis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelJenis.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelJenis);

        buttonSelect.setText("Select");

        buttonCancel.setText("Cancel");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Jenis :");

        buttonFind.setText("Find");
        buttonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonSelect)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonCancel))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFind, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFind)
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSelect))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFindActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonFind;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelJenis;
    private javax.swing.JTextField textFind;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        try {
            idJenis = Integer.valueOf(tabelJenis.getValueAt(tabelJenis.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }



}
