/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dickanirwansyah.accordion.service;

import com.dickanirwansyah.accordion.entity.Mobil;
import java.util.List;

/**
 *
 * @author java-spring
 */

public interface MobilService {
    
    List<Mobil> findAllMobil();
    
    List<Mobil> findMobilByActive();
    
    Mobil findMobilById(int idmobil);
    
}
