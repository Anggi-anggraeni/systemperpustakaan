package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.ViewAnggota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AnggotaTableModel extends AbstractTableModel{
    List<ViewAnggota> listAnggota;
    String[] header = {"Id Anggota","NIM","Nama","Jurusan","Tempat Lahir","Tanggal Lahir",
                                  "Alamat","Email","Telepon","Tanggal Register","Akhir Register"};

    public AnggotaTableModel() {
        listAnggota = new ArrayList<ViewAnggota>();
    }

    public AnggotaTableModel(List<ViewAnggota> listAnggota) {
        this.listAnggota = listAnggota;
    }

    public void setListAnggota(List<ViewAnggota> listAnggota) {
        this.listAnggota = listAnggota;
    }
    
    public int getRowCount() {
        return listAnggota.size();
    }

    public int getColumnCount() {
        return 11;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listAnggota.get(rowIndex).getObject(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
