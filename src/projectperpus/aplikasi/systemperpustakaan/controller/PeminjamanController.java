package projectperpus.aplikasi.systemperpustakaan.controller;

import projectperpus.aplikasi.systemperpustakaan.component.PdfFilter;
import projectperpus.aplikasi.systemperpustakaan.entity.Anggota;
import projectperpus.aplikasi.systemperpustakaan.entity.Buku;
import projectperpus.aplikasi.systemperpustakaan.entity.DetailPinjam;
import projectperpus.aplikasi.systemperpustakaan.entity.ViewPinjam;
import projectperpus.aplikasi.systemperpustakaan.model.AnggotaModel;
import projectperpus.aplikasi.systemperpustakaan.model.BukuModel;
import projectperpus.aplikasi.systemperpustakaan.model.PeminjamanModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.DetailPinjamTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.PeminjamanTableModel;
import projectperpus.aplikasi.systemperpustakaan.utility.DateUtility;
import projectperpus.aplikasi.systemperpustakaan.utility.FilterUtility;
import projectperpus.aplikasi.systemperpustakaan.view.peminjaman.DialogPeminjamanDetail;
import projectperpus.aplikasi.systemperpustakaan.view.peminjaman.FramePeminjamanView;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

public class PeminjamanController {
    FramePeminjamanView framePeminjaman;
    DialogPeminjamanDetail pinjamDetail;
    PeminjamanModel model;
    DetailPinjamTableModel detailTableModel;
    DateUtility du = new DateUtility();

    public PeminjamanController() {
    }

    public PeminjamanController(FramePeminjamanView framePeminjaman, PeminjamanModel model) {
        this.framePeminjaman = framePeminjaman;
        this.model = model;
    }

    public FramePeminjamanView getFramePeminjaman() {
        return framePeminjaman;
    }

    public void setPinjamDetail(DialogPeminjamanDetail pinjamDetail) {
        this.pinjamDetail = pinjamDetail;
    }
    public void saveNewPeminjaman(){
        if(pinjamDetail.getTextIdAnggota().getText().equals("")){
            JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjam masih kosong");
        }else if(pinjamDetail.getTableDetail().getRowCount()==0){
            JOptionPane.showMessageDialog(pinjamDetail, "List buku yang akan dipinjam masih kosong");
        }else{
            int idAnggota = Integer.valueOf(pinjamDetail.getTextIdAnggota().getText());
            int userId = framePeminjaman.getFrameMain().getNoUser();
            List<DetailPinjam> list = pinjamDetail.getTableModel().getListDetailPinjam();
            if(model.insertPinjam(idAnggota, userId, list )){
                JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjaman sukses disimpan");
                pinjamDetail.dispose();
                findDataPeminjaman();
            }else{
                JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjaman gagal disimpan");
            }
        }
    }

    public void saveUpdatePeminjaman(){
        if(pinjamDetail.getTextIdAnggota().getText().equals("")){
            JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjam masih kosong");
        }else if(pinjamDetail.getTableDetail().getRowCount()==0){
            JOptionPane.showMessageDialog(pinjamDetail, "List buku yang akan dipinjam masih kosong");
        }else{
            int noPinjam = Integer.valueOf(pinjamDetail.getTextNoPinjam().getText());
            int idAnggota = Integer.valueOf(pinjamDetail.getTextIdAnggota().getText());
            int userId = framePeminjaman.getFrameMain().getNoUser();
            List<DetailPinjam> list = pinjamDetail.getTableModel().getListDetailPinjam();
            if(model.updatePinjam(noPinjam,idAnggota, userId, list )){
                JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjaman sukses diupdate");
                pinjamDetail.dispose();
                findDataPeminjaman();
            }else{
                JOptionPane.showMessageDialog(pinjamDetail, "Data Peminjaman gagal diupdate");
            }
        }
    }

    public void saveDeletePeminjaman(){
    //peminjaman tidak memerlukan method delete
    }

    public DetailPinjamTableModel getDetailTableModel() {
        return detailTableModel;
    }
    
    public void findDataPeminjaman(){
        int noPinjam = -1;
        if(!framePeminjaman.getTextNo().getText().equals("")){
            try {
                noPinjam= Integer.valueOf(framePeminjaman.getTextNo().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(framePeminjaman, "Nomor pinjam tidak valid");
                framePeminjaman.getTextNo().setText("");
                return;
            }
        }
        if(!du.isDateValid(framePeminjaman.getTextTanggalBegin().getText())){
            JOptionPane.showMessageDialog(framePeminjaman, "Awal tanggal peminjaman tidak valid");
            return;
        }
        if(!du.isDateValid(framePeminjaman.getTextTanggalEnd().getText())){
            JOptionPane.showMessageDialog(framePeminjaman, "Akhir tanggal peminjaman tidak valid");
            return;
        }
        framePeminjaman.setTableModel(new PeminjamanTableModel());
        framePeminjaman.getTableModel().setListPeminjaman(model.getListpPeminjaman(
                noPinjam,
                du.createDate(framePeminjaman.getTextTanggalBegin().getText()),
                du.createDate(framePeminjaman.getTextTanggalEnd().getText()),
                framePeminjaman.getTextNim().getText(),
                framePeminjaman.getTextNama().getText(),
                framePeminjaman.getOpt()));
        framePeminjaman.getTableView().setModel(framePeminjaman.getTableModel());
        framePeminjaman.setTableWidth();
        framePeminjaman.setNoPinjam(-1);
    }

    public void clear(){
        framePeminjaman.getTextNo().setText("");
        framePeminjaman.getTextNim().setText("");
        framePeminjaman.getTextNama().setText("");
        framePeminjaman.getTextTanggalBegin().setText(du.getBeginOfMonthDate().toString());
        framePeminjaman.getTextTanggalEnd().setText(du.getEndOfMonthDate().toString());
        framePeminjaman.getRadioAll().setSelected(true);
        framePeminjaman.setNoPinjam(-1);
        framePeminjaman.setOpt(-1);
    }

    public void showDataPeminjaman(int id){
        ViewPinjam vp = model.getPinjam(id);
        pinjamDetail.getTextNoPinjam().setText(vp.getNoPinjam()+"");
        pinjamDetail.getTextTanggalPinjam().setText(vp.getTanggal().toString());
        pinjamDetail.getTextIdAnggota().setText(vp.getIdAnggota()+"");
        pinjamDetail.getTextNim().setText(vp.getNim());
        pinjamDetail.getTextNama().setText(vp.getNama());
        pinjamDetail.getTextUser().setText(vp.getUser());
    }

    public void findDataDetail(int id){
        pinjamDetail.setTableModel(new DetailPinjamTableModel(model.getListDetailPinjam(id)));
        pinjamDetail.getTableDetail().setModel(pinjamDetail.getTableModel());
    }


    /*
     * ungsi untuk menampilkann data yang diselect pada masing text data
     * berdasarkan data pada table yang dipilih
     */
    public void showSelectedData(int r){
        pinjamDetail.getTextNoDetail().setText(pinjamDetail.getTableDetail().getValueAt(r, 0).toString());
        pinjamDetail.getTextIdBuku().setText(pinjamDetail.getTableDetail().getValueAt(r, 1).toString());
        pinjamDetail.getTextJudul().setText(pinjamDetail.getTableDetail().getValueAt(r, 2).toString());
        pinjamDetail.getTextTanggalKembali().setText(pinjamDetail.getTableDetail().getValueAt(r, 3).toString());
        pinjamDetail.getTextTerlambat().setText(pinjamDetail.getTableDetail().getValueAt(r, 4).toString());
        pinjamDetail.getTextDenda().setText(pinjamDetail.getTableDetail().getValueAt(r, 5).toString());
    }

    /*
     *  Fungsi untuk mengambil dan menampilkan buku yang dipilih dari frame selectBuku ke
     *  masing - masing text data di frame pinjam detail
     */
    public void getSelectedBuku(int id){
        Buku b = new BukuModel().getBuku(id);
        pinjamDetail.getTextIdBuku().setText(b.getId()+"");
        pinjamDetail.getTextJudul().setText(b.getJudul());
    }

    public void getSelectedAnggota(int id){
        Anggota a = new AnggotaModel().getAnggota(id);
        pinjamDetail.getTextIdAnggota().setText(a.getId()+"");
        pinjamDetail.getTextNim().setText(a.getNim());
        pinjamDetail.getTextNama().setText(a.getNama());
    }

    /*
     * Fungsi untuk meanbahkan buku yang dipih ke list buku pada table model table detail di frame pinjam detail
     *  namun sebelumnya diperiksa apakah jumlah buku pada list sudah memenuhi jumlah maksimum
     */
    public void addPinjamBuku(){
        if(pinjamDetail.getTextNim().getText().equals("")){
            JOptionPane.showMessageDialog(pinjamDetail, "Isi data peminjam dulu");
            return;
        }
        int jumlahPinjam = model.countPeminjamanNotCompleteByAnggota(pinjamDetail.getTextNim().getText());
        if(jumlahPinjam >= 3){
            JOptionPane.showMessageDialog(pinjamDetail, "Anggota dengan nama "+pinjamDetail.getTextNama().getText()
                    +"\n Masih punya 3 peminjaman yang belum dikembalikan \n"
                    + "Peminjaman baru tidak diperkenankan");
        }else if(pinjamDetail.getTableDetail().getRowCount() >= (3-jumlahPinjam)){
            JOptionPane.showMessageDialog(pinjamDetail, "Peminjaman dengan nomor ini sudah melampaui jumlah maksimum, \n Segera simpan transaksi peminjaman atau hapus buku yang lain");
        }else if(pinjamDetail.getTextIdBuku().getText().equals("")){
            JOptionPane.showMessageDialog(pinjamDetail, "No Buku masih kosong");       
       }else{
            DetailPinjam dp = new DetailPinjam();
            dp.setIdBuku(Integer.valueOf(pinjamDetail.getTextIdBuku().getText()));
            dp.setJudul(pinjamDetail.getTextJudul().getText());
            pinjamDetail.getTableModel().getListDetailPinjam().add(dp); 
            pinjamDetail.getTableModel().fireTableDataChanged();
            clearDataBuku();
        }
    }

    /*
     * Method untuk mengahapus text data detail pinjam
     */
    public void clearDataBuku(){
        pinjamDetail.getTextNoDetail().setText("");
        pinjamDetail.getTextIdBuku().setText("");
        pinjamDetail.getTextJudul().setText("");
        pinjamDetail.getTextTanggalKembali().setText("");
        pinjamDetail.getTextTerlambat().setText("");
        pinjamDetail.getTextDenda().setText("");
    }

    /*
     * Fungsi untuk meremove buku dari list table model table detail di frame pinjam detail
     *
     */
    public void removeBuku(){
        int r = pinjamDetail.getTableDetail().getSelectedRow();
        if(r > -1){
            if(pinjamDetail.getTableModel().getListDetailPinjam().get(r).getNoDetail() > 0){
                JOptionPane.showMessageDialog(pinjamDetail, "Buku ini telah ada dalam list peminjaman dan tidak bisa di remove");
            }else{
                pinjamDetail.getTableModel().getListDetailPinjam().remove(r);
                pinjamDetail.getTableModel().fireTableDataChanged();
            }
        }
    }

    /*
     * Method untuk memproses return buku dengan memberikan tanggal kembali dan pehnghitungan terlambat serta denda
     */
    public void returnBuku(){
        int terlambat;
        double dendaPerhari = 1000;
        int r = pinjamDetail.getTableDetail().getSelectedRow();
        if(r > -1){
            if(pinjamDetail.getTableModel().getListDetailPinjam().get(r).getNoDetail() <= 0){
                JOptionPane.showMessageDialog(pinjamDetail, "Buku ini belum ada dalam list peminjaman dan tidak bisa di lakukan proses return");
            }else if(pinjamDetail.getTableModel().getListDetailPinjam().get(r).getTanggalKembali() != null){
                JOptionPane.showMessageDialog(pinjamDetail, "Buku ini sudah dikembalikan dan tidak bisa di lakukan proses return ulang");
            }else{
                pinjamDetail.getTableModel().getListDetailPinjam().get(r).setTanggalKembali(du.getCurDate());
                terlambat = du.getDiffrentDate(du.getCurDate(), du.createDate(pinjamDetail.getTextTanggalPinjam().getText())) - 7;
                if(terlambat > 0){
                    pinjamDetail.getTableModel().getListDetailPinjam().get(r).setTerlambat(terlambat);
                    pinjamDetail.getTableModel().getListDetailPinjam().get(r).setDenda(dendaPerhari* terlambat);
                }
                pinjamDetail.getTableModel().fireTableDataChanged();
            }
        }
    }

    public void report(int opt) {
        InputStream stream = getClass().getResourceAsStream("report/PeminjamanReport.jasper");
        int noPinjam = -1;
        if(!framePeminjaman.getTextNo().getText().equals("")){
            try {
                noPinjam= Integer.valueOf(framePeminjaman.getTextNo().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(framePeminjaman, "This field must be filled with number");
                framePeminjaman.getTextNo().setText("");
                noPinjam = 0;
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nopinjam", noPinjam);
        map.put("tanggalpinjamawal", framePeminjaman.getTextTanggalBegin().getText());
        map.put("tanggalpinjamakhir", framePeminjaman.getTextTanggalEnd().getText());
        map.put("nim", framePeminjaman.getTextNim().getText());
        map.put("nama", framePeminjaman.getTextNama().getText());
        map.put("opt", framePeminjaman.getOpt());
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(stream, map, model.getConnection());
            switch(opt){
                case 0: JasperViewer.viewReport(jasperPrint, false);break;
                case 1:  JasperPrintManager.printReport(jasperPrint, true);break;
                case 2:
                            JFileChooser fc = new JFileChooser();
                            fc.setFileFilter(new PdfFilter());
                            int returnValue = fc.showSaveDialog(framePeminjaman);
                            if(returnValue == JFileChooser.APPROVE_OPTION){
                                File f = fc.getSelectedFile();
                                String path = f.getPath();
                                String ext = FilterUtility.getExtension(f);
                                if(ext != "pdf" ) path += ".pdf";
                                JasperPrintManager.printReportToPdfFile(jasperPrint, path);
                                JOptionPane.showMessageDialog(framePeminjaman, "Downlaod data berhasil \n lokasi file anda: "+path);
                            }
                            break;
            }

        } catch (JRException ex) {System.out.println(ex.getMessage());}
        catch(Exception e){}
    }
}
