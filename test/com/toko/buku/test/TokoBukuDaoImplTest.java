package com.toko.buku.test;

import com.toko.buku.dao.TokoBukuDao;
import com.toko.buku.model.TokoBuku;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TokoBukuDaoImplTest {
    @Autowired
    TokoBukuDao tokoBukuDao;
    
    TokoBuku tokoBuku = new TokoBuku();
    
    @Test
    public void testSave(){
        String kode = "BHS001";
        
        tokoBuku.setKd_buku(kode);
        tokoBuku.setNama("TestNama");
        tokoBuku.setHarga(65000);
        tokoBuku.setStock("Habis");
        
        String res = tokoBukuDao.save(tokoBuku);
        assertTrue(res.equals(kode));
    }
}
