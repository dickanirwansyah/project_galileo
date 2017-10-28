/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.dao.MenusDAO;
import com.dickanirwansyah.accordion.entity.Menu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author java-spring
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    
    @Autowired
    private MenusDAO menusDAO;

    @Override
    public List<Menu> listMenu() {
        return menusDAO.listAllMenu();
    }

    @Override
    public Menu ListMenuById(int idmenus) {
      return menusDAO.listMenuById(idmenus);
    }

    @Override
    public void insertMenu(Menu menu) {
     menusDAO.insertMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
     menusDAO.updateMenu(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        menusDAO.deleteMenu(menu);
    }
    
}
