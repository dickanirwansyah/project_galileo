/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.dao.MenuAccordionDAO;
import com.dickanirwansyah.accordion.entity.MenuAccordion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author java-spring
 */
@Transactional
@Service
public class MenuAccordionServiceImpl implements MenuAccordionService{
    
    @Autowired
    private MenuAccordionDAO menuAccordionDAO;

    @Override
    public List<MenuAccordion> listMenuAccordion() {
      return menuAccordionDAO.listMenuAccordion();
    }
    
}
