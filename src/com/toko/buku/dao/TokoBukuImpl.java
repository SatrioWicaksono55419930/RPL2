package com.toko.buku.dao;

import com.toko.buku.model.TokoBuku;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class TokoBukuImpl implements TokoBukuDao {
    @Autowired
    private SessionFactory sessionFactory;
//
//    public TokoBukuImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    
    
    @Override
    public String save(TokoBuku tokobuku) {
        Serializable res = sessionFactory.getCurrentSession().save(tokobuku);
        return String.valueOf(res);
//        try{
//            session.beginTransaction();
//            session.save(tokobuku);
//            session.getTransaction().commit();
//        }catch(Exception e){
//            System.err.print("Tidak dapat menyimpan data buku yang ada");
//            session.getTransaction().rollback();
//        }
//        finally{
//            session.close();
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TokoBuku tokobuku) {
        sessionFactory.getCurrentSession().update(tokobuku);
//        Session session = sessionFactory.openSession();
//        try{
//            session.beginTransaction();
//            session.update(tokobuku);
//            session.getTransaction().commit();
//        }catch(Exception e){
//            System.err.print("Tidak dapat mengubah data buku yang ada");
//            session.getTransaction().rollback();
//        }
//        finally{
//            session.close();
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TokoBuku tokobuku) {
        sessionFactory.getCurrentSession().delete(tokobuku);
//        Session session = sessionFactory.openSession();
//        try{
//            session.beginTransaction();
//            session.delete(tokobuku);
//            session.getTransaction().commit();
//        }catch(Exception e){
//            System.err.print("Tidak dapat menghapus data buku yang ada");
//            session.getTransaction().rollback();
//        }
//        finally{
//            session.close();
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public TokoBuku get(String kd_buku) {
//        Session session = sessionFactory.openSession();
//        try{
//            session.beginTransaction();
//            TokoBuku tokobuku = (TokoBuku) session.get(TokoBuku.class, kd_buku);
//            session.getTransaction().commit();
//            return tokobuku;
//        }catch(Exception e){
//            System.err.print("Tidak dapat menampilkan data buku yang ada");
//            session.getTransaction().rollback();
//            return null;
//        }
//        finally{
//            session.close();
//        }
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public List<TokoBuku> getList() {
        return sessionFactory.getCurrentSession().createCriteria(TokoBuku.class).list();
//        Session session = sessionFactory.openSession();
//        try{
//            session.beginTransaction();
//            List<TokoBuku> listbuku = session.createCriteria(TokoBuku.class) .list();
//            session.getTransaction().commit();
//            return listbuku;
//        }catch(Exception e){
//            System.err.print("Tidak ada list buku yang ada");
//            session.getTransaction().rollback();
//            return null;
//        }
//        finally{
//            session.close();
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
