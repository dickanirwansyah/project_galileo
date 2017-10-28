/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.entity.Kategori;
import java.util.List;

/**
 *
 * @author java-spring
 */
public interface KategoriService {
    
    void insertKategori(Kategori kategori);
    
    void updateKategori(Kategori kategori);
    
    void deleteKategori(Kategori kategori);
    
    List<Kategori> findAllKategori();
    
    Kategori findOneKategori(int idkategori);
    
    List<Kategori> findKategoriByActive();
}
