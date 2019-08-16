package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.ViewPeminjaman;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PeminjamanTableModel extends AbstractTableModel{
    List<ViewPeminjaman> listPeminjaman;
    String[] header = {"No Pinjam","Tanggal","NIM","Nama","No Detail","Judul Buku","Tanggal Kembali","Status","User"};

    public PeminjamanTableModel() {
        listPeminjaman = new ArrayList<ViewPeminjaman>();
    }

    public PeminjamanTableModel(List<ViewPeminjaman> listpPeminjaman) {
        this.listPeminjaman = listpPeminjaman;
    }

    public void setListPeminjaman(List<ViewPeminjaman> listPeminjaman) {
        this.listPeminjaman = listPeminjaman;
    }

    public int getRowCount() {
        return listPeminjaman.size();
    }

    public int getColumnCount() {
        return 9;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listPeminjaman.get(rowIndex).getObject(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
