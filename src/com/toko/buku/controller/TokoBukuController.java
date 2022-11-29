package com.toko.buku.controller;

//import com.toko.buku.config.HibernateUtil;
//import com.toko.buku.dao.TokoBukuDao;
import static com.toko.buku.app.TokoBukuApp.getTokoBukuService;
import com.toko.buku.model.TokoBuku;
import com.toko.buku.model.TokoBukuTabelModel;
import com.toko.buku.view.TokoBukuView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class TokoBukuController {
    private TokoBukuView tokoBukuView;
    private List<TokoBuku> listTokoBuku;
    private TokoBukuTabelModel tokoBukuTabelModel;
//    private final TokoBukuDao tokoBukuDao = HibernateUtil.getTokoBukuDao();
    
    public TokoBukuController(TokoBukuView tokoBukuView) {
        this.tokoBukuView = tokoBukuView;
    }
    
    public void clear(){
        this.tokoBukuView.getTxtKode().setText("");
        this.tokoBukuView.getTxtNama().setText("");
        this.tokoBukuView.getTxtHarga().setText("");
        this.tokoBukuView.getTxtStock().setText("");
    }
    
    public void saveBuku() {
        TokoBuku tokoBuku = new TokoBuku();
        tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
        tokoBuku.setNama(this.tokoBukuView.getTxtNama().getText());
        tokoBuku.setHarga(Integer.parseInt(this.tokoBukuView.getTxtHarga().getText()));
        tokoBuku.setStock(this.tokoBukuView.getTxtStock().getText());
        
        try{
            getTokoBukuService().save(tokoBuku);
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan Buku", "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal menyimpan Buku", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void updateBuku() {
        TokoBuku tokoBuku = new TokoBuku();
        tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
        tokoBuku.setNama(this.tokoBukuView.getTxtNama().getText());
        tokoBuku.setHarga(Integer.parseInt(this.tokoBukuView.getTxtHarga().getText()));
        tokoBuku.setStock(this.tokoBukuView.getTxtStock().getText());
        
        try{
            getTokoBukuService().update(tokoBuku);
            JOptionPane.showMessageDialog(null, "Berhasil mengubah Buku", "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal mengubah Buku", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void deleteBuku(){
        if(this.tokoBukuView.getTxtKode().getText() == null){
            JOptionPane.showMessageDialog(null, "Data Belum Dipilh", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            TokoBuku tokoBuku = new TokoBuku();
            tokoBuku.setKd_buku(this.tokoBukuView.getTxtKode().getText());
            
            int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus ini?", "Warning", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                try{
                    getTokoBukuService().delete(tokoBuku);
                    JOptionPane.showMessageDialog(null, "Berhasil menghapus Buku", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    getAllData();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Gagal menghapus Buku", "Error", JOptionPane.INFORMATION_MESSAGE);    
                }
            }
        }
    }
    
    public void getAllData(){
        listTokoBuku = getTokoBukuService().getList();
        tokoBukuTabelModel = new TokoBukuTabelModel(listTokoBuku);
        this.tokoBukuView.getTblBuku().setModel(tokoBukuTabelModel);
    }
    
    public void getdata(){
        int rowIndex = this.tokoBukuView.getTblBuku().getSelectedRow();
        this.tokoBukuView.getTxtKode().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 0)));
        this.tokoBukuView.getTxtNama().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 1)));
        this.tokoBukuView.getTxtHarga().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 2)));
        this.tokoBukuView.getTxtStock().setText(String.valueOf(this.tokoBukuView.getTblBuku().getValueAt(rowIndex, 3)));
    }
}

