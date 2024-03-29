
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.TableView.TableRow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditableColorColumn.java
 *
 * Created on Feb 3, 2011, 12:23:34 PM
 */

/**
 *
 * @author ahza
 */
public class EditableColorColumn extends javax.swing.JFrame {
    String priv="111100001111";
    /** Creates new form EditableColorColumn */
    public EditableColorColumn() {
        initComponents();
        System.out.println("Value: "+priv.substring(1,2));
        
        tabelView.setModel(new ColorTableModel());
        tabelView.setValueAt(false, 1, 1);
        if(Boolean.valueOf(tabelView.getValueAt(1, 1).toString()))System.out.println("Benar");
        buttonCalc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("notepad");
                } catch (IOException ex) {
                }
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelView = new javax.swing.JTable();
        buttonCalc = new javax.swing.JButton();
        textTest = new javax.swing.JTextField();
        buttonFile = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelView.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelView);

        buttonCalc.setText("Calculator");

        textTest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTestKeyPressed(evt);
            }
        });

        buttonFile.setText("File");
        buttonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textTest, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCalc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCalc)
                    .addComponent(textTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFile))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelViewMouseClicked
        int r = tabelView.getSelectedRow();
        JOptionPane.showMessageDialog(rootPane, "Privilege: "+tabelView.getValueAt(r, 0).toString()+"  Value: "+tabelView.getValueAt(r, 1).toString());
    }//GEN-LAST:event_tabelViewMouseClicked

    private void textTestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTestKeyPressed
        JOptionPane.showMessageDialog(rootPane, evt.getKeyCode());
    }//GEN-LAST:event_textTestKeyPressed

    private void buttonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFileActionPerformed
        JFileChooser fc = new JFileChooser();
//        fc.setVisible(true);
//        fc.showOpenDialog(this);
        
        fc.showSaveDialog(this);
        try {
            textTest.setText(fc.getSelectedFile().getName());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonFileActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new EditableColorColumn().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalc;
    private javax.swing.JButton buttonFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelView;
    private javax.swing.JTextField textTest;
    // End of variables declaration//GEN-END:variables

}

class ColorTableModel extends AbstractTableModel {

  Object rowData[][] = { { "Buku", true }, { "Anggota", true }, { "Peminjaman", true },
      { "Report", true}, { "Create", true }, { "Update", true }, { "Delete", true} };

  String columnNames[] = { "Privileges Name", "Value" };

  public int getColumnCount() {
    return columnNames.length;
  }

  public String getColumnName(int column) {
    return columnNames[column];
  }

  public int getRowCount() {
    return rowData.length;
  }

  public Object getValueAt(int row, int column) {
    return rowData[row][column];
  }

  public Class getColumnClass(int column) {
    return (getValueAt(0, column).getClass());
  }

  public void setValueAt(Object value, int row, int column) {
    rowData[row][column] = value;
  }

  public boolean isCellEditable(int row, int column) {
    return (column != 0);
  }
}