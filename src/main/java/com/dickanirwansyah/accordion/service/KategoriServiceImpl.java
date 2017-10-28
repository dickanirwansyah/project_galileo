/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.dao.KategoriDAO;
import com.dickanirwansyah.accordion.entity.Kategori;
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
public class KategoriServiceImpl implements KategoriService{

    @Autowired
    private KategoriDAO kategoriDAO;
    
    @Override
    public void insertKategori(Kategori kategori) {
      kategoriDAO.insertKategori(kategori);
    }

    @Override
    public void updateKategori(Kategori kategori) {
      kategoriDAO.updateKategori(kategori);
    }

    @Override
    public void deleteKategori(Kategori kategori) {
      kategoriDAO.deleteKategori(kategori);
    }

    @Override
    public List<Kategori> findAllKategori() {
      return kategoriDAO.findAllKategori();
    }

    @Override
    public Kategori findOneKategori(int idkategori) {
      return kategoriDAO.findOneKategoriById(idkategori);
    }

    @Override
    public List<Kategori> findKategoriByActive() {
      return kategoriDAO.findAllKategoriByActive();
    }
    
}
