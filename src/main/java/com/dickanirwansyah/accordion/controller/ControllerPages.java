/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.controller;

import com.dickanirwansyah.accordion.entity.Kategori;
import com.dickanirwansyah.accordion.service.MenuAccordionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author java-spring
 */
@Controller
public class ControllerPages {
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ControllerPages.class);
    
    @Autowired
    private MenuAccordionService menuAccordionService;
    
    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView getPages(){
        
        LOGGER.info("Menampilkan : Page root ");
        
        ModelAndView view = new ModelAndView();
        view.setViewName("rootpage/pageroot");
        view.addObject("eventClickHome", true);
        /**
         * menu accordion
         */
        view.addObject("accordion", menuAccordionService.listMenuAccordion());
        view.addObject("title", "Home");
        return view;
    }
    
    @RequestMapping(value = "/data/page/kategori", method = RequestMethod.GET)
    public ModelAndView getPagesKateori(){
        LOGGER.info("Menampilkan : Page Kategori ");
        
        ModelAndView view = new ModelAndView();
        view.setViewName("rootpage/pageroot");
        /*
        * menu accordion
        */
        view.addObject("accordion", menuAccordionService.listMenuAccordion());
        view.addObject("title", "Kategori");
        view.addObject("eventClickKategori", true);
        return view;
    }
    
    @RequestMapping(value = "/data/page/mobil", method = RequestMethod.GET)
    public ModelAndView getPagesMobil(){
        LOGGER.info("Menampilkan : Page Mobil");
        
        ModelAndView view = new ModelAndView();
        view.setViewName("rootpage/pageroot");
        /*
        * menu accordion
         */
        view.addObject("accordion", menuAccordionService.listMenuAccordion());
        view.addObject("title", "Mobil");
        view.addObject("eventClickMobil", true);
        
        return view;
    }
}
