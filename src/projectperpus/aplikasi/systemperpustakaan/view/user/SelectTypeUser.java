/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectTypeUser.java
 *
 * Created on Feb 13, 2011, 8:21:38 PM
 */

package ahza.aplikasi.systemperpustakaan.view.user;

import ahza.aplikasi.systemperpustakaan.controller.UserController;
import ahza.aplikasi.systemperpustakaan.entity.UserType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ahza
 */
public class SelectTypeUser extends javax.swing.JDialog implements ListSelectionListener {
    private int idType = -1;
    UserController controller;
    SelectTypeUserTableModel tableModel;
            
    /** Creates new form SelectTypeUser */
    public SelectTypeUser(java.awt.Frame parent, boolean modal, UserController controller) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
        tableType.getSelectionModel().addListSelectionListener(this);
        find();
        setButton();
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
        jLabel1 = new javax.swing.JLabel();
        textFind = new javax.swing.JTextField();
        buttonFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableType = new javax.swing.JTable();
        buttonSelect = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Type : ");

        buttonFind.setText("Find");

        tableType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tableType.setRowHeight(22);
        tableType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableType.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableType);

        buttonSelect.setText("Select");

        buttonCancel.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFind, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFind))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonSelect)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonCancel))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSelect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableType;
    private javax.swing.JTextField textFind;
    // End of variables declaration//GEN-END:variables

    public void valueChanged(ListSelectionEvent e) {
        try {
            idType = Integer.valueOf(tableType.getValueAt(tableType.getSelectedRow(), 0).toString());
        } catch (Exception ex) {
        }
    }

    private void setButton() {
        buttonCancel.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { dispose(); } });
        buttonSelect.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { 
            if(idType > -1) {controller.setSelectedType(idType); dispose();  }
        } });
        buttonFind.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { find();} });
    }

    public void find(){
        tableModel = new SelectTypeUserTableModel();
        tableModel.setList(controller.getModel().getListUserType(-1, textFind.getText()));
        tableType.setModel(tableModel);
        idType = -1;
    }

}

class SelectTypeUserTableModel extends AbstractTableModel{
    List<UserType> list;

    public SelectTypeUserTableModel() {
        list = new ArrayList<UserType>();
    }

    public SelectTypeUserTableModel(List<UserType> list) {
        this.list = list;
    }

    public void setList(List<UserType> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getNama();
            default: return null;
        }
    }

    String[] header = {"ID Type","Nama Type"};

    @Override
    public String getColumnName(int column) {
        return header[column];
    }


}
