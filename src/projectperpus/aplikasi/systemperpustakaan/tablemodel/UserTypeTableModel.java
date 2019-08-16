package projectperpus.aplikasi.systemperpustakaan.tablemodel;

import projectperpus.aplikasi.systemperpustakaan.entity.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTypeTableModel extends AbstractTableModel{
    List<UserType> list;

    public UserTypeTableModel() {
        list = new ArrayList<UserType>();
    }

    public UserTypeTableModel(List<UserType> list) {
        this.list = list;
    }

    public void setList(List<UserType> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getNama();
            case 2: return list.get(rowIndex).getPrivilege().substring(0, 63);
            default: return null;
        }
    }

    String[] header = {"ID Type","Nama","Privilege"};

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

}
