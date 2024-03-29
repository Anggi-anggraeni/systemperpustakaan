/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectBuku.java
 *
 * Created on Feb 9, 2011, 6:51:49 PM
 */

package ahza.aplikasi.systemperpustakaan.view.peminjaman;

import ahza.aplikasi.systemperpustakaan.controller.PeminjamanController;
import ahza.aplikasi.systemperpustakaan.entity.ViewAnggota;
import ahza.aplikasi.systemperpustakaan.model.AnggotaModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahza
 */
public class SelectAnggota extends javax.swing.JDialog implements ListSelectionListener{
    AnggotaModel model;
    SelectAnggotatableModel tableModel;
    PeminjamanController controller;
    int idAnggota = -1;

    /** Creates new form SelectBuku */
    public SelectAnggota(java.awt.Frame parent, boolean modal, PeminjamanController controller) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
        model = new AnggotaModel();
        find(textCari.getText());
        setAction();
        tableAnggota.getSelectionModel().addListSelectionListener(this); 
        
    }

public final void setAction(){
    buttonFind.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { find(textCari.getText()); } });
    buttonCancel.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { dispose(); } });
    buttonSelect.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { if(idAnggota > 0){controller.getSelectedAnggota(idAnggota);dispose();} } });
}
    
protected final void find(String nama){
    tableModel = new SelectAnggotatableModel(model.getListAnggota("", nama, "")); 
    tableAnggota.setModel(tableModel);
    tableAnggota.getColumnModel().getColumn(1).setPreferredWidth(120);
    tableAnggota.getColumnModel().getColumn(2).setPreferredWidth(150);
    tableAnggota.getColumnModel().getColumn(3).setPreferredWidth(150);
}


/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonCancel = new javax.swing.JButton();
        buttonSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAnggota = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        buttonFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonCancel.setText("Cancel");

        buttonSelect.setText("Select");

        tableAnggota.setAutoCreateRowSorter(true);
        tableAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAnggota.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableAnggota.setRowHeight(22);
        tableAnggota.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAnggota.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableAnggota);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cari Namal : ");

        buttonFind.setText("Find");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFind, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSelect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonFind;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAnggota;
    private javax.swing.JTextField textCari;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        try {
            idAnggota = Integer.valueOf(tableAnggota.getValueAt(tableAnggota.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }

}

class SelectAnggotatableModel extends AbstractTableModel{
    List<ViewAnggota> listAnggota;
    private String[] header={"ID Anggota","Nim","Nama","Jurusan"};

    public SelectAnggotatableModel(List<ViewAnggota> listAnggota) {
        this.listAnggota = listAnggota;
    }

    public int getRowCount() {
        return listAnggota.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listAnggota.get(rowIndex).getId();
            case 1: return listAnggota.get(rowIndex).getNim();
            case 2: return listAnggota.get(rowIndex).getNama();
            case 3: return listAnggota.get(rowIndex).getJurusan();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }


}
