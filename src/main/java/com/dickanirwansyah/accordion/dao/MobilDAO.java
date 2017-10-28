/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.dao;

import com.dickanirwansyah.accordion.entity.Mobil;
import java.util.List;

/**
 *
 * @author java-spring
 */
public interface MobilDAO {
    
    List<Mobil> findAllMobil();
    
    List<Mobil> findByActiveMobil();
    
    Mobil findOneMobilById(int idmobil);
    
    void insertMobil(Mobil mobil);
    
    void updateMobil(Mobil mobil);
    
    void deleteMobil(Mobil mobil);
    
    boolean ifNameMobilIsExist(String name);
}
