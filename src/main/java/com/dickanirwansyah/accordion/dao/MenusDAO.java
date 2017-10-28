/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.Menu;
import java.util.List;

/**
 *
 * @author java-spring
 */
public interface MenusDAO {
    
    List<Menu> listAllMenu();
    
    void insertMenu(Menu menu);
    
    void updateMenu(Menu menu);
    
    void deleteMenu(Menu menu);
    
    Menu listMenuById(int idmenus);
}
