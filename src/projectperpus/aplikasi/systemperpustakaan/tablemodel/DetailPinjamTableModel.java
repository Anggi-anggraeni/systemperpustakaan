package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.DetailPinjam;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DetailPinjamTableModel extends AbstractTableModel {
    List<DetailPinjam> listDetailPinjam;
    String[] header = {"No Detail","ID Buku","Judul","Tanggal Kembali","Terlambat","Denda"};
    
    public DetailPinjamTableModel() {
        listDetailPinjam = new ArrayList<DetailPinjam>();
    }

    public List<DetailPinjam> getListDetailPinjam() {
        return listDetailPinjam;
    }

    public DetailPinjamTableModel(List<DetailPinjam> listDetailPinjam) {
        this.listDetailPinjam = listDetailPinjam;
    }

    public void setListDetailPinjam(List<DetailPinjam> listDetailPinjam) {
        this.listDetailPinjam = listDetailPinjam;
    }
    
    public int getRowCount() {
        return listDetailPinjam.size();
    }

    public int getColumnCount() {
        return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listDetailPinjam.get(rowIndex).getObject(columnIndex+1);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    
}
