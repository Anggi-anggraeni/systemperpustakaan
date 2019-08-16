package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.Penerbit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PenerbitTableModel extends AbstractTableModel {
    List<Penerbit> listPenerbit;

    public PenerbitTableModel() {
        listPenerbit = new ArrayList<Penerbit>();
    }

    public void setListPenerbit(List<Penerbit> listPenerbit) {
        this.listPenerbit = listPenerbit;
    }

    public PenerbitTableModel(List<Penerbit> listPenerbit) {
        this.listPenerbit = listPenerbit;
    }

    public int getRowCount() {
        return  listPenerbit.size();
    }

    public int getColumnCount() {
        return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return listPenerbit.get(rowIndex).getObject(columnIndex);
    }

    String[] header = {"ID Penerbit","Nama Penerbit","Alamat","Kota","Email","Telepon"};

    @Override
    public String getColumnName(int column) {
        return header[column];
    }


}
