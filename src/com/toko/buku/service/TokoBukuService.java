/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toko.buku.service;

import com.toko.buku.model.TokoBuku;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TokoBukuService {
    public void save(TokoBuku tokobuku);
    public void update(TokoBuku tokobuku);
    public void delete(TokoBuku tokobuku);
    //public TokoBuku get(String kd_buku);
    public List<TokoBuku> getList();
}
