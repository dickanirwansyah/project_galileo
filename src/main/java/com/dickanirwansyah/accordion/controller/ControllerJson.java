/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.controller;

import com.dickanirwansyah.accordion.entity.Kategori;
import com.dickanirwansyah.accordion.entity.Menu;
import com.dickanirwansyah.accordion.entity.Mobil;
import com.dickanirwansyah.accordion.service.KategoriService;
import com.dickanirwansyah.accordion.service.MenuService;
import com.dickanirwansyah.accordion.service.MobilService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author java-spring
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"*"})
public class ControllerJson {
    
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ControllerJson.class);
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private KategoriService kategoriService;
    
    @Autowired
    private MobilService mobilService;
    
    //------findAll mobil-------------//
    @GetMapping(value = "/data/list/mobils", produces = "application/json")
    public ResponseEntity<List<Mobil>>findAllMobils(){
        
        LOGGER.info("Menampilkan data / list mobil ");
        
        List<Mobil> listmobils = mobilService.findAllMobil();
        
        if(listmobils.isEmpty()){
            LOGGER.info("Data tidak ada atau kosong !");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<List<Mobil>>(listmobils, HttpStatus.OK);
    }
    
    //--------------find mobil berdasarkan ke aktivan active true-------------//
    @GetMapping(value = "/data/list/mobils/aktiv", produces = "application/json")
    public ResponseEntity<List<Mobil>>findMobileByActive(){
        
        LOGGER.info("Menampilkan data mobil berdasarkan keaktivan ");
        
        List<Mobil> listmobilsactive = mobilService.findMobilByActive();
        
        if(listmobilsactive.isEmpty()){
            LOGGER.info("Data kosong !");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<List<Mobil>>(listmobilsactive, HttpStatus.OK);
    }
    
    //-----find one kategori---------//
    @GetMapping(value = "/data/getkategori/{idkategori}/show")
    public ResponseEntity<Kategori>findOneKategori(@PathVariable String idkategori){
        
        LOGGER.info("Menampilkan data kategori berdasarkan kode");
        
        Kategori kategori = kategoriService.findOneKategori(Integer.parseInt(idkategori));
        
        if(kategori == null){
            LOGGER.info("Data kategori berdasarkan kode tidak ada !");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<Kategori>(kategori, HttpStatus.ACCEPTED);
    }
    
    @PutMapping(value = "/data/update/kategori")
    public ResponseEntity<Void>updateKategori(@RequestBody Kategori kategori){
        
        LOGGER.info("proses update data");

        if(kategori.getIdkategori() != 0){
        kategoriService.updateKategori(kategori);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    
    //-------deleted kategori by idkategori---------//
    @DeleteMapping(value = "/data/delete/{idkategori}/dropkategori")
    public ResponseEntity<Void>deleteKategori(@PathVariable String idkategori){
        
        LOGGER.info("delete data kategori" + idkategori);
        
        Kategori kategori = kategoriService.findOneKategori(Integer.parseInt(idkategori));
        
        kategoriService.deleteKategori(kategori);
        
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    
    //------list all kategori------------//
    @GetMapping(value = "/data/list/kategoris")
    public ResponseEntity<List<Kategori>> getDataKategoris(){
        
        List<Kategori> listkategori = kategoriService.findAllKategori();
        
        if(listkategori.isEmpty()){
            LOGGER.info("Data Kategori tidak ada ");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            LOGGER.info("Menampilkan list kategori");
        return new ResponseEntity<List<Kategori>>(listkategori, HttpStatus.OK);
    }
    
    @PostMapping(value = "/data/insert/kategoris")
    public ResponseEntity<Void> insertKategori(@RequestBody Kategori kategori){
        
        LOGGER.info("proses menyimpan data");
        
        kategoriService.insertKategori(kategori);
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    //-----list kategori by active-----------//
    @GetMapping(value = "/data/list/kategoris/active")
    public ResponseEntity<List<Kategori>> getDataKategorisByAktiv(){
        
        List<Kategori> listkategori = kategoriService.findKategoriByActive();
        
        if(listkategori.isEmpty()){
            LOGGER.info("Data yang anda maksud tidak ada");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            LOGGER.info("Menampilkan data aktive kategori");
            return new ResponseEntity<List<Kategori>>(listkategori, HttpStatus.OK);
    }

    //---------list menus----------//
    @GetMapping(value = "/data/list/menus")
    @ResponseBody
    public ResponseEntity<List<Menu>> getDataMenus(){
        
        List<Menu> listallmenus = menuService.listMenu();
        
        if(listallmenus.isEmpty()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Menampilkan data menu" +  listallmenus);
        return new ResponseEntity<List<Menu>>(listallmenus, HttpStatus.OK);
    }
    
    //----------------insert data menu---------//
    @PostMapping(value = "/data/insert/menus", produces = "application/json")
    public ResponseEntity<Void> insertDataMenus(@RequestBody Menu menu){
        
        menuService.insertMenu(menu);
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    //-------------update data menu ------------//
    @PutMapping(value = "/data/update/menus", produces = "application/json")
    public ResponseEntity<Void> updateDataMenus(@RequestBody Menu menu){
        
        menuService.updateMenu(menu);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    //---------------getdata menu by id----------------//
    @GetMapping(value = "/data/get/menus/{idmenus}", produces = "application/json")
    public ResponseEntity<Menu> byIdmenus(@PathVariable String idmenus){
        
        Menu m = menuService.ListMenuById(Integer.parseInt(idmenus));
        
        if(m == null){
            System.out.println("Data tidak ada");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        System.out.println("Menampilkan data : "+m);
        return new ResponseEntity<Menu>(m, HttpStatus.OK);
    }
    
    //---------------delete data menus---------------------//
    @DeleteMapping(value = "/data/delete/menus/{idmenus}", produces = "application/json")
    public ResponseEntity<Void> deleteDataMenus(@PathVariable String idmenus){
        
        Menu m = menuService.ListMenuById(Integer.parseInt(idmenus));
        
        menuService.deleteMenu(m);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
