package projectperpus.aplikasi.systemperpustakaan.controller;

import projectperpus.aplikasi.systemperpustakaan.component.PdfFilter;
import projectperpus.aplikasi.systemperpustakaan.entity.Anggota;
import projectperpus.aplikasi.systemperpustakaan.entity.Jurusan;
import projectperpus.aplikasi.systemperpustakaan.model.AnggotaModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.AnggotaTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.JurusanTableModel;
import projectperpus.aplikasi.systemperpustakaan.utility.DateUtility;
import projectperpus.aplikasi.systemperpustakaan.utility.FilterUtility;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.DialogAnggotaDetail;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.DialogJurusanDetail;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.FrameAnggotaView;
import projectperpus.aplikasi.systemperpustakaan.view.anggota.FrameJurusanView;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

public class AnggotaController {
    FrameAnggotaView anggotaView;
    DialogAnggotaDetail anggotaDetail;
    Anggota anggota;
    DateUtility du = new DateUtility();
    FrameJurusanView jurusanView;
    AnggotaModel model;
    DialogJurusanDetail jurusanDetail;

    public AnggotaController() {
    }

    public AnggotaController(FrameAnggotaView anggotaView, AnggotaModel model) {
        this.anggotaView = anggotaView;
        this.model = model;
    }

    public AnggotaController(FrameJurusanView jurusanView, AnggotaModel model) {
        this.jurusanView = jurusanView;
        this.model = model;
    }

    public AnggotaModel getModel() {
        return model;
    }

    public void setAnggotaDetail(DialogAnggotaDetail anggotaDetail) {
        this.anggotaDetail = anggotaDetail;
    }

    public FrameAnggotaView getAnggotaView() {
        return anggotaView;
    }

    public DialogAnggotaDetail getAnggotaDetail() {
        return anggotaDetail;
    }
  
    public void findListAnggota(){
        anggotaView.setTableModel(new AnggotaTableModel());
        anggotaView.getTableModel().setListAnggota(model.getListAnggota(
                anggotaView.getTextNim().getText(),
                anggotaView.getTextNama().getText(),
                anggotaView.getComboJurusan().getSelectedItem().toString()));
        anggotaView.getTableView().setModel(anggotaView.getTableModel());
        anggotaView.setTableView();
        anggotaView.setAnggotaId(-1);
    }

    public void clear(){
        anggotaView.getTextNim().setText("");
        anggotaView.getTextNama().setText("");
        anggotaView.getComboJurusan().setSelectedIndex(0);
    }
    
    public Anggota createAnggota(){
        anggota = new Anggota(
                0, anggotaDetail.getTextNim().getText(),
                Integer.valueOf(anggotaDetail.getTextIdJurusan().getText()),
                anggotaDetail.getTextNama().getText(),
                anggotaDetail.getTextTempatLahir().getText(),
                du.createDate(anggotaDetail.getTextTanggalLahir().getText()),
                anggotaDetail.getTextAlamat().getText(),
                anggotaDetail.getTextEmail().getText(),
                anggotaDetail.getTextTelepon().getText(),
                du.createDate(anggotaDetail.getTextTanggalRegister().getText()),
                du.createDate(anggotaDetail.getTextAkhirRegister().getText()));
        return anggota;
    }

    public void saveNewAnggota() {
        if(anggotaDetail.getTextNim().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Nim Masih Kosong");
        }else if (anggotaDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Nama Masih Kosong");
        }else if(anggotaDetail.getTextTempatLahir().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tempat Lahir Masih Kosong");
        }else if(anggotaDetail.getTextTanggalLahir().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Lahir Masih Kosong");
        }else  if(!du.isDateValid(anggotaDetail.getTextTanggalLahir().getText())){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Lahir tidak valid");
        }else if(anggotaDetail.getTextAlamat().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Alamat Masih Kosong");
        }else if(anggotaDetail.getTextEmail().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Email Masih Kosong");
        }else if(anggotaDetail.getTextTelepon().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Telepon Masih Kosong");
        }else if(anggotaDetail.getTextTanggalRegister().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Register masih Kosong Masih Kosong");
        }else if(anggotaDetail.getTextAkhirRegister().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Akhir Register Masih Kosong");
        }else{
            if(model.insertAnggota(createAnggota())){
                JOptionPane.showMessageDialog(anggotaView, "Simpan Data anggota sukses");
                findListAnggota();
                anggotaDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(anggotaView, "Simpan Data anggota gagal");
            }
        }
    }

    public void saveUpdateAnggota() {
        if(anggotaDetail.getTextNim().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Nim Masih Kosong");
        }else if (anggotaDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Nama Masih Kosong");
        }else if(anggotaDetail.getTextTempatLahir().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tempat Lahir Masih Kosong");
        }else if(anggotaDetail.getTextTanggalLahir().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Lahir Masih Kosong");
        }else  if(!du.isDateValid(anggotaDetail.getTextTanggalLahir().getText())){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Lahir tidak valid");
        }else if(anggotaDetail.getTextAlamat().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Alamat Masih Kosong");
        }else if(anggotaDetail.getTextEmail().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Email Masih Kosong");
        }else if(anggotaDetail.getTextTelepon().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Telepon Masih Kosong");
        }else if(anggotaDetail.getTextTanggalRegister().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Tanggal Register masih Kosong Masih Kosong");
        }else if(anggotaDetail.getTextAkhirRegister().getText().equals("")){
            JOptionPane.showMessageDialog(anggotaView, "Akhir Register Masih Kosong");
        }else{
            anggota = createAnggota();
            anggota.setId(Integer.valueOf(anggotaDetail.getTextId().getText()));
            if(model.updateAnggota(anggota)){
                JOptionPane.showMessageDialog(anggotaView, "Update Data anggota sukses");
                findListAnggota();
                anggotaDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(anggotaView, "Update Data anggota gagal");
            }
        }
    }

    public void saveDeleteAnggota(int id) {
        if(JOptionPane.showConfirmDialog(anggotaView, "Apakah anda yakin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
                if(model.deleteAnggota(id)){
                    JOptionPane.showMessageDialog(anggotaView, "Delete data Anggota sukses");
                    findListAnggota();
                }else{
                    JOptionPane.showMessageDialog(anggotaView, "Delete data Anggota gagal");
                }
        }
    }

    public void showDetailAnggota(int id) {
        try {
            anggota = model.getAnggota(id);
            anggotaDetail.getTextId().setText(anggota.getId()+"");
            anggotaDetail.getTextNim().setText(anggota.getNim());
            setSelectedJurusan(anggota.getJurusanId());
            anggotaDetail.getTextNama().setText(anggota.getNama());
            anggotaDetail.getTextTempatLahir().setText(anggota.getKotaLahir());
            anggotaDetail.getTextTanggalLahir().setText(anggota.getTanggalLahir().toString());
            anggotaDetail.getTextAlamat().setText(anggota.getAlamat());
            anggotaDetail.getTextEmail().setText(anggota.getEmail());
            anggotaDetail.getTextTelepon().setText(anggota.getTelepon());
            anggotaDetail.getTextTanggalRegister().setText(anggota.getTanggalReg().toString());
            anggotaDetail.getTextAkhirRegister().setText(anggota.getAkhirReg().toString());
        } catch (Exception e) {
        }
    }

    public void findListJurusan() {
        int idJurusan = -1;
        if(!jurusanView.getTextIdJurusan().getText().equals("")){
            try {
                idJurusan = Integer.valueOf(jurusanView.getTextIdJurusan().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jurusanView, "Field ini harus diisi dengan angka");
                 jurusanView.getTextIdJurusan().setText("");
                 idJurusan = 0;
            }
        }

        jurusanView.setTablemodel(new JurusanTableModel());
        jurusanView.getTablemodel().setList(model.getListJurusan(idJurusan, jurusanView.getTextNamaJurusan().getText()));
        jurusanView.getTableJurusan().setModel(jurusanView.getTablemodel());
        jurusanView.getTableJurusan().getColumnModel().getColumn(1).setPreferredWidth(200);
        jurusanView.setIdJurusan(-1);
    }

    public void refresh() {
        jurusanView.getTextIdJurusan().setText("");
        jurusanView.getTextNamaJurusan().setText("");

        findListJurusan();
    }

    public void saveDeleteJurusan() {
        if(JOptionPane.showConfirmDialog(jurusanView, "Apakah anda yakin akan menghapus jurusan ini?","Hapus data jurusan",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deleteJurusan(jurusanView.getIdJurusan())){
                JOptionPane.showMessageDialog(jurusanView, "Delete jurusan sukses");
                findListJurusan();
            }else{
                JOptionPane.showMessageDialog(jurusanView, "Delete jurusan gagal");
            }
        }
    }

    public FrameJurusanView getJurusanView() {
        return jurusanView;
    }

    public void setJurusanDetail(DialogJurusanDetail jurusanDetail) {
        this.jurusanDetail = jurusanDetail;
    }

    public void showDetailJurusan(int id) {
        Jurusan jurusan = model.getJurusan(id);
        jurusanDetail.getTextNo().setText(jurusan.getId()+"");
        jurusanDetail.getTextNama().setText(jurusan.getNamaJurusan());
    }

    public void saveNewJurusan() {
        if(jurusanDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(jurusanView, "Nama Jurusan masih kosong");
            jurusanDetail.getTextNama().requestFocus();
        }else{
            if(model.insertJurusan(jurusanDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(jurusanDetail, "Jurusan baru sukses disimpan");
                findListJurusan();
                jurusanDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(jurusanDetail, "Jurusan baru gagal disimpan");
            }
        }
    }

    public void saveUpdateJurusan() {
        if(jurusanDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(jurusanView, "Nama Jurusan masih kosong");
            jurusanDetail.getTextNama().requestFocus();
        }else{
            if(model.updateJurusan(jurusanView.getIdJurusan(),jurusanDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(jurusanDetail, "Data jurusan sukses diupdate");
                findListJurusan();
                jurusanDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(jurusanDetail, "Data jurusan gagal diupdate");
            }
        }
    }

    public void setSelectedJurusan(int id) {
        Jurusan jurusan = model.getJurusan(id);
        anggotaDetail.getTextIdJurusan().setText(jurusan.getId()+"");
        anggotaDetail.getTextNamaJurusan().setText(jurusan.getNamaJurusan());
    }

    public void report(int opt){ 
        InputStream stream = getClass().getResourceAsStream("report/AnggotaReport.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nim", anggotaView.getTextNim().getText());
        map.put("nama", anggotaView.getTextNama().getText());
        map.put("jurusan", anggotaView.getComboJurusan().getSelectedItem().toString());
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(stream, map, model.getConnection());
            switch(opt){
                case 0: JasperViewer.viewReport(jasperPrint, false);break;
                case 1:  JasperPrintManager.printReport(jasperPrint, true);break;
                case 2:
                            JFileChooser fc = new JFileChooser();
                            fc.setFileFilter(new PdfFilter());
                            int returnValue = fc.showSaveDialog(anggotaView);
                            if(returnValue == JFileChooser.APPROVE_OPTION){
                                File f = fc.getSelectedFile();
                                String path = f.getPath();
                                String ext = FilterUtility.getExtension(f);
                                if(ext != "pdf" ) path += ".pdf";
                                JasperPrintManager.printReportToPdfFile(jasperPrint, path);
                                JOptionPane.showMessageDialog(anggotaView, "Downlaod data berhasil \n lokasi file anda: "+path);
                            }
                            break;
            }

        } catch (JRException ex) {System.out.println(ex.getMessage());}
        catch(Exception e){}
    }

}
