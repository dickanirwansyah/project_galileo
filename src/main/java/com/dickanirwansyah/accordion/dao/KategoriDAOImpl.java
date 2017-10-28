/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.Kategori;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author java-spring
 */
@Repository("kategoriDAO")
public class KategoriDAOImpl implements KategoriDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void insertKategori(Kategori kategori) {
       sessionFactory.getCurrentSession().save(kategori);
    }

    @Override
    public void updateKategori(Kategori kategori) {
      sessionFactory.getCurrentSession().update(kategori);
    }

    @Override
    public void deleteKategori(Kategori kategori) {
      sessionFactory.getCurrentSession().delete(kategori);
    }

    @Override
    public Kategori findOneKategoriById(int idkategori) {
      return (Kategori) sessionFactory
              .getCurrentSession()
              .get(Kategori.class, idkategori);
    }

    @Override
    public List<Kategori> findAllKategori() {
       String hql = "FROM Kategori as category ORDER BY category.idkategori DESC";
        Query query = sessionFactory.getCurrentSession()
                .createQuery(hql);
        return query.list();
    }

    @Override
    public List<Kategori> findAllKategoriByActive() {
      String hql = "FROM Kategori WHERE active=:active";
      Query query = sessionFactory.getCurrentSession()
              .createQuery(hql).setParameter("active", true);
      return query.list();
    }
    
}
