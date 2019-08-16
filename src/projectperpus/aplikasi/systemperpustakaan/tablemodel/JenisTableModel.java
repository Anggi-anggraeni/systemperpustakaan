package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.Jenis;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class JenisTableModel extends AbstractTableModel{
    List<Jenis> listJenis;

    public JenisTableModel() {
        listJenis = new ArrayList<Jenis>();
    }

    public JenisTableModel(List<Jenis> listJenis) {
        this.listJenis = listJenis;
    }

    public void setListkategories(List<Jenis> listJenis) {
        this.listJenis = listJenis;
    }

    public List<Jenis> getListkategories() {
        return listJenis;
    }

    public int getRowCount() {
        return  listJenis.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listJenis.get(rowIndex).getObject(columnIndex);
    }

    String[] header = {"ID Jenis","Nama Jenis"};
    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
