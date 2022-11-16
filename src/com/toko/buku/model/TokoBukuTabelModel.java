/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.buku.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TokoBukuTabelModel extends AbstractTableModel {
    private List<TokoBuku> listTokoBuku = new ArrayList();
    private final String HEADER[] = {"Kode Buku", "Nama Buku", "Harga Buku", "Stock Buku"};

    public TokoBukuTabelModel(List<TokoBuku> listTokoBuku) {
        this.listTokoBuku = listTokoBuku;
    }
    
    
    @Override
    public int getRowCount() {
        return listTokoBuku.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TokoBuku tokoBuku = listTokoBuku.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return tokoBuku.getKd_buku();
            case 1:
                return tokoBuku.getNama();
            case 2:
                return tokoBuku.getHarga();
            case 3:
                return tokoBuku.getStock();
            default:
                return null;
        }
    }
    
    public String getColumnName(int index){
        return HEADER[index];
    }
    
}

