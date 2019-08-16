package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.ViewBuku;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BukuTableModel extends AbstractTableModel {
    List<ViewBuku> listBuku;
    String[] header = {"ID Buku","Jenis","Kategori","Judul","Pengarang","Penerbit","ISBN","Tahun","Terpinjam","Tersedia","Jumlah"};

    public BukuTableModel() { listBuku = new ArrayList<ViewBuku>();
    }

    public void rowDataInserted(ViewBuku lb){
        listBuku.add(lb);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    public void setListBuku(List<ViewBuku> listBuku) {
        this.listBuku = listBuku;
    }

    public int getRowCount() {
        return listBuku.size();
    }

    public int getColumnCount() {
        return 11;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listBuku.get(rowIndex).getObject(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public int getRow(int id) {
        int i=0;
        for(i=0;i<listBuku.size();i++){
            if(listBuku.get(i).getId()== id){
                break;
            }
        }
        return i;
    }

}
