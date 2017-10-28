/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.Menu;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author java-spring
 */
@Repository("menuDAO")
public class MenuDAOImpl implements MenusDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Menu> listAllMenu() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("From Menu");
        return query.list();
    }

    @Override
    public void insertMenu(Menu menu) {
      sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
      sessionFactory.getCurrentSession().update(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
      sessionFactory.getCurrentSession().delete(menu);
    }

    @Override
    public Menu listMenuById(int idmenus) {
      return (Menu) sessionFactory.getCurrentSession().get(Menu.class, idmenus);
    }
    
}
