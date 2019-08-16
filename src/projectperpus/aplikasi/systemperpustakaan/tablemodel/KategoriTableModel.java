package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.Kategori;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KategoriTableModel extends AbstractTableModel{
    List<Kategori> listkategories;

    public KategoriTableModel() {
        listkategories = new ArrayList<Kategori>();
    }

    public KategoriTableModel(List<Kategori> listkategori) {
        this.listkategories = listkategori;
    }

    public void setListkategories(List<Kategori> listkategori) {
        this.listkategories = listkategori;
    }

    public List<Kategori> getListkategories() {
        return listkategories;
    }

    public int getRowCount() {
        return  listkategories.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listkategories.get(rowIndex).getObject(columnIndex);
    }

    String[] header = {"ID Kategori","Nama Kategori"};
    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
