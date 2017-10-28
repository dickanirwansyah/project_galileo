/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.MenuAccordion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author java-spring
 */
@Repository("menuAccordionDAO")
public class MenuAccordionDAOImpl implements MenuAccordionDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<MenuAccordion> listMenuAccordion() {
      String hql = "FROM MenuAccordion WHERE accordion = null";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
    
}
