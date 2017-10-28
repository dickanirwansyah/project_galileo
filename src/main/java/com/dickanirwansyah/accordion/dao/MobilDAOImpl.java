/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.Mobil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author java-spring
 */
@Repository("mobilDAO")
public class MobilDAOImpl implements MobilDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Mobil> findAllMobil() {
      String hql = "FROM Mobil as mobile ORDER BY mobile.idmobil DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Mobil> findByActiveMobil() {
      String hql = "SELECT f FROM Mobil f WHERE f.active = true";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      return query.list();
    }

    @Override
    public Mobil findOneMobilById(int idmobil) {
     return (Mobil) sessionFactory
             .getCurrentSession()
             .get(Mobil.class, idmobil);
    }

    @Override
    public void insertMobil(Mobil mobil) {
      sessionFactory.getCurrentSession().save(mobil);
    }

    @Override
    public void updateMobil(Mobil mobil) {
     sessionFactory.getCurrentSession().update(mobil);
    }

    @Override
    public void deleteMobil(Mobil mobil) {
      sessionFactory.getCurrentSession().delete(mobil);
    }

    @Override
    public boolean ifNameMobilIsExist(String name) {
       String hql = "FROM Mobil as mobil WHERE mobil.name=?";
       int count = sessionFactory.getCurrentSession().createQuery(hql)
               .setParameter(1, name).list().size();
       return count > 0 ? true : false;
    }
    
}
