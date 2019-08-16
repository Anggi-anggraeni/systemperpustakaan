package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.Jurusan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class JurusanTableModel extends AbstractTableModel{
    List<Jurusan> list;

    public JurusanTableModel() {
        list = new ArrayList<Jurusan>();
    }

    public JurusanTableModel(List<Jurusan> list) {
        this.list = list;
    }

    public void setList(List<Jurusan> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex).getObject(columnIndex);
    }

    String[] header = {"ID Jurusan","Nama Jurusan"};

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
