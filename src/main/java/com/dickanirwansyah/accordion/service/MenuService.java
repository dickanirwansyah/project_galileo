/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.entity.Menu;
import java.util.List;

/**
 *
 * @author java-spring
 */
public interface MenuService {
    
    List<Menu> listMenu();
    
    Menu ListMenuById(int idmenus);
    
    void insertMenu(Menu menu);
    
    void updateMenu(Menu menu);
    
    void deleteMenu(Menu menu);
}
