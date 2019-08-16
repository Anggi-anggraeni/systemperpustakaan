package projectperpus.aplikasi.systemperpustakaan.controller;

import projectperpus.aplikasi.systemperpustakaan.component.PdfFilter;
import projectperpus.aplikasi.systemperpustakaan.entity.Buku;
import projectperpus.aplikasi.systemperpustakaan.entity.Jenis;
import projectperpus.aplikasi.systemperpustakaan.entity.Kategori;
import projectperpus.aplikasi.systemperpustakaan.entity.Penerbit;
import projectperpus.aplikasi.systemperpustakaan.model.BukuModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.JenisTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.KategoriTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.BukuTableModel;
import projectperpus.aplikasi.systemperpustakaan.tablemodel.PenerbitTableModel;
import projectperpus.aplikasi.systemperpustakaan.utility.FilterUtility;
import projectperpus.aplikasi.systemperpustakaan.utility.NumberUtility;
import projectperpus.aplikasi.systemperpustakaan.view.buku.DialogPenerbitDetail;
import projectperpus.aplikasi.systemperpustakaan.view.buku.DialogJenisDetail;
import projectperpus.aplikasi.systemperpustakaan.view.buku.DialogKategoriDetail;
import projectperpus.aplikasi.systemperpustakaan.view.buku.DialogBukuDetail;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameBukuView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameJenisView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FrameKategoriView;
import projectperpus.aplikasi.systemperpustakaan.view.buku.FramePenerbitView;
import java.awt.Component;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

public class BukuController {
    FrameBukuView bukuView;
    DialogBukuDetail bukuDetail;
    BukuModel model;
    Buku buku;
    FrameKategoriView kategoriView;
    DialogKategoriDetail kategoriDetail;
    FrameJenisView jenisView;
    DialogJenisDetail jenisDetail;
    FramePenerbitView penerbitView;
    DialogPenerbitDetail penerbitDetail;
    private Component framePeminjaman;

    public BukuController() { }

    public BukuController(FrameBukuView bukuView, BukuModel model) {
        this.bukuView = bukuView; 
        this.model = model;
    }

    public BukuController(FrameKategoriView kategoriView, BukuModel model) {
        this.kategoriView = kategoriView;
        this.model = model;
    }

    public BukuController(FrameJenisView jenisView, BukuModel model) {
        this.jenisView= jenisView;
        this.model = model;
    }

    public BukuModel getModel() {
        return model;
    }

    public BukuController(FramePenerbitView penerbitView, BukuModel model) {
        this.penerbitView= penerbitView;
        this.model = model;
    }

    public void setBukuDetail(DialogBukuDetail bukuDetail) {
        this.bukuDetail = bukuDetail;
    }

    public FrameBukuView getBukuView() {
        return bukuView;
    }

    public void fillComboJenis(JComboBox comboBox){
        comboBox.setModel(new DefaultComboBoxModel(model.getVectorJenis()));
    }

    public void fillComboKategori(JComboBox comboBox){
        comboBox.setModel(new DefaultComboBoxModel(model.getVectorKategori()));
    }

    public void fillComboPenerbit(JComboBox comboBox){
        comboBox.setModel(new DefaultComboBoxModel(model.getVectorPenerbit()));
    }

    public void fillIdComboPenerbit(JComboBox comboBox){
        comboBox.removeAllItems();
        List<Penerbit> list = model.getListPenerbit(-1, "", "", "");
        for(int i=0;i< list.size();i++){comboBox.addItem(list.get(i).getId()); }
    }

    public void changePenerbit(int index){
        Penerbit penerbit = model.getPenerbit(index);
        bukuDetail.getTextPenerbit().setText(penerbit.getNamaPenerbit());
        bukuDetail.getTextAlamat().setText(penerbit.getAlamat());
        bukuDetail.getTextKota().setText(penerbit.getKota());
        bukuDetail.getTextEmail().setText(penerbit.getEmail());
        bukuDetail.getTextTelepon().setText(penerbit.getTelepon());
    }

    public void findListBuku(){
        bukuView.setTableModel(new BukuTableModel());
        bukuView.getTableModel().setListBuku(model.getListBuku(
                bukuView.getComboJenis().getSelectedItem().toString(),
                bukuView.getComboKategori().getSelectedItem().toString(),
                bukuView.getTextJudul().getText(),
                bukuView.getTextPengarang().getText(),
                bukuView.getComboPenerbit().getSelectedItem().toString(),
                bukuView.getOpt())
                );
        bukuView.getTableView().setModel(bukuView.getTableModel());
        bukuView.setTableView();
        bukuView.setBukuId(-1);
    }

    public void refreshListBuku(){
        bukuView.getTextJudul().setText("");
        bukuView.getTextPengarang().setText("");
        bukuView.getComboJenis().setSelectedIndex(0);
        bukuView.getComboKategori().setSelectedIndex(0);
        bukuView.getComboPenerbit().setSelectedIndex(0);
        bukuView.getRadioSemua().setSelected(true);
        bukuView.setOpt(FrameBukuView.PILIH_SEMUA);
        findListBuku();
    }

    public void showDetailBuku(int id){
        buku = model.getBuku(id);
        bukuDetail.getTextId().setText(buku.getId()+"");
        setSelectedJenis(buku.getJenis_id());
        setSelectedKategori(buku.getKategori_id());
        bukuDetail.getTextJudul().setText(buku.getJudul());
        bukuDetail.getTextPengarang().setText(buku.getPengarang());
        bukuDetail.getTextIsbn().setText(buku.getIsbn());
        bukuDetail.getTextTahun().setText(buku.getTahun()+"");
        bukuDetail.getTextTersedia().setText(buku.getJumlah_tersedia()+"");
        bukuDetail.getTextTerpinjam().setText(buku.getJumlah_terpinjam()+"");
        bukuDetail.getTextJumlah().setText(buku.getJumlah_total()+"");
        setSelectedPenerbit(buku.getPenerbit_id());
    }

    public void saveNewBuku(){
        if(bukuDetail.getTextIdJenis().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jenis buku masih kosong");
        }else if(bukuDetail.getTextIdKategori().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Kategori buku masih kosong");
        }else if(bukuDetail.getTextJudul().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Judul buku masih kosong");
        }else if(bukuDetail.getTextPengarang().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Pengarang  buku masih kosong");
        }else if(bukuDetail.getTextIdPanerbit().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Penerbit buku masih kosong");
        }else if(bukuDetail.getTextJumlah().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "JumlahTotal buku masih kosong");
        }else if(bukuDetail.getTextTersedia().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tersedia buku masih kosong");
        }else if(bukuDetail.getTextTerpinjam().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jumlah terpinjam buku masih kosong");
        }else if(bukuDetail.getTextTahun().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Tahun terbit buku masih kosong");
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextJumlah().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tidak valid");
            bukuDetail.getTextJumlah().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTahun().getText())){
            JOptionPane.showMessageDialog(bukuView, "Tahun tidak valid");
            bukuDetail.getTextTahun().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTersedia().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tersedia tidak valid");
            bukuDetail.getTextTersedia().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTerpinjam().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah terpinjam tidak valid");
            bukuDetail.getTextTerpinjam().requestFocus();
        }else{
            if(model.insertBuku(createBuku())){
                JOptionPane.showMessageDialog(bukuView, "Simpan data buku sukses");
                bukuDetail.dispose();
                findListBuku();
            }else{
                JOptionPane.showMessageDialog(bukuView, "Simpan data buku gagal");
            }
        }
    }

    public void saveUpdateBuku(){
        if(bukuDetail.getTextIdJenis().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jenis buku masih kosong");
        }else if(bukuDetail.getTextIdKategori().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Kategori buku masih kosong");
        }else if(bukuDetail.getTextJudul().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Judul buku masih kosong");
        }else if(bukuDetail.getTextPengarang().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Pengarang  buku masih kosong");
        }else if(bukuDetail.getTextIdPanerbit().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Penerbit buku masih kosong");
        }else if(bukuDetail.getTextJumlah().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "JumlahTotal buku masih kosong");
        }else if(bukuDetail.getTextTersedia().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tersedia buku masih kosong");
        }else if(bukuDetail.getTextTerpinjam().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Jumlah terpinjam buku masih kosong");
        }else if(bukuDetail.getTextTahun().getText().equals("")){
            JOptionPane.showMessageDialog(bukuView, "Tahun terbit buku masih kosong");
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextJumlah().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tidak valid");
            bukuDetail.getTextJumlah().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTahun().getText())){
            JOptionPane.showMessageDialog(bukuView, "Tahun tidak valid");
            bukuDetail.getTextTahun().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTersedia().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah tersedia tidak valid");
            bukuDetail.getTextTersedia().requestFocus();
        }else if(!NumberUtility.isNumberValid(bukuDetail.getTextTerpinjam().getText())){
            JOptionPane.showMessageDialog(bukuView, "Jumlah terpinjam tidak valid");
            bukuDetail.getTextTerpinjam().requestFocus();
        }else{
            buku = createBuku();
            buku.setId(bukuView.getBukuId());
            if(model.updateBuku(buku)){
                JOptionPane.showMessageDialog(bukuView, "Update data buku sukses");
                bukuDetail.dispose();
                findListBuku();
            }else{
                JOptionPane.showMessageDialog(bukuView, "Update data buku gagal");
            }
        }
    }

    public void saveDeleteBuku() {
        if(JOptionPane.showConfirmDialog(bukuView, "Apakah anda yakin menghapus data ini?","Hapus data",
                JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_OPTION){
                if(model.deleteBuku(bukuView.getBukuId())){
                    JOptionPane.showMessageDialog(bukuView, "Delete data buku sukses");
                    findListBuku();
                }else{
                    JOptionPane.showMessageDialog(bukuView, "Delete data buku gagal");
                }
        }
    }

    private Buku createBuku() {
        buku = new Buku(
                0,
                Integer.valueOf(bukuDetail.getTextIdJenis().getText()),
                Integer.valueOf(bukuDetail.getTextIdKategori().getText()),
                bukuDetail.getTextJudul().getText(),
                bukuDetail.getTextPengarang().getText(),
                Integer.valueOf(bukuDetail.getTextIdPanerbit().getText()),
                bukuDetail.getTextIsbn().getText(),
                Integer.valueOf(bukuDetail.getTextTahun().getText()),
                Integer.valueOf(bukuDetail.getTextTersedia().getText()),
                Integer.valueOf(bukuDetail.getTextTerpinjam().getText()),
                Integer.valueOf(bukuDetail.getTextJumlah().getText())
                );
        return buku;
    }

public void findListKategori(){
    int idKategori = -1;
    if(!kategoriView.getTextNo().getText().equals("")){
        try {
            idKategori = Integer.valueOf(kategoriView.getTextNo().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(kategoriView, "Field ini harus diisi dengan angka");
             kategoriView.getTextNo().setText("");
             idKategori = 0;
        }
    }
    kategoriView.getTableKategori().setModel(new KategoriTableModel(model.getListKategori(idKategori, kategoriView.getTextKategori().getText())));
    kategoriView.setWidth();
    kategoriView.setIdKategori(-1);
}

public void refreshListKategori(){
    kategoriView.getTextNo().setText("");
    kategoriView.getTextKategori().setText("");
    findListKategori();
}

    public void saveNewKategori() {
        if(kategoriDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(kategoriView, "Nama Kategori masih kosong");
            kategoriDetail.getTextNama().requestFocus();
        }else{
            if(model.insertKategori(kategoriDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(kategoriView, "Kategori Buku sukses disimpan");
                findListKategori();
                kategoriDetail.dispose();
            }else
                JOptionPane.showMessageDialog(kategoriView, "Simpan kategori baru gagal");
        }       
    }

    public void saveUpdateKategori() {
        if(kategoriDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(kategoriView, "Nama Kategori masih kosong");
            kategoriDetail.getTextNama().requestFocus();
        }else{
            if(model.updateKategori(kategoriView.getIdKategori(),kategoriDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(kategoriView, "Kategori Buku sukses diupdate");
                findListKategori();
                kategoriDetail.dispose();
            }else
                JOptionPane.showMessageDialog(kategoriView, "Update kategori gagal");
        }
    }

    public void showDetailKategori(int idKategori) {
        Kategori kategori = model.getKategori(idKategori);
        kategoriDetail.getTextNo().setText(kategori.getId()+"");
        kategoriDetail.getTextNama().setText(kategori.getNamaKategori());
        kategoriDetail.getTextNo().setEditable(false);
    }

    public void setDialogKategoriDetail(DialogKategoriDetail kategoriDetail){
        this.kategoriDetail = kategoriDetail;
    }

    public FrameKategoriView getKategoriView() {
        return kategoriView;
    }

    public FramePenerbitView getPenerbitView() {
        return penerbitView;
    }

    public void saveDeleteKategori() {
        if(JOptionPane.showConfirmDialog(kategoriView, "Apakah anda yakin akan menghapus kategori ini?","Hapus data",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deleteKategori(kategoriView.getIdKategori()))
                JOptionPane.showMessageDialog(kategoriView, "Kategori sukses dihapus");
            else
                JOptionPane.showMessageDialog(kategoriView, "Kategori gagal dihapus");
            findListKategori();
        }
    }

    public void findListJenis() {
        int idJenis = -1;
        if(!jenisView.getTextNo().getText().equals("")){
            try {
                idJenis = Integer.valueOf(jenisView.getTextNo().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jenisView, "Field ini harus diisi dengan angka");
                jenisView.getTextNo().setText("");
                idJenis = 0;
            }
        }
        jenisView.getTabelJenis().setModel(new JenisTableModel(model.getListJenis(idJenis,jenisView.getTextNama().getText())));
        jenisView.setWidth();
        jenisView.setIdJenis(-1);
    }
    
    public void refreshListJenis() {
        jenisView.getTextNama().setText("");
        jenisView.getTextNo().setText("");
        findListJenis();
    }

    public void setJenisDetail(DialogJenisDetail jenisDetail) {
        this.jenisDetail = jenisDetail;
    }

    public void showDetailJenis(int idJenis) {
        Jenis jenis = model.getJenis(idJenis);
        jenisDetail.getTextNo().setText(jenis.getId()+"");
        jenisDetail.getTextNama().setText(jenis.getNama_jenis());
        jenisDetail.getTextNo().setEditable(false);
    }

    public void saveNewJenis() {
        if(jenisDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(jenisDetail, "Nama Jenis buku masih kosong");
            jenisDetail.getTextNama().requestFocus();
        }else{
            if(model.insertJenis(jenisDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(jenisDetail, "Simpan Jenis baru sukses");
                findListJenis();
                jenisDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(jenisView, "Simpan jenis buku gagal");
            }
        }
    }

    public void saveUpdateJenis() {
        if(jenisDetail.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(jenisDetail, "Nama Jenis buku masih kosong");
            jenisDetail.getTextNama().requestFocus();
        }else{
            if(model.updateJenis(jenisView.getIdJenis(),jenisDetail.getTextNama().getText())){
                JOptionPane.showMessageDialog(jenisDetail, "Update Jenis baru sukses");
                findListJenis();
                jenisDetail.dispose();
            }else{
                JOptionPane.showMessageDialog(jenisView, "Udate jenis buku gagal");
            }
        }
    }

    public void saveDeleteJenis() {
        if(JOptionPane.showConfirmDialog(jenisView, "Apakah anda yakinakan mengahapus data ini?","Hapus data",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deleteJenis(jenisView.getIdJenis())){
                JOptionPane.showMessageDialog(jenisView, "Hapus data jenis sukses");
                findListJenis();
            }else{
                JOptionPane.showMessageDialog(jenisView, "Hapus data jenis gagal");
            }
        }
    }

    public FrameJenisView getJenisView() {
        return jenisView;
    }

    public void findListPenerbit() {
        int idPenerbit = -1;
        if(!penerbitView.getTextIdPenerbit().getText().equals("")){
            try {
                idPenerbit = Integer.valueOf(penerbitView.getTextIdPenerbit().getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(kategoriView, "Field ini harus diisi dengan angka");
                 penerbitView.getTextIdPenerbit().setText("");
                 idPenerbit = 0;
            }
        }
        penerbitView.setTableModel(new PenerbitTableModel());
        penerbitView.getTableModel().setListPenerbit(model.getListPenerbit(
                idPenerbit,
                penerbitView.getTextnama().getText(),
                penerbitView.getTextKota().getText(),
                penerbitView.getTextEmail().getText()));
        penerbitView.getTablePenerbit().setModel(penerbitView.getTableModel());
        penerbitView.setTableWidth();
        penerbitView.setIdPenerbit(-1);
    }

    public void refreshListPenerbit() {
        penerbitView.getTextIdPenerbit().setText("");
        penerbitView.getTextnama().setText("");
        penerbitView.getTextKota().setText("");
        penerbitView.getTextEmail().setText("");
        findListPenerbit();
    }

    public void setPenerbitDetail(DialogPenerbitDetail penerbitDetail) {
        this.penerbitDetail = penerbitDetail;
    }

    public void showDetailPenerbit(int idPenerbit) {
        Penerbit penerbit = model.getPenerbit(idPenerbit);
        penerbitDetail.getTextIdPenerbit().setText(penerbit.getId()+"");
        penerbitDetail.getTextnama().setText(penerbit.getNamaPenerbit());
        penerbitDetail.getTextAlamat().setText(penerbit.getAlamat());
        penerbitDetail.getTextKota().setText(penerbit.getKota());
        penerbitDetail.getTextEmail().setText(penerbit.getEmail());
        penerbitDetail.getTextTelepon().setText(penerbit.getTelepon());
    }

    public void saveNewPenerbit() {
        if(penerbitDetail.getTextnama().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Nama penerbit masih kosong");
            penerbitDetail.getTextnama().requestFocus();
        }else if(penerbitDetail.getTextAlamat().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Alamat penerbit masih kosong");
            penerbitDetail.getTextAlamat().requestFocus();
        }else if(penerbitDetail.getTextKota().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Kota penerbit masih kosong");
            penerbitDetail.getTextKota().requestFocus();
        }else{
            Penerbit penerbit = new Penerbit(
                    0, penerbitDetail.getTextnama().getText(),
                    penerbitDetail.getTextAlamat().getText(),
                    penerbitDetail.getTextKota().getText(),
                    penerbitDetail.getTextEmail().getText(),
                    penerbitDetail.getTextTelepon().getText());
            if(model.insertPenerbit(penerbit)){
                JOptionPane.showMessageDialog(kategoriView, "Penerbit baru sukses disimpan");
                findListPenerbit();
                penerbitDetail.dispose();
            }else
                JOptionPane.showMessageDialog(kategoriView, "Penerbit baru gagal disimpan");
        }
    }

    public void saveUpdatePenerbit() {
        if(penerbitDetail.getTextnama().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Nama penerbit masih kosong");
            penerbitDetail.getTextnama().requestFocus();
        }else if(penerbitDetail.getTextAlamat().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Alamat penerbit masih kosong");
            penerbitDetail.getTextAlamat().requestFocus();
        }else if(penerbitDetail.getTextKota().equals("")){
            JOptionPane.showMessageDialog(penerbitView, "Kota penerbit masih kosong");
            penerbitDetail.getTextKota().requestFocus();
        }else{
            Penerbit penerbit = new Penerbit(
                    penerbitView.getIdPenerbit(),
                    penerbitDetail.getTextnama().getText(),
                    penerbitDetail.getTextAlamat().getText(),
                    penerbitDetail.getTextKota().getText(),
                    penerbitDetail.getTextEmail().getText(),
                    penerbitDetail.getTextTelepon().getText());
            if(model.updatePenerbit(penerbit)){
                JOptionPane.showMessageDialog(kategoriView, "Data penerbit sukses diupdate");
                findListPenerbit();
                penerbitDetail.dispose();
            }else
                JOptionPane.showMessageDialog(kategoriView, "Data penerbit gagal diupdate");
        }
    }

    public void saveDeletePenerbit() {
        if(JOptionPane.showConfirmDialog(penerbitView, "Apakah anda yakin akan menghapus data penerbit ini?","Hapus data penerbit",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(model.deletePenerbit(penerbitView.getIdPenerbit())){
                JOptionPane.showMessageDialog(penerbitView, "Hapus data penerbit sukses");
                findListPenerbit();
            }else{
                JOptionPane.showMessageDialog(penerbitView, "Hapus data penerbit gagal");
            }
        }
    }

    public void setSelectedJenis(int idJenis) {
        Jenis jenis = model.getJenis(idJenis);
        bukuDetail.getTextIdJenis().setText(jenis.getId()+"");
        bukuDetail.getTextNamaJenis().setText(jenis.getNama_jenis());
    }

    public void setSelectedKategori(int idKategori) {
        Kategori kategori = model.getKategori(idKategori);
        bukuDetail.getTextIdKategori().setText(kategori.getId()+"");
        bukuDetail.getTextNamaKategori().setText(kategori.getNamaKategori());
    }

    public void setSelectedPenerbit(int idPenerbit) {
        Penerbit penerbit = model.getPenerbit(idPenerbit);
        bukuDetail.getTextIdPanerbit().setText(penerbit.getId()+"");
        bukuDetail.getTextPenerbit().setText(penerbit.getNamaPenerbit());
        bukuDetail.getTextAlamat().setText(penerbit.getAlamat());
        bukuDetail.getTextKota().setText(penerbit.getKota());
        bukuDetail.getTextEmail().setText(penerbit.getEmail());
        bukuDetail.getTextTelepon().setText(penerbit.getTelepon());
}

    public void report(int opt){
        InputStream stream = getClass().getResourceAsStream("report/BukuReport.jasper");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jenis", bukuView.getComboJenis().getSelectedItem().toString());
        map.put("kategori", bukuView.getComboKategori().getSelectedItem().toString());
        map.put("judul", bukuView.getTextJudul().getText());
        map.put("pengarang", bukuView.getTextPengarang().getText());
        map.put("penerbit", bukuView.getComboPenerbit().getSelectedItem().toString());
        map.put("opt", bukuView.getOpt());
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
