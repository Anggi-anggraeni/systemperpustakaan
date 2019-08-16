package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.ViewUser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class UserTableModel extends AbstractTableModel{
    List<ViewUser> list;

    public UserTableModel() {
        list = new ArrayList<ViewUser>();
    }

    public UserTableModel(List<ViewUser> list) {
        this.list = list;
    }

    public void setList(List<ViewUser> list) {
        this.list = list;
    }

    public int getRowCount() {
        return  list.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return list.get(rowIndex).getObject(columnIndex);
    }

    String[] header={"No User","User ID","Password","Nama","Type"};

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
