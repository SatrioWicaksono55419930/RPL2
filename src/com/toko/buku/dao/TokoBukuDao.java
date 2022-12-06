package com.toko.buku.dao;

import com.toko.buku.model.TokoBuku;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TokoBukuDao {
    public String save(TokoBuku tokobuku);
    public void update(TokoBuku tokobuku);
    public void delete(TokoBuku tokobuku);
    //public TokoBuku get(String kd_buku);
    public List<TokoBuku> getList();
}
